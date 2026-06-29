package com.example.ordemService.service;

import com.example.ordemService.dto.ClientRequestDTO;
import com.example.ordemService.dto.ClientResponseDTO;
import com.example.ordemService.model.ClienteModel;
import com.example.ordemService.repository.ClienteRepository;
import jakarta.websocket.ClientEndpointConfig;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    private ClienteRepository clienteRepository;
    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    private ClientResponseDTO converterParaDto(ClienteModel cliente) {
        return new ClientResponseDTO(cliente.getId(), cliente.getNome(), cliente.getTelefone(), cliente.getEmail());
    }

    public ClientResponseDTO adcClientDto(ClientRequestDTO dto) {
        ClienteModel cliente = new ClienteModel();
        cliente.setNome(dto.getNome());
        cliente.setTelefone(dto.getTelefone());
        cliente.setEmail(dto.getEmail());
        ClienteModel clienteSalvo = clienteRepository.save(cliente);
        return converterParaDto(clienteSalvo);
    }

    public List <ClientResponseDTO> listarClienteDto(){
            return clienteRepository.findAll()
                    .stream()
                    .map(cliente -> converterParaDto(cliente))
                    .toList();
    }

    public ClientResponseDTO procurarClienteDto(Long id){
        ClienteModel cliente = clienteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("CLIENTE NAO ENCONTRADO"));
         return converterParaDto(cliente);
    }

    public void deletar(Long id){
      ClienteModel cliente = clienteRepository.findById(id)
              .orElseThrow(() -> new RuntimeException("CLIENTE NAO ENCONTRADO"));
      clienteRepository.delete(cliente);

    }
    public ClientResponseDTO atualizarDadosDto(Long id, ClientRequestDTO dto){
        ClienteModel existente = clienteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("CLIENTE NAO ENCONTRADO"));
                existente.setEmail(dto.getEmail());
                existente.setNome(dto.getNome());
                existente.setTelefone(dto.getTelefone());

                ClienteModel clienteSalvo = clienteRepository.save(existente);

                return converterParaDto(clienteSalvo);
    }






}

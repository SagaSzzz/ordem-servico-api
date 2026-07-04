package com.example.ordemService.service;

import com.example.ordemService.dto.ClienteRequestDTO;
import com.example.ordemService.dto.ClienteResponseDTO;
import com.example.ordemService.exceptions.ClienteNaoEncontradoException;
import com.example.ordemService.exceptions.VinculadoException;
import com.example.ordemService.model.ClienteModel;
import com.example.ordemService.repository.ClienteRepository;
import com.example.ordemService.repository.OrdemServicoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    private ClienteRepository clienteRepository;
    private OrdemServicoRepository ordemServicoRepository;

    public ClienteService(ClienteRepository clienteRepository, OrdemServicoRepository ordemServicoRepository) {
        this.clienteRepository = clienteRepository;
        this.ordemServicoRepository = ordemServicoRepository;
    }

    private ClienteResponseDTO converterParaDto(ClienteModel cliente) {
        return new ClienteResponseDTO(cliente.getId(), cliente.getNome(), cliente.getTelefone(), cliente.getEmail());
    }

    public ClienteResponseDTO adcClientDto(ClienteRequestDTO dto) {
        ClienteModel cliente = new ClienteModel();
        cliente.setNome(dto.getNome());
        cliente.setTelefone(dto.getTelefone());
        cliente.setEmail(dto.getEmail());
        ClienteModel clienteSalvo = clienteRepository.save(cliente);
        return converterParaDto(clienteSalvo);
    }

    public List <ClienteResponseDTO> listarClienteDto(){
            return clienteRepository.findAll()
                    .stream()
                    .map(cliente -> converterParaDto(cliente))
                    .toList();
    }

    public ClienteResponseDTO procurarClienteDto(Long id){
        ClienteModel cliente = clienteRepository.findById(id)
                .orElseThrow(() -> new ClienteNaoEncontradoException());
         return converterParaDto(cliente);
    }

    public void deletar(Long id){
      ClienteModel cliente = clienteRepository.findById(id)
              .orElseThrow(() -> new ClienteNaoEncontradoException());

        if (!ordemServicoRepository.findByClienteId(id).isEmpty()){
            throw new VinculadoException("NAO É POSSIVEL DELETAR ENQUANTO CLIENTE ESTIVER VINCULADO AO ORDEM DE SERVICO");
        }
      clienteRepository.delete(cliente);

    }
    public ClienteResponseDTO atualizarDadosDto(Long id, ClienteRequestDTO dto){
        ClienteModel existente = clienteRepository.findById(id)
                .orElseThrow(() -> new ClienteNaoEncontradoException());
                existente.setEmail(dto.getEmail());
                existente.setNome(dto.getNome());
                existente.setTelefone(dto.getTelefone());

                ClienteModel clienteSalvo = clienteRepository.save(existente);

                return converterParaDto(clienteSalvo);
    }






}

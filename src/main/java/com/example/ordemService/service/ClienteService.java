package com.example.ordemService.service;

import com.example.ordemService.model.ClienteModel;
import com.example.ordemService.repository.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    private ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public ClienteModel adcpessoa(ClienteModel cliente){
        return clienteRepository.save(cliente);
    }

    public List <ClienteModel> listarCliente(){
        return clienteRepository.findAll();
    }

    public ClienteModel procurarId(Long id){
        return clienteRepository.findById(id).orElseThrow(()->new RuntimeException("CLIENTE NAO ENCONTRADO"));
    }
    public void deletar(Long id){
        ClienteModel cliente = procurarId(id);
        clienteRepository.delete(cliente);
    }
    public ClienteModel attCliente(Long id, ClienteModel atualizado){
        ClienteModel existente = clienteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("CLIENTE NAO ENCONTRADO"));
                existente.setEmail(atualizado.getEmail());
                existente.setNome(atualizado.getNome());
                existente.setTelefone(atualizado.getTelefone());

                return clienteRepository.save(existente);
    }






}

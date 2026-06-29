package com.example.ordemService.controller;

import com.example.ordemService.dto.ClientRequestDTO;
import com.example.ordemService.dto.ClientResponseDTO;
import com.example.ordemService.model.ClienteModel;
import com.example.ordemService.service.ClienteService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

  private ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @PostMapping
    public ClientResponseDTO adcCliente(@Valid @RequestBody ClientRequestDTO dto){
        return clienteService.adcClientDto(dto);
    }

    @GetMapping
    public List <ClientResponseDTO> buscarCliente(){
        return clienteService.listarClienteDto();
    }

    @GetMapping("/{id}")
    public ClientResponseDTO  procurarId(@PathVariable Long id){
        return clienteService.procurarClienteDto(id);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id){
        clienteService.deletar(id);
    }

    @PutMapping("/{id}")
    public ClientResponseDTO atualizarId(@PathVariable Long id, @Valid @RequestBody ClientRequestDTO dto){
        return clienteService.atualizarDadosDto(id, dto);
    }





}

package com.example.ordemService.controller;

import com.example.ordemService.dto.ClienteRequestDTO;
import com.example.ordemService.dto.ClienteResponseDTO;
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
    public ClienteResponseDTO adcCliente(@Valid @RequestBody ClienteRequestDTO dto){
        return clienteService.adcClientDto(dto);
    }

    @GetMapping
    public List <ClienteResponseDTO> buscarCliente(){
        return clienteService.listarClienteDto();
    }

    @GetMapping("/{id}")
    public ClienteResponseDTO procurarId(@PathVariable Long id){
        return clienteService.procurarClienteDto(id);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id){
        clienteService.deletar(id);
    }

    @PutMapping("/{id}")
    public ClienteResponseDTO atualizarId(@PathVariable Long id, @Valid @RequestBody ClienteRequestDTO dto){
        return clienteService.atualizarDadosDto(id, dto);
    }





}

package com.example.ordemService.controller;

import com.example.ordemService.dto.ClienteRequestDTO;
import com.example.ordemService.dto.ClienteResponseDTO;
import com.example.ordemService.service.ClienteService;
import jakarta.validation.Valid;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity <ClienteResponseDTO> adcCliente(@Valid @RequestBody ClienteRequestDTO dto){
        ClienteResponseDTO clienteCriado = clienteService.adcClientDto(dto);
       return ResponseEntity.status(HttpStatus.CREATED).body(clienteCriado);

    }

    @GetMapping
    public ResponseEntity <List <ClienteResponseDTO>> buscarCliente(){
        return ResponseEntity.ok(clienteService.listarClienteDto());
    }

    @GetMapping("/{id}")
    public ResponseEntity <ClienteResponseDTO> procurarId(@PathVariable Long id){
        return ResponseEntity.ok(clienteService.procurarClienteDto(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id){
        clienteService.deletar(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity <ClienteResponseDTO> atualizarId(@PathVariable Long id, @Valid @RequestBody ClienteRequestDTO dto){
        return ResponseEntity.ok(clienteService.atualizarDadosDto(id,dto));
    }





}

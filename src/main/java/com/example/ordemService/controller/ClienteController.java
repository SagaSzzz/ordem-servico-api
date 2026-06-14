package com.example.ordemService.controller;

import com.example.ordemService.model.ClienteModel;
import com.example.ordemService.service.ClienteService;
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
    public ClienteModel adcCliente(@RequestBody ClienteModel cliente){
        return clienteService.adcpessoa(cliente);
    }

    @GetMapping
    public List <ClienteModel> buscarCliente(){
        return clienteService.listarCliente();
    }
    @GetMapping("/{id}")
    public ClienteModel procurarId(@PathVariable Long id){
        return clienteService.procurarId(id);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id){
        clienteService.deletar(id);
    }

    @PutMapping("/{id}")
    public ClienteModel atualizarId(@PathVariable Long id, @RequestBody ClienteModel cliente){
        return clienteService.attCliente(id, cliente);
    }





}

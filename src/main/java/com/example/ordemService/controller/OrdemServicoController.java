package com.example.ordemService.controller;


import com.example.ordemService.dto.OrdemServicoRequestDTO;
import com.example.ordemService.dto.OrdemServicoResponseDTO;
import com.example.ordemService.enums.StatusOrdem;
import com.example.ordemService.model.OrdemServicoModel;
import com.example.ordemService.service.OrdemServicoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ordemServico")
public class OrdemServicoController {

    private OrdemServicoService ordemServicoService;

    public OrdemServicoController(OrdemServicoService ordemServicoService) {
        this.ordemServicoService = ordemServicoService;
    }

    @PostMapping
    public ResponseEntity <OrdemServicoResponseDTO> adicionarItem(@Valid @RequestBody OrdemServicoRequestDTO dto){
        OrdemServicoResponseDTO criado = ordemServicoService.adicionarItemDto(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(criado);
    }

    @GetMapping
    public ResponseEntity <List<OrdemServicoResponseDTO>> listarItem(){
        return ResponseEntity.ok(ordemServicoService.listarItemDto());
    }

    @GetMapping("/{id}")
    public ResponseEntity <OrdemServicoResponseDTO> procurarId(@PathVariable Long id){
        return ResponseEntity.ok(ordemServicoService.procurarIdDto(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity <OrdemServicoResponseDTO> atualizarItem(@PathVariable Long id, @Valid @RequestBody OrdemServicoRequestDTO dto){
        return ResponseEntity.ok(ordemServicoService.atualizarItemDto(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity <Void> deletar(@PathVariable Long id){
        ordemServicoService.deletar(id);
        return ResponseEntity.noContent().build();
    }



    @GetMapping("/status/{status}")
    public ResponseEntity <List <OrdemServicoResponseDTO>> buscarPorStatus(@PathVariable StatusOrdem status){
        return ResponseEntity.ok(ordemServicoService.buscarPorStatusDto(status));
    }


    @GetMapping("/cliente/{clienteId}")
    public ResponseEntity <List <OrdemServicoResponseDTO>> buscarClienteId(@PathVariable Long clienteId){
        return  ResponseEntity.ok(ordemServicoService.buscarClienteIdDto(clienteId));
    }


    @GetMapping("/equipamento/{equipamentoId}")
    public ResponseEntity <List <OrdemServicoResponseDTO>> buscarEquipamentoId(@PathVariable Long equipamentoId){
        return  ResponseEntity.ok(ordemServicoService.buscarEquipamentoIdDto(equipamentoId));
    }















}

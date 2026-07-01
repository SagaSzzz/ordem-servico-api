package com.example.ordemService.controller;


import com.example.ordemService.dto.OrdemServicoRequestDTO;
import com.example.ordemService.dto.OrdemServicoResponseDTO;
import com.example.ordemService.enums.StatusOrdem;
import com.example.ordemService.service.OrdemServicoService;
import jakarta.validation.Valid;
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
    public OrdemServicoResponseDTO adicionarItem(@Valid @RequestBody OrdemServicoRequestDTO dto){
        return ordemServicoService.adicionarItemDto(dto);
    }

    @GetMapping
    public List<OrdemServicoResponseDTO> listarItem(){
        return ordemServicoService.listarItemDto();
    }

    @GetMapping("/{id}")
    public OrdemServicoResponseDTO procurarId(@PathVariable Long id){
        return ordemServicoService.procurarIdDto(id);
    }

    @PutMapping("/{id}")
    public OrdemServicoResponseDTO atualizarItem(@PathVariable Long id, @Valid @RequestBody OrdemServicoRequestDTO dto){
        return ordemServicoService.atualizarItemDto(id, dto);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id){
        ordemServicoService.deletar(id);
    }



    @GetMapping("/status/{status}")
    public List <OrdemServicoResponseDTO> buscarPorStatus(@PathVariable StatusOrdem status){
        return  ordemServicoService.buscarPorStatusDto(status);
    }


    @GetMapping("/cliente/{clienteId}")
    public List <OrdemServicoResponseDTO> buscarClienteId(@PathVariable Long clienteId){
        return ordemServicoService.buscarClienteIdDto(clienteId);
    }


    @GetMapping("/equipamento/{equipamentoId}")
    public List <OrdemServicoResponseDTO> buscarEquipamentoId(@PathVariable Long equipamentoId){
        return ordemServicoService.buscarEquipamentoIdDto(equipamentoId);
    }















}

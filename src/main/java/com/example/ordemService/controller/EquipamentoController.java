package com.example.ordemService.controller;

import com.example.ordemService.dto.EquipamentoRequestDTO;
import com.example.ordemService.dto.EquipamentoResponseDTO;
import com.example.ordemService.service.EquipamentoService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/equipamento")
public class EquipamentoController {

    private EquipamentoService equipamentoService;

    public EquipamentoController(EquipamentoService equipamentoService) {
        this.equipamentoService = equipamentoService;
    }

    @PostMapping
    public EquipamentoResponseDTO adcEquip(@Valid @RequestBody EquipamentoRequestDTO dto) {
        return equipamentoService.adcEquipDto(dto);
    }


    @GetMapping
    public List<EquipamentoResponseDTO> listarEquip() {
        return equipamentoService.buscarEquipDto();
    }


    @GetMapping("/{id}")
    public EquipamentoResponseDTO procurarId(@PathVariable Long id) {
        return equipamentoService.procurarIdDto(id);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        equipamentoService.deletar(id);
    }


    @PutMapping("/{id}")
    public EquipamentoResponseDTO atualizarEquipamento(@PathVariable Long id, @Valid @RequestBody EquipamentoRequestDTO dto) {

        return equipamentoService.atualizarEquipamentoDto(id, dto);
    }

}


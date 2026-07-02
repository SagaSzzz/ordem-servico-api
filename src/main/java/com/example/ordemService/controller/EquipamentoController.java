package com.example.ordemService.controller;

import com.example.ordemService.dto.EquipamentoRequestDTO;
import com.example.ordemService.dto.EquipamentoResponseDTO;
import com.example.ordemService.service.EquipamentoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity <EquipamentoResponseDTO> adcEquip(@Valid @RequestBody EquipamentoRequestDTO dto) {
        EquipamentoResponseDTO equipamento = equipamentoService.adcEquipDto(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(equipamento);
    }


    @GetMapping
    public ResponseEntity <List<EquipamentoResponseDTO>> listarEquip() {
        return ResponseEntity.ok(equipamentoService.buscarEquipDto());
    }


    @GetMapping("/{id}")
    public ResponseEntity <EquipamentoResponseDTO> procurarId(@PathVariable Long id) {
        return ResponseEntity.ok(equipamentoService.procurarIdDto(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        equipamentoService.deletar(id);
        return ResponseEntity.noContent().build();
    }


    @PutMapping("/{id}")
    public ResponseEntity <EquipamentoResponseDTO> atualizarEquipamento(@PathVariable Long id, @Valid @RequestBody EquipamentoRequestDTO dto) {
        return ResponseEntity.ok(equipamentoService.atualizarEquipamentoDto(id, dto));
    }

}


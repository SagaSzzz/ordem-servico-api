package com.example.ordemService.controller;

import com.example.ordemService.model.ClienteModel;
import com.example.ordemService.model.EquipamentoModel;
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
    public EquipamentoModel adcEquip(@Valid @RequestBody EquipamentoModel equip){
        return equipamentoService.adcEquip(equip);
    }

    @GetMapping
    public List <EquipamentoModel> listarEquip(){
        return equipamentoService.buscarEquip();
    }
    @GetMapping("/{id}")
    public EquipamentoModel procurarId(@PathVariable Long id){
        return equipamentoService.procurarId(id);
    }
    @PutMapping("/{id}")
    public EquipamentoModel attEquip(@PathVariable Long id, @Valid @RequestBody EquipamentoModel equip){
        return equipamentoService.attEquip(id, equip);
    }
    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id){
        equipamentoService.deletar(id);
    }

}

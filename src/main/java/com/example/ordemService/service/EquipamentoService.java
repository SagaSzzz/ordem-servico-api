package com.example.ordemService.service;

import com.example.ordemService.model.EquipamentoModel;
import com.example.ordemService.repository.EquipamentoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EquipamentoService {

    private EquipamentoRepository equipamentoRepository;

    public EquipamentoService(EquipamentoRepository equipamentoRepository) {
        this.equipamentoRepository = equipamentoRepository;
    }

    public EquipamentoModel adcEquip(EquipamentoModel equip){
        return equipamentoRepository.save(equip);
    }


    public List<EquipamentoModel> buscarEquip(){
        return equipamentoRepository.findAll();
    }


    public EquipamentoModel procurarId(Long id){
        return equipamentoRepository.findById(id).orElseThrow(()->new RuntimeException("EQUIPAMENTO NAO ENCONTRADO"));
    }


    public void deletar(Long id){
        EquipamentoModel busca = procurarId(id);
        equipamentoRepository.delete(busca);
    }
    public EquipamentoModel attEquip(Long id, EquipamentoModel atualizado){
        EquipamentoModel atualizado1 = equipamentoRepository.findById(id)
                .orElseThrow(()->new RuntimeException("EQUIPAMENTO NAO ENCONTRADO"));
        atualizado1.setMarca(atualizado.getMarca());
        atualizado1.setDefeito(atualizado.getDefeito());
        atualizado1.setNome(atualizado.getNome());
        atualizado1.setModelo(atualizado.getModelo());
        return equipamentoRepository.save(atualizado1);
    }

















}

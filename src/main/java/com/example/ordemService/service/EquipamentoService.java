package com.example.ordemService.service;

import com.example.ordemService.dto.EquipamentoRequestDTO;
import com.example.ordemService.dto.EquipamentoResponseDTO;
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

    private EquipamentoResponseDTO converterParaDto(EquipamentoModel equipamento) {
        return new EquipamentoResponseDTO(equipamento.getId(), equipamento.getNome(), equipamento.getMarca(), equipamento.getModelo(), equipamento.getDefeito());
    }

    public EquipamentoResponseDTO adcEquipDto(EquipamentoRequestDTO dto){
       EquipamentoModel equipamento = new EquipamentoModel();
       equipamento.setNome(dto.getNome());
       equipamento.setMarca(dto.getMarca());
       equipamento.setModelo(dto.getModelo());
       equipamento.setDefeito(dto.getDefeito());
       EquipamentoModel equipamentoSalvo = equipamentoRepository.save(equipamento);
       return converterParaDto(equipamentoSalvo);
    }

    public List<EquipamentoResponseDTO> buscarEquipDto(){
        return equipamentoRepository.findAll()
                .stream()
                .map(equipamento -> converterParaDto(equipamento))
                .toList();
    }


    public EquipamentoResponseDTO procurarIdDto(Long id){
        EquipamentoModel equipamento =  equipamentoRepository.findById(id)
                .orElseThrow(()->new RuntimeException("EQUIPAMENTO NAO ENCONTRADO"));
        return converterParaDto(equipamento);
    }


    public void deletar(Long id){
        EquipamentoModel equipamento = equipamentoRepository.findById(id).
                orElseThrow(()->new RuntimeException("EQUIPAMENTO NAO ENCONTRADO"));
        equipamentoRepository.delete(equipamento);
    }
    public EquipamentoResponseDTO atualizarEquipamentoDto(Long id, EquipamentoRequestDTO dto) {
        EquipamentoModel equipamentoAtualizado = equipamentoRepository.findById(id)
                .orElseThrow(()->new RuntimeException("EQUIPAMENTO NAO ENCONTRADO"));
        equipamentoAtualizado.setMarca(dto.getMarca());
        equipamentoAtualizado.setDefeito(dto.getDefeito());
        equipamentoAtualizado.setNome(dto.getNome());
       equipamentoAtualizado.setModelo(dto.getModelo());
        EquipamentoModel equipamento =  equipamentoRepository.save(equipamentoAtualizado);
        return converterParaDto(equipamento);
    }

















}

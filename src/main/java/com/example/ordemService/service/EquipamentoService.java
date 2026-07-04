package com.example.ordemService.service;

import com.example.ordemService.dto.EquipamentoRequestDTO;
import com.example.ordemService.dto.EquipamentoResponseDTO;
import com.example.ordemService.exceptions.EquipamentoNaoEncontradoException;
import com.example.ordemService.exceptions.VinculadoException;
import com.example.ordemService.model.EquipamentoModel;
import com.example.ordemService.repository.EquipamentoRepository;
import com.example.ordemService.repository.OrdemServicoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EquipamentoService {

    private EquipamentoRepository equipamentoRepository;
    private OrdemServicoRepository ordemServicoRepository;

    public EquipamentoService(EquipamentoRepository equipamentoRepository, OrdemServicoRepository ordemServicoRepository) {
        this.equipamentoRepository = equipamentoRepository;
        this.ordemServicoRepository = ordemServicoRepository;
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
                .orElseThrow(()->new EquipamentoNaoEncontradoException());
        return converterParaDto(equipamento);
    }


    public void deletar(Long id){
        EquipamentoModel equipamento = equipamentoRepository.findById(id).
                orElseThrow(()->new EquipamentoNaoEncontradoException());

        if (!ordemServicoRepository.findByEquipamentoId(id).isEmpty()){
            throw new VinculadoException("NAO É POSSIVEL DELETAR ENQUANTO EQUIPAMENTO ESTIVER VINCULADO AO ORDEM DE SERVICO");
        }

        equipamentoRepository.delete(equipamento);
    }
    public EquipamentoResponseDTO atualizarEquipamentoDto(Long id, EquipamentoRequestDTO dto) {
        EquipamentoModel equipamentoAtualizado = equipamentoRepository.findById(id)
                .orElseThrow(()->new EquipamentoNaoEncontradoException());
        equipamentoAtualizado.setMarca(dto.getMarca());
        equipamentoAtualizado.setDefeito(dto.getDefeito());
        equipamentoAtualizado.setNome(dto.getNome());
       equipamentoAtualizado.setModelo(dto.getModelo());
        EquipamentoModel equipamento =  equipamentoRepository.save(equipamentoAtualizado);
        return converterParaDto(equipamento);
    }

















}

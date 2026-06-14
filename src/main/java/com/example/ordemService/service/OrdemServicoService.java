package com.example.ordemService.service;

import com.example.ordemService.model.OrdemServicoModel;
import com.example.ordemService.repository.OrdemServicoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrdemServicoService {

    private OrdemServicoRepository ordemServicoRepository;

    public OrdemServicoService(OrdemServicoRepository ordemServicoRepository) {
        this.ordemServicoRepository = ordemServicoRepository;
    }

    public OrdemServicoModel adcItem(OrdemServicoModel ordem){
        return ordemServicoRepository.save(ordem);
    }

    public List<OrdemServicoModel> listarItem(){
        return ordemServicoRepository.findAll();
    }

    public OrdemServicoModel procurarId(Long id){
        return ordemServicoRepository.findById(id)
                .orElseThrow(()->new RuntimeException("NAO ENCONTRADO"));
    }
    public OrdemServicoModel attItem(Long id, OrdemServicoModel ordem){
        OrdemServicoModel atualizado = ordemServicoRepository.findById(id)
                .orElseThrow(()->new RuntimeException("NAO ENCONNTRADO"));
        atualizado.setValor(ordem.getValor());
        atualizado.setComeco(ordem.getComeco());
        atualizado.setFim(ordem.getFim());
        atualizado.setStatus(ordem.getStatus());
        atualizado.setDescProblema(ordem.getDescProblema());
        return ordemServicoRepository.save(atualizado);
    }
    public void deletar(Long id){
        OrdemServicoModel busca = procurarId(id);
        ordemServicoRepository.delete(busca);
    }





}

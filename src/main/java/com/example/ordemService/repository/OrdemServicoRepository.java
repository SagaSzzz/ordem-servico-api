package com.example.ordemService.repository;

import com.example.ordemService.model.OrdemServicoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrdemServicoRepository extends JpaRepository<OrdemServicoModel, Long> {

     public List<OrdemServicoModel> findByStatus(String ABERTA);
     public List <OrdemServicoModel> findByClienteId(Long clienteId);

     public List<OrdemServicoModel> findByEquipamentoId(Long equipamentoId);


}

package com.example.ordemService.repository;

import com.example.ordemService.model.OrdemServicoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdemServicoRepository extends JpaRepository<OrdemServicoModel, Long> {
}

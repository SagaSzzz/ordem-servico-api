package com.example.ordemService.repository;

import com.example.ordemService.model.EquipamentoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EquipamentoRepository extends JpaRepository <EquipamentoModel, Long> {
}

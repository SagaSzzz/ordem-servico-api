package com.example.ordemService.dto;

import com.example.ordemService.enums.StatusOrdem;
import com.example.ordemService.model.ClienteModel;
import com.example.ordemService.model.EquipamentoModel;



import java.time.LocalDate;

public class OrdemServicoResponseDTO {

    private Long id;
    private String descProblema;
    private StatusOrdem status;
    private Double valor;
    private LocalDate comeco;
    private LocalDate fim;
    private Long clienteId;
    private Long equipamentoId;

    public OrdemServicoResponseDTO(Long id, String descProblema, StatusOrdem status, Double valor, LocalDate comeco, LocalDate fim, Long clienteId, Long equipamentoId) {
        this.id = id;
        this.descProblema = descProblema;
        this.status = status;
        this.valor = valor;
        this.comeco = comeco;
        this.fim = fim;
        this.clienteId = clienteId;
        this.equipamentoId = equipamentoId;
    }

    public Long getEquipamentoId() {
        return equipamentoId;
    }

    public Long getClienteId() {
        return clienteId;
    }

    public LocalDate getFim() {
        return fim;
    }

    public LocalDate getComeco() {
        return comeco;
    }

    public Double getValor() {
        return valor;
    }

    public StatusOrdem getStatus() {
        return status;
    }

    public String getDescProblema() {
        return descProblema;
    }

    public Long getId() {
        return id;
    }
}

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
    private ClienteModel cliente;
    private EquipamentoModel equipamento;

    public OrdemServicoResponseDTO(Long id, String descProblema, StatusOrdem status, Double valor, LocalDate comeco, LocalDate fim, ClienteModel cliente, EquipamentoModel equipamento) {
        this.id = id;
        this.descProblema = descProblema;
        this.status = status;
        this.valor = valor;
        this.comeco = comeco;
        this.fim = fim;
        this.cliente = cliente;
        this.equipamento = equipamento;
    }

    public Long getId() {
        return id;
    }

    public String getDescProblema() {
        return descProblema;
    }

    public StatusOrdem getStatus() {
        return status;
    }

    public Double getValor() {
        return valor;
    }

    public LocalDate getComeco() {
        return comeco;
    }

    public LocalDate getFim() {
        return fim;
    }

    public ClienteModel getCliente() {
        return cliente;
    }

    public EquipamentoModel getEquipamento() {
        return equipamento;
    }


}

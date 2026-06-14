package com.example.ordemService.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "tb_OrdemServico")
public class OrdemServicoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String descProblema;
    private String status;
    private Double valor;
    private LocalDate comeco;
    private LocalDate fim;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private ClienteModel cliente;

    @ManyToOne
    @JoinColumn(name = "equipamento_id")
    private EquipamentoModel equipamento;

    public OrdemServicoModel() {
    }

    public OrdemServicoModel(Long id, String descProblema, String status, double valor, LocalDate comeco, LocalDate fim) {
        this.id = id;
        this.descProblema = descProblema;
        this.status = status;
        this.valor = valor;
        this.comeco = comeco;
        this.fim = fim;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescProblema() {
        return descProblema;
    }

    public void setDescProblema(String descProblema) {
        this.descProblema = descProblema;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public LocalDate getComeco() {
        return comeco;
    }

    public void setComeco(LocalDate comeco) {
        this.comeco = comeco;
    }

    public LocalDate getFim() {
        return fim;
    }

    public void setFim(LocalDate fim) {
        this.fim = fim;
    }

    public ClienteModel getCliente() {
        return cliente;
    }

    public void setCliente(ClienteModel cliente) {
        this.cliente = cliente;
    }

    public EquipamentoModel getEquipamento() {
        return equipamento;
    }

    public void setEquipamento(EquipamentoModel equipamento) {
        this.equipamento = equipamento;
    }
}

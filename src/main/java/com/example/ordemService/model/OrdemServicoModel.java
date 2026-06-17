package com.example.ordemService.model;

import com.example.ordemService.enums.StatusOrdem;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

import java.time.LocalDate;

@Entity
@Table(name = "tb_OrdemServico")
public class OrdemServicoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "A descricao do problema é obrigatoria")
    private String descProblema;

    @NotNull(message = "O status é obrigatorio")
    @Enumerated(EnumType.STRING)
    private StatusOrdem status;

    @NotNull(message = "O valor é obrigatorio")
    @PositiveOrZero(message = "O valor nao pode ser negativo")
    private Double valor;

    @NotNull(message = "A data inicial é obrigatoria")
    private LocalDate comeco;


    private LocalDate fim;

    @NotNull(message = "O cliente é obrigatorio")
    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private ClienteModel cliente;

    @NotNull(message = "O equipamento é obrigatorio")
    @ManyToOne
    @JoinColumn(name = "equipamento_id")
    private EquipamentoModel equipamento;

    public OrdemServicoModel() {
    }

    public OrdemServicoModel(Long id, String descProblema, StatusOrdem status, Double valor, LocalDate comeco, LocalDate fim, ClienteModel cliente, EquipamentoModel equipamento) {
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

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescProblema() {
        return descProblema;
    }

    public void setDescProblema(String descProblema) {
        this.descProblema = descProblema;
    }

    public StatusOrdem getStatus() {
        return status;
    }

    public void setStatus(StatusOrdem status) {
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

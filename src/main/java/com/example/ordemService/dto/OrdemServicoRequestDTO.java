package com.example.ordemService.dto;

import com.example.ordemService.enums.StatusOrdem;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

import java.time.LocalDate;

public class OrdemServicoRequestDTO {
    @NotBlank(message = "A descricao do problema é obrigatoria")
    private String descProblema;

    @NotNull(message = "O status é obrigatorio")
    private StatusOrdem status;

    @NotNull(message = "O valor é obrigatorio")
    @PositiveOrZero(message = "O valor nao pode ser negativo")
    private Double valor;

    @NotNull(message = "A data inicial é obrigatoria")
    private LocalDate comeco;

    private LocalDate fim;

    @NotNull(message = "O cliente é obrigatorio")
    private Long clienteId;

    @NotNull(message = "O equipamento é obrigatorio")
    private Long equipamentoId;

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

    public Long getClienteId() {
        return clienteId;
    }

    public Long getEquipamentoId() {
        return equipamentoId;
    }

}

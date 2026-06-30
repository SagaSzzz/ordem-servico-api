package com.example.ordemService.dto;

import jakarta.validation.constraints.NotBlank;

public class EquipamentoRequestDTO {

    @NotBlank(message = "O nome é obrigatorio")
    private String nome;
    @NotBlank(message = "A marca é obrigatoria")
    private String marca;
    @NotBlank(message = "O modelo é obrigatorio")
    private String modelo;
    @NotBlank(message = "O defeito é obrigatorio")
    private String defeito;

    public String getNome() {
        return nome;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public String getDefeito() {
        return defeito;
    }
}

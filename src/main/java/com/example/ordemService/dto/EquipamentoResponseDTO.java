package com.example.ordemService.dto;


public class EquipamentoResponseDTO {
    private Long id;
    private String nome;
    private String marca;
    private String modelo;
    private String defeito;

    public EquipamentoResponseDTO(Long id, String nome, String marca, String modelo, String defeito) {
        this.id = id;
        this.nome = nome;
        this.marca = marca;
        this.modelo = modelo;
        this.defeito = defeito;
    }

    public Long getId() {
        return id;
    }

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

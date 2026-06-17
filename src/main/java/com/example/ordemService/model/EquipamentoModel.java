package com.example.ordemService.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "tb_equipamento")
public class EquipamentoModel {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "O nome é obrigatorio")
    private String nome;
    @NotBlank(message = "A marca é obrigatoria")
    private String marca;
    @NotBlank(message = "O modelo é obrigatorio")
    private String modelo;
    @NotBlank(message = "O defeito é obrigatorio")
    private String defeito;

    public EquipamentoModel() {
    }

    public EquipamentoModel(Long id, String nome, String marca, String modelo, String defeito) {
        this.id = id;
        this.nome = nome;
        this.marca = marca;
        this.modelo = modelo;
        this.defeito = defeito;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getDefeito() {
        return defeito;
    }

    public void setDefeito(String defeito) {
        this.defeito = defeito;
    }
}

package com.example.ordemService.dto;

public class ClienteResponseDTO {
    private Long id;
    private String nome;
    private String telefone;
    private String email;

    public ClienteResponseDTO(Long id, String nome, String telefone, String email) {
        this.id = id;
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getNome() {
        return nome;
    }

    public Long getId() {
        return id;
    }
}

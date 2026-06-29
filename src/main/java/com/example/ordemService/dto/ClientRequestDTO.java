package com.example.ordemService.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class ClientRequestDTO {
    @NotBlank(message = "O nome é obrigatorio")
    private String nome;

    @NotBlank(message = "O numero é obrigatorio")
    private String telefone;

    @NotBlank(message = "O email é obrigatorio")
    @Email(message = "email invalido")
    private String email;

    public String getNome() {
        return nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getEmail() {
        return email;
    }
}

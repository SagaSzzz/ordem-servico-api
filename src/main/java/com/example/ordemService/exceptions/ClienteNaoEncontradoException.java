package com.example.ordemService.exceptions;

public class ClienteNaoEncontradoException extends RuntimeException{
    public ClienteNaoEncontradoException() {
        super("CLIENTE NAO ENCONTRADO:");
    }
}

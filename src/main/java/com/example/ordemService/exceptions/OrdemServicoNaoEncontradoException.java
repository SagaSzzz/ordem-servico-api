package com.example.ordemService.exceptions;

public class OrdemServicoNaoEncontradoException extends RuntimeException{

    public OrdemServicoNaoEncontradoException() {
        super("ORDEN NAO ENCONTRADA:");
    }
}

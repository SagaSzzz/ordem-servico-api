package com.example.ordemService.exceptions;

public class EquipamentoNaoEncontradoException extends RuntimeException{

    public EquipamentoNaoEncontradoException() {
        super("EQUIPAMENTO NAO ENCONTRADO:");
    }
}

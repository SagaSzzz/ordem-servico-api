package com.example.ordemService.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class TratamentoDeErro {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> tratarErro(MethodArgumentNotValidException erro) {

        Map<String, String> erros = new HashMap<>();
        erro.getBindingResult().getFieldErrors().forEach(campoErro ->{
            erros.put(campoErro.getField(), campoErro.getDefaultMessage());
        });
        return erros;

    }

}

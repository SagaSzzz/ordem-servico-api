package com.example.ordemService.tratametoDeErros;


import com.example.ordemService.exceptions.ClienteNaoEncontradoException;
import com.example.ordemService.exceptions.EquipamentoNaoEncontradoException;
import com.example.ordemService.exceptions.OrdemServicoNaoEncontradoException;
import com.example.ordemService.exceptions.VinculadoException;
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

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler({
            ClienteNaoEncontradoException.class,
            EquipamentoNaoEncontradoException.class,
            OrdemServicoNaoEncontradoException.class
    })
    public Map<String, String> tratarNaoEncotrado(RuntimeException erro) {
        Map<String, String> resposta = new HashMap<>();
        resposta.put("erro", erro.getMessage());
        return resposta;
    }

    @ResponseStatus(HttpStatus.CONFLICT)
    @ExceptionHandler(VinculadoException.class)
    public Map<String, String> tratarVinculado(VinculadoException erro) {
        Map <String, String> resposta = new HashMap<>();
        resposta.put("erro", erro.getMessage());
        return resposta;
    }

}

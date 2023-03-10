package com.desafiowipro.utils;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class EnderecoNaoEncontradoException extends RuntimeException {

    public EnderecoNaoEncontradoException(String mensagem) {
        super(mensagem);
    }
}

package com.github.williamjbf.dacdeliveryapi.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@Getter
@ResponseStatus(HttpStatus.NOT_FOUND)
public class ClienteNaoExisteException extends RuntimeException{

    private String cpf;

    public ClienteNaoExisteException(String cpf){
        super();
        this.cpf = cpf;
    }
}

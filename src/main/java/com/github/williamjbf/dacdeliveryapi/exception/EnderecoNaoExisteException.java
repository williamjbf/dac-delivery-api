package com.github.williamjbf.dacdeliveryapi.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@Getter
@ResponseStatus(HttpStatus.NOT_FOUND)
public class EnderecoNaoExisteException extends RuntimeException{

    private Long id;

    public EnderecoNaoExisteException(Long id){
        super();
        this.id = id;
    }
}

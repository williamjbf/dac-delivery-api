package com.github.williamjbf.dacdeliveryapi.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@Getter
@ResponseStatus(HttpStatus.NOT_FOUND)
public class ItemNaoExisteException extends RuntimeException{

    private Long id;
    public ItemNaoExisteException(Long id){
        super();
        this.id = id;
    }

}

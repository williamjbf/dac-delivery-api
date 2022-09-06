package com.github.williamjbf.dacdeliveryapi.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.util.Arrays;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ApiError {

    private HttpStatus status;
    private String resumo;
    private List<String> errors;

    public ApiError(final HttpStatus status, final String resumo, final String messagemErro) {
        super();
        this.status = status;
        this.resumo = resumo;
        this.errors = Arrays.asList(messagemErro);
    }
}

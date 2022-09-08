package com.github.williamjbf.dacdeliveryapi.exception;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContext;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.apache.commons.lang3.exception.ExceptionUtils;


@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler   {

    @Autowired
    private MessageSource messageSource;

    public CustomExceptionHandler(){}

    @ExceptionHandler({ClienteNaoExisteException.class})
    public ResponseEntity<Object> handlerClienteNaoExisteException(ClienteNaoExisteException ex,
                                                                   WebRequest request){
        String userMessage = messageSource.getMessage("cliente.nao.encontrado", new String[]{ex.getCpf()}, LocaleContextHolder.getLocale());
        String devMessage = ExceptionUtils.getRootCauseMessage(ex);

        ApiError apiError = new ApiError(HttpStatus.NOT_FOUND, userMessage, devMessage);
        return new ResponseEntity<Object>(apiError,new HttpHeaders(), apiError.getStatus());
    }

    @ExceptionHandler({PedidoNaoExisteException.class})
    public ResponseEntity<Object> handlerPedidoNaoExisteException(PedidoNaoExisteException ex,
                                                                   WebRequest request){
        String userMessage = messageSource.getMessage("pedido.nao.encontrado", new String[]{ex.getId().toString()}, LocaleContextHolder.getLocale());
        String devMessage = ExceptionUtils.getRootCauseMessage(ex);

        ApiError apiError = new ApiError(HttpStatus.NOT_FOUND, userMessage, devMessage);
        return new ResponseEntity<Object>(apiError,new HttpHeaders(), apiError.getStatus());
    }

    @ExceptionHandler({EnderecoNaoExisteException.class})
    public ResponseEntity<Object> handlerEnderecoNaoExisteException(EnderecoNaoExisteException ex,
                                                                  WebRequest request){
        String userMessage = messageSource.getMessage("endereco.nao.encontrado", new String[]{ex.getId().toString()}, LocaleContextHolder.getLocale());
        String devMessage = ExceptionUtils.getRootCauseMessage(ex);

        ApiError apiError = new ApiError(HttpStatus.NOT_FOUND, userMessage, devMessage);
        return new ResponseEntity<Object>(apiError,new HttpHeaders(), apiError.getStatus());
    }

    @ExceptionHandler({ItemNaoExisteException.class})
    public ResponseEntity<Object> handlerItemNaoExisteException(ItemNaoExisteException ex,
                                                                    WebRequest request){
        String userMessage = messageSource.getMessage("item.nao.encontrado", new String[]{ex.getId().toString()}, LocaleContextHolder.getLocale());
        String devMessage = ExceptionUtils.getRootCauseMessage(ex);

        ApiError apiError = new ApiError(HttpStatus.NOT_FOUND, userMessage, devMessage);
        return new ResponseEntity<Object>(apiError,new HttpHeaders(), apiError.getStatus());
    }


}

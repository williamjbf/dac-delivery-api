package com.github.williamjbf.dacdeliveryapi.pedido.model;

import lombok.Getter;

@Getter
public enum StatusPedido {
    PENDENTE("PENDENTE"),
    ANALISE("ANALISE"),
    EM_PRODUCAO("EM_PRODUCAO"),
    ENVIADO("ENVIADO"),
    RECEBIDO("RECEBIDO"),
    CANCELADO("CANCELADO");

    private String status;
    StatusPedido(String status) {
        this.status = status;
    }
}

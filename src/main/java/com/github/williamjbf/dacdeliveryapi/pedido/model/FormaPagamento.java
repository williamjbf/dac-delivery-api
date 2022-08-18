package com.github.williamjbf.dacdeliveryapi.pedido.model;

import lombok.Getter;

@Getter
public enum FormaPagamento {
    DINHEIRO("DINHEIRO"),
    CARTAO("CARTAO");

    private String formaPagamento;
    FormaPagamento(String formaPagamento) {
        this.formaPagamento = formaPagamento;
    }
}

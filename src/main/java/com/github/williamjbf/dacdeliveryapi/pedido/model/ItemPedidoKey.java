package com.github.williamjbf.dacdeliveryapi.pedido.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Data
public class ItemPedidoKey implements Serializable {
    @Column(name = "item_id")
    Long itemId;

    @Column(name = "pedido_id")
    Long pedidoId;
}

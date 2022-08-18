package com.github.williamjbf.dacdeliveryapi.pedido.model;

import com.github.williamjbf.dacdeliveryapi.item.model.Item;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class ItemPedido {
    @EmbeddedId
    private ItemPedidoKey id;

    @ManyToOne
    @MapsId("itemId")
    @JoinColumn(name = "item_id")
    private Item item;

    @ManyToOne
    @MapsId("pedidoId")
    @JoinColumn(name = "pedido_id")
    private Pedido pedido;

    private int quantItem;
}

package com.github.williamjbf.dacdeliveryapi.pedido.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.williamjbf.dacdeliveryapi.item.model.Item;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class ItemPedido {
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @EmbeddedId
    private ItemPedidoKey id;

    @ManyToOne(fetch = FetchType.EAGER)
    @MapsId("itemId")
    @JoinColumn(name = "item_id")
    private Item item;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ManyToOne(fetch = FetchType.EAGER)
    @MapsId("pedidoId")
    @JoinColumn(name = "pedido_id")
    private Pedido pedido;;

    private int quantItem;
}

package com.github.williamjbf.dacdeliveryapi.item.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.williamjbf.dacdeliveryapi.empresa.cardapio.model.Cardapio;
import com.github.williamjbf.dacdeliveryapi.pedido.model.ItemPedido;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.lang.reflect.Array;
import java.util.List;
import java.util.Set;

@Entity
@Data
@SequenceGenerator(name ="seq_item_id", allocationSize = 1)
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_item_id")
    private long id;
    private String nome;
    private String imagem;
    private float valorUnitario;
    private String ingredientes;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Long id_cardapio;
    @OneToMany(mappedBy = "item")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<ItemPedido> pedidos;
}

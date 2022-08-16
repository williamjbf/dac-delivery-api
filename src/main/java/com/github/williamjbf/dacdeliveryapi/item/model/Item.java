package com.github.williamjbf.dacdeliveryapi.item.model;

import lombok.Data;

import javax.persistence.*;

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
}

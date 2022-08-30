package com.github.williamjbf.dacdeliveryapi.empresa.cardapio.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.github.williamjbf.dacdeliveryapi.empresa.model.Empresa;
import com.github.williamjbf.dacdeliveryapi.item.model.Item;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@SequenceGenerator(name ="seq_cardapio_id", allocationSize = 1)
public class Cardapio {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_cardapio_id")
    private Long id;
    @OneToOne
    @JsonIgnore
    private Empresa empresa;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="id_cardapio")
    private List<Item> itens;
}

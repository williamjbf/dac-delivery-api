package com.github.williamjbf.dacdeliveryapi.empresa.cardapio.model;

import com.github.williamjbf.dacdeliveryapi.empresa.model.Empresa;
import com.github.williamjbf.dacdeliveryapi.item.model.Item;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
public class Cardapio {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToOne
    private Empresa empresa;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="id_cardapio")
    private List<Item> itens;
}

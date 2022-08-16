package com.github.williamjbf.dacdeliveryapi.endereco.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@SequenceGenerator(name ="seq_endereco_id", allocationSize = 1)
public class Endereco {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_endereco_id")
    private long id;
    private String rua;
    private String numero;
    private String complemento;
    private String cep;
    private String cidade;
    private String uf;
}

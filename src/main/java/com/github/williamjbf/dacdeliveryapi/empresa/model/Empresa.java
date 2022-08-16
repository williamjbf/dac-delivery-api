package com.github.williamjbf.dacdeliveryapi.empresa.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@SequenceGenerator(name ="seq_empresa_id", allocationSize = 1)
public class Empresa {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_empresa_id")
    private long id;
    private String nome;
    private String telefone;
}

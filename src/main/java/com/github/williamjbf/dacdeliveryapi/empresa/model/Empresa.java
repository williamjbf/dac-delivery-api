package com.github.williamjbf.dacdeliveryapi.empresa.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Empresa {

    @Id
    private String cnpj;
    private String nome;
    private String telefone;
    @Embedded
    private Endereco endereco;
}

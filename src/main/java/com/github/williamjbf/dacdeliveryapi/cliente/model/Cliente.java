package com.github.williamjbf.dacdeliveryapi.cliente.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data


public class Cliente {

    @Id
    private String cpf;
    private String nome;
    private String foto;
    private LocalDate dataNasc;
    private String telefone;
    private String email;
    private String senha;
}

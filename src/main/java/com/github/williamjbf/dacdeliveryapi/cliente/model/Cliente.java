package com.github.williamjbf.dacdeliveryapi.cliente.model;

import com.github.williamjbf.dacdeliveryapi.endereco.model.Endereco;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

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

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="id_referencia")
    private List<Endereco> enderecos;
}
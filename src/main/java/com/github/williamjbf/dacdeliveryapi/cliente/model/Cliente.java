package com.github.williamjbf.dacdeliveryapi.cliente.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.williamjbf.dacdeliveryapi.endereco.model.Endereco;
import com.github.williamjbf.dacdeliveryapi.pedido.model.Pedido;
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
    @Column(unique = true)
    private String email;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String senha;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="id_referencia")
    private List<Endereco> enderecos;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="id_cliente")
    private List<Pedido> pedidos;
}

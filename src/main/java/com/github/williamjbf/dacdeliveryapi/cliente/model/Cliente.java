package com.github.williamjbf.dacdeliveryapi.cliente.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.williamjbf.dacdeliveryapi.endereco.model.Endereco;
import com.github.williamjbf.dacdeliveryapi.pedido.model.Pedido;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data


public class Cliente {

    @Id
    @NotNull(message = "cpf inválido, null")
    @NotBlank(message = "cpf inválido, vazio")
    private String cpf;

    @Size(min = 3, max = 30, message = "nome inválido")
    private String nome;
    private String foto;
    private LocalDate dataNasc;
    private String telefone;

    @Column(unique = true)
    @Email(message = "email inválido")
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

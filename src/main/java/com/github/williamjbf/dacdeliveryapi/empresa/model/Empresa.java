package com.github.williamjbf.dacdeliveryapi.empresa.model;

import com.github.williamjbf.dacdeliveryapi.empresa.cardapio.model.Cardapio;
import com.github.williamjbf.dacdeliveryapi.pedido.model.Pedido;
import lombok.Data;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Data
public class Empresa {

    @Id
    @NotNull(message = "cpf inválido, null")
    @NotBlank(message = "cpf inválido, vazio")
    private String cnpj;
    @Size(min = 3, max = 40, message = "nome da empresa inválido")
    private String nome;
    private String telefone;
    @Valid
    @Embedded
    private Endereco endereco;

    @OneToOne(mappedBy = "empresa")
    private Cardapio cardapio;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="id_empresa")
    private List<Pedido> pedidos;
}

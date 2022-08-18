package com.github.williamjbf.dacdeliveryapi.pedido.model;

import com.github.williamjbf.dacdeliveryapi.endereco.model.Endereco;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Data
@Getter
@Setter
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private LocalDateTime dataHora;
    private int quantItem;
    private StatusPedido status;
    private BigDecimal valorTotal;
    private BigDecimal frete;
    private BigDecimal troco;
    private FormaPagamento formaPagamento;

    @ManyToOne
    private Endereco enderecoCliente;

    @OneToMany(mappedBy = "pedido")
    Set<ItemPedido> itens;
}

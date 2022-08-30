package com.github.williamjbf.dacdeliveryapi.pedido.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.github.williamjbf.dacdeliveryapi.endereco.model.Endereco;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
@SequenceGenerator(name ="seq_pedido_id", allocationSize = 1)
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator ="seq_pedido_id")
    private long id;
    private LocalDateTime dataHora;
    private StatusPedido status;
    private float valorTotal;
    private float frete;
    private float troco;
    private FormaPagamento formaPagamento;
    @ManyToOne
    private Endereco enderecoCliente;
    @JsonIgnore
    private String id_cliente;
    @JsonIgnore
    private String id_empresa;
    @OneToMany(mappedBy = "pedido")
    List<ItemPedido> itens;

    public Pedido(){
        this.dataHora = LocalDateTime.now();
        status = StatusPedido.PENDENTE;
        this.itens = new ArrayList<>();
        this.frete = 10;
        this.valorTotal = 0;
    }

    public void adicionarItem(ItemPedido itemPedido){
        this.itens.add(itemPedido);
    }
}

package com.github.williamjbf.dacdeliveryapi.pedido.dto;

import com.github.williamjbf.dacdeliveryapi.pedido.model.*;
import lombok.Data;

import java.util.ArrayList;

@Data
public class PedidoDto {

    private FormaPagamento formaPagamento;
    private float troco;
    private String cpfCliente;
    private String cnpjEmpresa;
    private Long idEndereco;
    private ArrayList<ItemPedido> itens;

}

package com.github.williamjbf.dacdeliveryapi.pedido.dto;

import com.github.williamjbf.dacdeliveryapi.pedido.model.*;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;

@Data
public class PedidoDto {

    private FormaPagamento formaPagamento;
    private float troco;

    @NotNull(message = "cpf do cliente inválido, null")
    @NotEmpty(message = "cpf do cliente inválido, vazio")
    private String cpfCliente;
    @NotNull(message = "cnpj da empresa inválido, null")
    @NotEmpty(message = "cnpj da empresa inválido, vazio")
    private String cnpjEmpresa;
    private Long idEndereco;

    private ArrayList<ItemPedido> itens;

}

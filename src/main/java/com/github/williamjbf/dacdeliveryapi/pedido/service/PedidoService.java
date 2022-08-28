package com.github.williamjbf.dacdeliveryapi.pedido.service;

import com.github.williamjbf.dacdeliveryapi.endereco.repository.EnderecoRepository;
import com.github.williamjbf.dacdeliveryapi.item.model.Item;
import com.github.williamjbf.dacdeliveryapi.item.repository.ItemRepository;
import com.github.williamjbf.dacdeliveryapi.pedido.dto.PedidoDto;
import com.github.williamjbf.dacdeliveryapi.pedido.model.*;
import com.github.williamjbf.dacdeliveryapi.pedido.repository.ItemPedidoRepository;
import com.github.williamjbf.dacdeliveryapi.pedido.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PedidoService {

    @Autowired
    EnderecoRepository enderecoRepository;
    @Autowired
    ItemRepository itemRepository;
    @Autowired
    PedidoRepository pedidoRepository;
    @Autowired
    ItemPedidoRepository itemPedidoRepository;

    @Transactional(propagation = Propagation.REQUIRED)
    public Pedido save(PedidoDto pedidoDto){
        Pedido pedido = new Pedido();
        pedido.setEnderecoCliente(enderecoRepository.findById(pedidoDto.getIdEndereco()).get());
        pedido.setFormaPagamento(pedidoDto.getFormaPagamento());
        pedido.setTroco(pedidoDto.getTroco());
        pedido.setId_cliente(pedidoDto.getCpfCliente());
        pedido.setId_empresa(pedidoDto.getCnpjEmpresa());
        Pedido pedidoSalvo = pedidoRepository.save(pedido);

        List<ItemPedido> itens = pedidoDto.getItens();
        for(ItemPedido itemPedido: itens){
            ItemPedidoKey pedidoKey = new ItemPedidoKey();
            pedidoKey.setPedidoId(pedidoSalvo.getId());
            pedidoKey.setItemId(itemPedido.getId().getItemId());
            itemPedido.setId(pedidoKey);
            itemPedido.setPedido(pedidoSalvo);
            itemPedido.setItem(itemRepository.findById(pedidoKey.getItemId()).get());
            itemPedidoRepository.save(itemPedido);
            pedidoSalvo.adicionarItem(itemPedido);
        }

        pedidoSalvo.setValorTotal(calcularValorTotal(pedidoSalvo));
        pedidoSalvo.setTroco(calcularTroco(pedidoSalvo));
        return pedidoRepository.save(pedidoSalvo);
    }

    private float calcularValorTotal(Pedido pedido){
        List<ItemPedido> itemPedidos = pedido.getItens();
        float valorTotal = 0;
        for (ItemPedido itemPedidoAtual : itemPedidos) {
            valorTotal += itemPedidoAtual.getQuantItem() * itemPedidoAtual.getItem().getValorUnitario();
        }
        valorTotal += pedido.getFrete();
        return valorTotal;
    }

    private float calcularTroco(Pedido pedido){
        if(pedido.getFormaPagamento().equals(FormaPagamento.DINHEIRO)){
            return pedido.getTroco() - pedido.getValorTotal();
        }
        return 0;
    }
}

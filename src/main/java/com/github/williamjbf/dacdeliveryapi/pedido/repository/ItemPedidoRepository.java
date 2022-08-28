package com.github.williamjbf.dacdeliveryapi.pedido.repository;

import com.github.williamjbf.dacdeliveryapi.pedido.model.ItemPedido;
import com.github.williamjbf.dacdeliveryapi.pedido.model.ItemPedidoKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemPedidoRepository extends JpaRepository<ItemPedido, ItemPedidoKey> {
}

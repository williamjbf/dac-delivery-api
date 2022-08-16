package com.github.williamjbf.dacdeliveryapi.cliente.repository;

import com.github.williamjbf.dacdeliveryapi.cliente.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository <Cliente, Long> {
}

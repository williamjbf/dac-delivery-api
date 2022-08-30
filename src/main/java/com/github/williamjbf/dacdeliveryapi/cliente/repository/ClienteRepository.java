package com.github.williamjbf.dacdeliveryapi.cliente.repository;

import com.github.williamjbf.dacdeliveryapi.cliente.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClienteRepository extends JpaRepository <Cliente, String> {

    public Optional<Cliente> findByEmail(String email);

}

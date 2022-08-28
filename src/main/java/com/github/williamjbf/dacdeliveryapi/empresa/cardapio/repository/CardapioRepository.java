package com.github.williamjbf.dacdeliveryapi.empresa.cardapio.repository;

import com.github.williamjbf.dacdeliveryapi.empresa.cardapio.model.Cardapio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardapioRepository extends JpaRepository<Cardapio,Long> {
}

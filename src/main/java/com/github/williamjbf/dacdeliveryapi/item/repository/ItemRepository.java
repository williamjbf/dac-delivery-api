package com.github.williamjbf.dacdeliveryapi.item.repository;

import com.github.williamjbf.dacdeliveryapi.item.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository <Item, Long> {
}

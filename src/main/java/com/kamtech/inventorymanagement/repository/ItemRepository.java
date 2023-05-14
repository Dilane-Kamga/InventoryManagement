package com.kamtech.inventorymanagement.repository;


import com.kamtech.inventorymanagement.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ItemRepository extends JpaRepository<Item, Integer> {

    Optional<Item> findByItemCode(String code);
}

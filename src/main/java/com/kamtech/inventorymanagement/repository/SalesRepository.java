package com.kamtech.inventorymanagement.repository;

import com.kamtech.inventorymanagement.model.Sales;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SalesRepository extends JpaRepository<Sales, Integer> {

    Optional<Sales> findByCode(String code);
}

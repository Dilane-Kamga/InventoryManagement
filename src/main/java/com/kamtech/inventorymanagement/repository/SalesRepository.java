package com.kamtech.inventorymanagement.repository;

import com.kamtech.inventorymanagement.model.Sales;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SalesRepository extends JpaRepository<Sales, Integer> {
}

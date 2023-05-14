package com.kamtech.inventorymanagement.repository;

import com.kamtech.inventorymanagement.model.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SupplierRepository extends JpaRepository<Supplier, Integer> {
}

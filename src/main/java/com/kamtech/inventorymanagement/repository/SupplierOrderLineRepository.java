package com.kamtech.inventorymanagement.repository;

import com.kamtech.inventorymanagement.model.SupplierOrderLine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SupplierOrderLineRepository extends JpaRepository<SupplierOrderLine, Integer> {
}

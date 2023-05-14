package com.kamtech.inventorymanagement.repository;

import com.kamtech.inventorymanagement.model.SupplierOrder;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SupplierOrderRepository extends JpaRepository<SupplierOrder, Integer>{

    Optional<SupplierOrder> findByCode(String orderNumber);
}

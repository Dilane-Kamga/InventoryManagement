package com.kamtech.inventorymanagement.repository;

import com.kamtech.inventorymanagement.model.CustomerOrderLine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerOrderLineRepository extends JpaRepository<CustomerOrderLine, Integer> {
}

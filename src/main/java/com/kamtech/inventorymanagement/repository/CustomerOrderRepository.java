package com.kamtech.inventorymanagement.repository;

import com.kamtech.inventorymanagement.model.CustomerOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerOrderRepository extends JpaRepository<CustomerOrder, Integer> {
}

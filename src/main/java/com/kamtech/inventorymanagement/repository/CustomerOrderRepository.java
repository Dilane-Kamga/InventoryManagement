package com.kamtech.inventorymanagement.repository;

import com.kamtech.inventorymanagement.model.CustomerOrder;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerOrderRepository extends JpaRepository<CustomerOrder, Integer> {

    Optional<CustomerOrder> findByCode(String orderNumber);
}

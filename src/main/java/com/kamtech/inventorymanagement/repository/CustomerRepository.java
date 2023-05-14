package com.kamtech.inventorymanagement.repository;

import com.kamtech.inventorymanagement.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
}

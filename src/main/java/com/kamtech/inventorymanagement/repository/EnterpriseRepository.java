package com.kamtech.inventorymanagement.repository;

import com.kamtech.inventorymanagement.model.Enterprise;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnterpriseRepository extends JpaRepository<Enterprise, Integer> {
}

package com.kamtech.inventorymanagement.repository;

import com.kamtech.inventorymanagement.model.SalesLine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SalesLineRepository extends JpaRepository<SalesLine, Integer> {
}

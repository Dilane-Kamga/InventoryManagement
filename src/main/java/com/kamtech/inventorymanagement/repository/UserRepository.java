package com.kamtech.inventorymanagement.repository;

import com.kamtech.inventorymanagement.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}

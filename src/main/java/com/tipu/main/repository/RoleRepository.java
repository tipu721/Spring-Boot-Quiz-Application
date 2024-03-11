package com.tipu.main.repository;

import com.tipu.main.model.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<UserRole, Long> {

    UserRole findByName(String name);
}
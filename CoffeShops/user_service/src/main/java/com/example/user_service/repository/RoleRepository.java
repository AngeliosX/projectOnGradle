package com.example.user_service.repository;

import com.example.user_service.entity.Roles;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Roles, Long> {
    default String findByName(String roleName) {
        return roleName;
    }
}

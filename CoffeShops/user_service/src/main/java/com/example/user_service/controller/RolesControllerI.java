package com.example.user_service.controller;

import com.example.user_service.entity.Roles;
import com.example.user_service.exceptions.RoleNotFoundException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface RolesControllerI {
    @PostMapping("/create")
    Roles createRole(@RequestBody Roles roles);

    @DeleteMapping("/delete/{id}")
    Long deleteRoleById(@PathVariable Long id) throws RoleNotFoundException;
}

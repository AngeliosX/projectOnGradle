package com.example.user_service.controller;

import com.example.user_service.entity.Roles;
import com.example.user_service.exceptions.RoleNotFoundException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

@Tag(name = "role", description = "API of the roles")
@RequestMapping("/roles")
public interface RolesControllerI {

    @Operation(summary = "Create the new role")
    @PostMapping
    Roles createRole(@RequestBody Roles roles);


    @Operation(summary = "Delete the role by id")
    @DeleteMapping("/{id}")
    Long deleteRoleById(@PathVariable Long id) throws RoleNotFoundException;
}
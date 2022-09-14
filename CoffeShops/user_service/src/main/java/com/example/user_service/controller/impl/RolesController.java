package com.example.user_service.controller.impl;

import com.example.user_service.controller.RolesControllerI;
import com.example.user_service.entity.Roles;
import com.example.user_service.exceptions.RoleNotFoundException;
import com.example.user_service.service.RolesServiceI;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RolesController implements RolesControllerI {
    private final RolesServiceI rolesService;


    public RolesController(RolesServiceI rolesService) {
        this.rolesService = rolesService;
    }

    @Override
    public Roles createRole(Roles roles) {
        return rolesService.createRole(roles);
    }

    @Override
    public Long deleteRoleById(Long id) throws RoleNotFoundException {
        return rolesService.deleteRole(id);
    }
}

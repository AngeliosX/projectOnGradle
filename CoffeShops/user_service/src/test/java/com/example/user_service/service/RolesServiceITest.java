package com.example.user_service.service;

import com.example.user_service.UserServiceApplicationTests;
import com.example.user_service.entity.Roles;
import com.example.user_service.exceptions.RoleNotFoundException;
import com.example.user_service.service.impl.RoleService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RolesServiceITest extends UserServiceApplicationTests {

    @Autowired
    private RoleService roleService;

    @Test
    void createRole() {
        Roles roles = new Roles();
        roles.setRoleName("ROLE_TEST");
        Roles roles1 = roleService.createRole(roles);
        assertEquals(roles1, roles);
    }

    @Test
    void deleteRole() throws RoleNotFoundException {
        Roles roles = new Roles();
        roles.setRoleName("ROLE_TEST");
        Roles roles1 = roleService.createRole(roles);
        Long roleId = roleService.deleteRole(roles1.getId());
        assertEquals(roleId, roles1.getId());
    }
}

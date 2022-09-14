package com.example.user_service.service;

import com.example.user_service.entity.Roles;
import com.example.user_service.exceptions.RoleNotFoundException;

public interface RolesServiceI {
    Roles createRole (Roles role);

    Long deleteRole(Long id) throws RoleNotFoundException;


}

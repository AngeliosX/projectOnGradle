package com.example.user_service.service.impl;

import com.example.user_service.entity.Roles;
import com.example.user_service.exceptions.RoleNotFoundException;
import com.example.user_service.repository.RoleRepository;
import com.example.user_service.service.RolesServiceI;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class RoleService implements RolesServiceI {

    private final RoleRepository roleRepository;

    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    @Transactional
    public Roles createRole(Roles role) {
        return roleRepository.save(role);
    }

    @Override
    public Long deleteRole(Long id) throws RoleNotFoundException {
        if (!roleRepository.existsById(id)) {
            throw new RoleNotFoundException();
        }
        roleRepository.deleteById(id);
        return id;
    }
}

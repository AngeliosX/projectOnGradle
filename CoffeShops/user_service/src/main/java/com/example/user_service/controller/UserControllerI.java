package com.example.user_service.controller;

import com.example.user_service.dto.in.ChangePasswordUserInDTO;
import com.example.user_service.dto.in.UserInDTO;
import com.example.user_service.dto.out.UserOutDTO;
import com.example.user_service.entity.Roles;
import com.example.user_service.exceptions.RoleNotFoundException;
import com.example.user_service.exceptions.UserNotFoundException;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

public interface UserControllerI {

    @PostMapping("/create")
    UserOutDTO createUser(@RequestBody UserInDTO userInDTO);

    @PutMapping("/update/{id}")
    UserOutDTO updateUser(UserInDTO userInDTO, @PathVariable Long id) throws UserNotFoundException;

    @DeleteMapping("/delete/{id}")
    Long deleteUser(@PathVariable Long id) throws UserNotFoundException;

    @GetMapping("/get/{id}")
    UserOutDTO getUser(@PathVariable Long id) throws UserNotFoundException;

    @PutMapping("/new_password")
    void changePassword(@RequestBody @Valid ChangePasswordUserInDTO changePasswordUserInDTO);

    @PreAuthorize(value = "hasRole('ROLE_ADMIN')")
    @GetMapping("/admin")
    default String admin() {
        return "admin";
    }

    @PreAuthorize(value = "hasRole('ROLE_USER')")
    @GetMapping("/user")
    default String user() {
        return "user";
    }

    @PutMapping("/addRole/{userInDTO}")
    UserOutDTO addRoleToUser(@PathVariable UserInDTO userInDTO) throws RoleNotFoundException;

    @PutMapping("/dellRole")
    UserOutDTO removeRoleFromUser(@PathVariable Long userId, @PathVariable UserInDTO userInDTO) throws UserNotFoundException, RoleNotFoundException;
}

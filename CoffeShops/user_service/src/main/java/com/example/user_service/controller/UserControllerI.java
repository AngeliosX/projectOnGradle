package com.example.user_service.controller;

import com.example.user_service.dto.in.ChangePasswordUserInDTO;
import com.example.user_service.dto.in.UserInDTO;
import com.example.user_service.dto.out.UserOutDTO;
import com.example.user_service.exceptions.RoleNotFoundException;
import com.example.user_service.exceptions.UserNotFoundException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Tag(name = "user", description = "API of the users")
@RequestMapping("/user")
public interface UserControllerI {

    @Operation(summary = "Create the new user")
    @PostMapping
    UserOutDTO createUser(@RequestBody UserInDTO userInDTO);

    @Operation(summary = "Update user by id")
    @PutMapping("/{id}")
    UserOutDTO updateUser(UserInDTO userInDTO, @PathVariable Long id) throws UserNotFoundException;

    @Operation(summary = "Delete user by id")
    @DeleteMapping("/{id}")
    Long deleteUser(@PathVariable Long id) throws UserNotFoundException;

    @Operation(summary = "Get the user by id")
    @GetMapping("/get/{id}")
    UserOutDTO getUser(@PathVariable Long id) throws UserNotFoundException;

    @PutMapping("/new_password")
    void changePassword(@RequestBody @Valid ChangePasswordUserInDTO changePasswordUserInDTO);

    @Operation(summary = "Add role to user")
    @PutMapping("/{userInDTO}")
    UserOutDTO addRoleToUser(@PathVariable UserInDTO userInDTO) throws RoleNotFoundException;

    @Operation(summary = "Delete role by user.id and role.id")
    @PutMapping("/{userInDTO}/{userId}")
    UserOutDTO removeRoleFromUser(@PathVariable Long userId, @PathVariable UserInDTO userInDTO) throws UserNotFoundException, RoleNotFoundException;
}

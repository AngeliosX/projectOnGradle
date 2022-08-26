package com.example.user_service.service;


import com.example.user_service.UserServiceApplicationTests;
import com.example.user_service.dto.in.UserInDTO;
import com.example.user_service.dto.out.UserOutDTO;
import com.example.user_service.exceptions.UserNotFoundException;
import com.example.user_service.service.impl.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

class UserServiceITest extends UserServiceApplicationTests {

    @Autowired
    private UserService userService;

    @Test
    void createUser() throws UserNotFoundException {
        UserInDTO userInDTO = new UserInDTO();
        userInDTO.setName("testName");
        userInDTO.setSurname("testSurname");
        userInDTO.setLastname("testLastname");
        userInDTO.setEmail("test@gmail.com");
        UserOutDTO user = userService.createUser(userInDTO);
        assertEquals(user, userService.getUser(user.getId()));
    }

    @Test
    void update() throws UserNotFoundException {
        UserInDTO userInDTO = new UserInDTO();
        userInDTO.setName("testNameUpd");
        userInDTO.setSurname("testSurnameUpd");
        userInDTO.setLastname("testLastnameUpd");
        userInDTO.setEmail("testUpd@gmail.com");
        UserOutDTO user = userService.createUser(userInDTO);
        UserOutDTO userOutDTO = userService.update(userInDTO, user.getId());
        assertEquals(user, userOutDTO);
    }

    @Test
    void deleteUser() throws UserNotFoundException {
        UserInDTO userInDTO = new UserInDTO();
        userInDTO.setName("testNameDel");
        userInDTO.setSurname("testSurnameDel");
        userInDTO.setLastname("testLastnameDel");
        userInDTO.setEmail("testDel@gmail.com");
        UserOutDTO user = userService.createUser(userInDTO);
        Long userId = userService.deleteUser(user.getId());
        assertEquals(userId, user.getId());
    }
}
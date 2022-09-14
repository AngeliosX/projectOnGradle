package com.example.user_service.controller.impl;

import com.example.user_service.controller.UserControllerI;
import com.example.user_service.dto.in.ChangePasswordUserInDTO;
import com.example.user_service.dto.in.UserInDTO;
import com.example.user_service.dto.out.DeleteFromCoffeeShopsEmployeeOutDTO;
import com.example.user_service.dto.out.UpdateEmployeeIdInCoffeeShopsOutDTO;
import com.example.user_service.dto.out.UserOutDTO;
import com.example.user_service.exceptions.RoleNotFoundException;
import com.example.user_service.exceptions.UserNotFoundException;
import com.example.user_service.service.impl.UserService;
import org.springframework.amqp.rabbit.core.RabbitMessageOperations;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class UserController implements UserControllerI {
    private final UserService userService;
    private final RabbitMessageOperations rabbitTemplate;

    public UserController(UserService userService, RabbitMessageOperations rabbitTemplate) {
        this.userService = userService;
        this.rabbitTemplate = rabbitTemplate;
    }

    @Override
    public UserOutDTO createUser(UserInDTO userInDTO) {

        return userService.createUser(userInDTO);
    }

    @Override
    public UserOutDTO updateUser(UserInDTO userInDTO, Long id) throws UserNotFoundException {
        rabbitTemplate.convertAndSend("myQueue", new UpdateEmployeeIdInCoffeeShopsOutDTO(id));
        return userService.update(userInDTO, id);
    }

    @Override
    public Long deleteUser(Long id) throws UserNotFoundException {
        Long deleteUserId = userService.deleteUser(id);
        rabbitTemplate.convertAndSend("myQueue", new DeleteFromCoffeeShopsEmployeeOutDTO(id));
        System.out.println("The user has been deleted");
        return deleteUserId;
    }

    @Override
    public UserOutDTO getUser(Long id) throws UserNotFoundException {
        rabbitTemplate.convertSendAndReceive("myQueue", "Hello, world!", String.class);
        return userService.getUser(id);
    }

    @Override
    public void changePassword(ChangePasswordUserInDTO changePasswordUserInDTO) {
        userService.changePassword(changePasswordUserInDTO);
    }

    @Override
    public UserOutDTO addRoleToUser(UserInDTO userInDTO) throws RoleNotFoundException {
        return userService.addRoleToUser(userInDTO);
    }

    @Override
    public UserOutDTO removeRoleFromUser(Long userId, UserInDTO userInDTO)
            throws UserNotFoundException {
        return userService.removeRoleFromUser(userId, userInDTO);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleArgumentFormatException(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }
}

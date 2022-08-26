package com.example.user_service.exceptions;

public class UserNotFoundException extends Exception {
    @Override
    public String toString() {
        return "The user not created or incorrect value specified";
    }
}

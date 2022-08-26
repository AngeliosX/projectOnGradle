package com.example.user_service.exceptions;

public class RoleNotFoundException extends Exception{
    @Override
    public String toString() {
        return "The role not created or incorrect value specified";
    }
}

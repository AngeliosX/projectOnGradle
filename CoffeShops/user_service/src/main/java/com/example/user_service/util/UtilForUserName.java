package com.example.user_service.util;

public class UtilForUserName {
    public static void userName(String name)  {
        if(name == null) {
            throw new NullPointerException("The user name is blank");
        }
    }

    public static boolean checkUserName(String userName) {
        try {
            userName(userName);
            return true;
        } catch (NullPointerException e) {
            return false;
        }
    }
}

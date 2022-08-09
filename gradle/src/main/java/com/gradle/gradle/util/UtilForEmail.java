package com.gradle.gradle.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class UtilForEmail {
    public static boolean validationEmail(String email) throws PatternSyntaxException {
        String regExp = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
        Pattern pattern = Pattern.compile(regExp);
        Matcher matcher = pattern.matcher(email);
        if (regExp.isEmpty()) {
            throw new IllegalArgumentException("This is not email format");
        }
        return matcher.matches();
    }

    public static boolean checkEmail(String cxt) {
        try {
            validationEmail(cxt);
            return true;
        } catch (PatternSyntaxException e) {
            return false;
        }
    }
}

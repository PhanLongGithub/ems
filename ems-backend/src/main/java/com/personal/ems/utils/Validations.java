package com.personal.ems.utils;
import java.util.regex.*;

public class Validations {
    public static Boolean stringValidate(String value){
        if (value.isEmpty() || value.isBlank()) {
            return false;
        }
        return true;
    }

    public static Boolean stringValidate(String value, String regex){
        if (!value.isEmpty() && !value.isBlank()) {
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(value); 
            if (matcher.matches()) {
                return true;   
            }
        }
        return false;
    }
}

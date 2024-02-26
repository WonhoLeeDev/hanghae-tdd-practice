package com.tdd.tdd;

public class PasswordValidation {

    private static final String VALIDATION="^(?=.*[0-9].*[0-9]).{8,}$";

    public boolean isValid(String input){
        if(input.length()<8){
            throw new IllegalArgumentException("Password must be at least 8 characters");
        }

        if(!input.matches(VALIDATION)){
            throw new IllegalArgumentException("The password must contain at least 2 numbers");
        }
        return true;
    }
}

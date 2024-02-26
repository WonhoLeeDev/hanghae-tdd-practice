package com.tdd.tdd;

public class PasswordValidation {


    public boolean isValid(String input){
        if(input.length()<8){
            throw new IllegalArgumentException("Password must be at least 8 characters");
        }
        return true;
    }
}

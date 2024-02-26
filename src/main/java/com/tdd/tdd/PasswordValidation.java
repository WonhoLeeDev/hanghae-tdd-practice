package com.tdd.tdd;

import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

public class PasswordValidation {
    private static final String INCLUDE_2_NUM_AND_LENGTH_8 ="^(?=.*[0-9].*[0-9]).{8,}$";
    private static final String INCLUDE_1_CAPITAL_LETTER ="^(?=.*[A-Z].*).{1,}$";
    private static final String INCLUDE_1_SPECIAL_CHARACTER =".*[!@#$%^&*()_+\\-=\\[\\]{};':\"|,.<>/?].*";


    public boolean isValid(String input){
        List<String> errorMessage= new ArrayList<>();
        if(input.length()<8){
            errorMessage.add("Password must be at least 8 character\n");
        }

        if((!input.matches(INCLUDE_2_NUM_AND_LENGTH_8))){
            errorMessage.add("The password must contain at least 2 numbers\n");
        }

        if((!input.matches(INCLUDE_1_CAPITAL_LETTER))){
            errorMessage.add("password must contain at least one capital letter\n");
        }

        if((!input.matches(INCLUDE_1_SPECIAL_CHARACTER))){
            errorMessage.add("password must contain at least one special character\n");
        }

        if(!CollectionUtils.isEmpty(errorMessage)){
            throw new IllegalArgumentException(errorMessage.toString());
        }
        return true;
    }
}

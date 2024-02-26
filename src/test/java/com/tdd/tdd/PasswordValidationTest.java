package com.tdd.tdd;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class PasswordValidationTest {

    private PasswordValidation passwordValidation= new PasswordValidation();
    @Test
    public void inputLengthLessThan8(){
        String input="1234";
        assertThrows(IllegalArgumentException.class, ()->passwordValidation.isValid(input));
    }

    @Test
    public void notIncludeNumber(){
        String input="abcdefgh";
        assertThrows(IllegalArgumentException.class, ()->passwordValidation.isValid(input));
    }

    @Test
    public void includeNumber(){
        String input="123456789asdf";
        assertThrows(IllegalArgumentException.class, ()->passwordValidation.isValid(input));
    }

    @Test
    public void includeNumberAndNotIncludeCapitalLetter(){
        String input="123456789asdfa";
        assertThrows(IllegalArgumentException.class, ()->passwordValidation.isValid(input));
    }

    @Test
    public void includeNumberAndCapitalLetter(){
        String input="123456789asdfA";
        assertThrows(IllegalArgumentException.class, ()->passwordValidation.isValid(input));
    }


    @Test
    public void includeNumberAndCapitalLetterNotSpecialCharacter(){
        String input="123456789asdfa";
        assertThrows(IllegalArgumentException.class, ()->passwordValidation.isValid(input));
    }

    @Test
    public void includeNumberAndCapitalLetterAndSpecialCharacter(){
        String input="123456789asdfA!";
        boolean result = passwordValidation.isValid(input);
        assertThat(result).isEqualTo(true);
    }
}
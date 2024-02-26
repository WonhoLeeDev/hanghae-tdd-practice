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
    public void inputLengthOverThan8(){
        String input="123456789";
        boolean result = passwordValidation.isValid(input);
        assertThat(result).isEqualTo(true);
    }

}
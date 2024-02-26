package tdd.hanghae.password;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import tdd.practice.hanghae.password.CapitalLetterValidation;
import tdd.practice.hanghae.password.DigitsValidation;
import tdd.practice.hanghae.password.LengthValidation;
import tdd.practice.hanghae.password.SpecialCharacterValidation;

public class Validation {
    private final static String LETTER_REGEX = "^[a-zA-Z]";
    private final static String DIGIT_REGEX = "^[0-9]*$";

    String password = "afgw2!we1";


    @Test
    void validateCharacterLength() {
        LengthValidation lengthValidator = new LengthValidation(password);
        Assertions.assertThat(lengthValidator.isValid()).isTrue();
    }

    @Test
    void isMoreThan8Characters() {
        Assertions.assertThat(password.length()).isGreaterThan(7);
    }

    @Test
    void validateDigits() {
        DigitsValidation digitsValidator = new DigitsValidation(password);
        Assertions.assertThat(digitsValidator.isValid()).isTrue();
    }

    @Test
    void hasMoreThan2Digits() {
        int digitsCount = 0;
        String[] strArr = password.split("");
        for(String str : strArr) {
            if(str.matches(DIGIT_REGEX)) {
                digitsCount++;
            };
            if (digitsCount==2) {
                break;
            }
        }
        Assertions.assertThat(digitsCount).isGreaterThan(1);
    }

    @Test
    void validateCapitalLetter() {
        CapitalLetterValidation capitalLetterValidator = new CapitalLetterValidation(password);
        Assertions.assertThat(capitalLetterValidator.isValid()).isTrue();
    }

    @Test
    void hasCapitalLetter() {
        boolean hasCapitalLetter = false;
        String[] strArr = password.split("");
        for(String str : strArr) {
            if(str.equals(str.toUpperCase())) {
                hasCapitalLetter = true;
                break;
            };
        }
        Assertions.assertThat(hasCapitalLetter).isTrue();
    }

    @Test
    void validateSpecialCharacter() {
        SpecialCharacterValidation specialCharacterValidator = new SpecialCharacterValidation(password);
        Assertions.assertThat(specialCharacterValidator.isValid()).isTrue();
    }

    @Test
    void hasSpecialCharacter() {
        boolean hasSpecialCharacter = false;
        String[] strArr = password.split("");
        for(String str : strArr) {
            if(!str.matches(LETTER_REGEX) && !str.matches(DIGIT_REGEX)) {
                hasSpecialCharacter = true;
                break;
            };
        }
        Assertions.assertThat(hasSpecialCharacter).isTrue();
    }
}

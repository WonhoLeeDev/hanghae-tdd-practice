package tdd.practice.hanghae.password;

import java.util.ArrayList;
import java.util.List;

public class PasswordValidator {

    String password;

    boolean isValid = true;

    List<String> inValidMessages = new ArrayList<>();

    public PasswordValidator(String password) {
        this.password = password;
        validatePassword();
    }

    private void validatePassword() {
        LengthValidation lengthValidation = new LengthValidation(this.password);
        valiate(lengthValidation);

        DigitsValidation digitsValidation = new DigitsValidation(this.password);
        valiate(digitsValidation);

        CapitalLetterValidation capitalLetterValidation = new CapitalLetterValidation(this.password);
        valiate(capitalLetterValidation);

        SpecialCharacterValidation specialCharacterValidation = new SpecialCharacterValidation(this.password);
        valiate(specialCharacterValidation);
    }

    private void valiate(Validation validation) {
        if(!validation.isValid()) {
            this.isValid = false;
            this.inValidMessages.add(validation.getInvalidMessage());
        }
    }
}

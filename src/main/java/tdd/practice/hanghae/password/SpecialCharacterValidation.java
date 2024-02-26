package tdd.practice.hanghae.password;

public class SpecialCharacterValidation extends Validation {
    private final static String LETTER_REGEX = "^[a-zA-Z]";
    private final static String DIGIT_REGEX = "^[0-9]*$";

    public SpecialCharacterValidation(String password) {
        super(password);
    }

    @Override
    public String getInvalidMessage() {
        return "password must contain at least one special character";
    }

    @Override
    public boolean isPasswordValid(String password) {
        String[] strArr = password.split("");
        for(String str : strArr) {
            if(!str.matches(LETTER_REGEX) && !str.matches(DIGIT_REGEX)) {
                return true;
            };
        }
        return false;
    }
}

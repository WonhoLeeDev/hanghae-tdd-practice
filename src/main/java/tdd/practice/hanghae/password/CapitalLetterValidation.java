package tdd.practice.hanghae.password;

public class CapitalLetterValidation extends Validation {

    private final static String LETTER_REGEX = "^[a-zA-Z]";

    public CapitalLetterValidation(String password) {
        super(password);
    }

    @Override
    public String getInvalidMessage() {
        return "password must contain at least one capital lette";
    }

    @Override
    public boolean isPasswordValid(String password) {
        String[] strArr = password.split("");
        for(String str : strArr) {
            if(!str.matches(LETTER_REGEX)) {
                continue;
            }
            if(str.equals(str.toUpperCase())) {
                return true;
            };
        }
        return false;
    }
}

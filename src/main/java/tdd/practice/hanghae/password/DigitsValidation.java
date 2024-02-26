package tdd.practice.hanghae.password;

public class DigitsValidation extends Validation {
    private final static String DIGIT_REGEX = "^[0-9]*$";


    public DigitsValidation(String password) {
        super(password);
    }

    @Override
    public String getInvalidMessage() {
        return "The password must contain at least 2 numbers";
    }

    @Override
    public boolean isPasswordValid(String password) {
        int digitsCount = 0;
        String[] strArr = password.split("");
        for(String str : strArr) {
            if(str.matches(DIGIT_REGEX)) {
                digitsCount++;
            };
            if (digitsCount==2) {
                return true;
            }
        }
        return false;
    }
}

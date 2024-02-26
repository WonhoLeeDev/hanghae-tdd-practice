package tdd.practice.hanghae.password;

public class LengthValidation extends Validation {

    public LengthValidation(String password) {
        super(password);
    }

    @Override
    public String getInvalidMessage() {
        return "Password must be at least 8 character";
    }

    @Override
    public boolean isPasswordValid(String password) {
        return password.length() >= 8;
    }
}

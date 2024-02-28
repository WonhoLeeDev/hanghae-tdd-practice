package tdd.practice.hanghae.password;

public abstract class Validation {

    private boolean isValid;

    public Validation(String password) {
        this.isValid = isPasswordValid(password);
    }

    public boolean isValid() {
        return isValid;
    }

    public abstract String getInvalidMessage();

    public abstract boolean isPasswordValid(String password);
}

package tdd.practice.hanghae.password;

import java.util.List;

public class PasswordMain {

    public static void main(String[] args) {
        String password = "agcczxF1e3!";

        PasswordValidator passwordValidator = new PasswordValidator(password);
        System.out.println("passwordValidator.isValid : " + passwordValidator.isValid);
        if(passwordValidator.isValid) {
            System.out.println("valid password");
        }else{
            System.out.println("invalid password");
            List<String> inValidMessages = passwordValidator.inValidMessages;
            for (String inValidMessage : inValidMessages) {
                System.out.println(inValidMessage);
            }
        }
    }
}

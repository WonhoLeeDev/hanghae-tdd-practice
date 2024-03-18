package org.example;

import org.example.lotto.Number;
import org.example.lotto.WinningNumber;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public int buyAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        int amount = scanner.nextInt();
        return amount;
    }

    public WinningNumber winningNumber() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        scanner.nextLine();
        List<Number> inputNumber = new ArrayList<>();
        String winningNumber = scanner.nextLine();
        String[] winningNumbers = winningNumber.split(", ");

        for (String number : winningNumbers) {
            inputNumber.add(new Number(Integer.parseInt(number)));
        }

        return new WinningNumber(inputNumber);
    }

    public int bonusNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");
        return scanner.nextInt();
    }
}

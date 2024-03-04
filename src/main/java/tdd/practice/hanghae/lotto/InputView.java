package tdd.practice.hanghae.lotto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class InputView {

    Lotto lotto;

    private static final Scanner sc = new Scanner(System.in);


    public Lotto buy() {
        System.out.println("구매금액을 입력해주세요.");
        int buyAmount = sc.nextInt();
        this.lotto = new Lotto(buyAmount);
        this.lotto.buy();

        return this.lotto;
    }

    public void inputWinningNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        sc.nextLine();
        String numbers = sc.nextLine();

        String[] processedNumbers = processInputNumbers(numbers);
        this.lotto.setWinningNumbers(getWinningNumbers(processedNumbers));
        this.lotto.setWinningResult();
    }

    private static List<Integer> getWinningNumbers(String[] processedNumbers) {
        List<Integer> winningNumbers = new ArrayList<>();
        for (String processedNumber : processedNumbers) {
            winningNumbers.add(Integer.parseInt(processedNumber));
        }
        return winningNumbers;
    }

    private static String[] processInputNumbers(String numbers) {
        String tirmNumbers = numbers.replaceAll(" ","");
        return tirmNumbers.split(",");
    }
}

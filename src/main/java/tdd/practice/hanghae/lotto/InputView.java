package tdd.practice.hanghae.lotto;

import java.util.Scanner;

public class InputView {

    private static Scanner sc = new Scanner(System.in);

    public static void buyLotto() {
        System.out.println("구매금액을 입력해 주세요.");
        int money = sc.nextInt();
        Lotto lotto = new Lotto(money);
        lotto.buyLotto();
        System.out.println(lotto.getBuyCount() + "개를 구매했습니다.");

        lotto.printBoughtLottoList();
        sc.nextLine();

        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        String[] winningLottoNumbers = getEachInputNumbers(sc.nextLine());

        ResultView resultView = new ResultView(lotto, winningLottoNumbers);
        resultView.showLottoResult();
    }

    private static String[] getEachInputNumbers(String inputWinningLottoNumbers) {
        return inputWinningLottoNumbers.replaceAll("\\s","").split(",");
    }
}

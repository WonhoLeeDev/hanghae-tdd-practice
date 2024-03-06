package tdd.practice.hanghae.lotto;

public class main {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        Lotto lotto = inputView.buyAutomatically();

        ResultView resultView = new ResultView(lotto);
        resultView.getBuyCount();
        resultView.getBoughtLottoList();

        inputView.inputWinningNumbers();
        resultView.getWinningResult();
    }
}

package tdd.hanghae.lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import tdd.practice.hanghae.lotto.InputView;
import tdd.practice.hanghae.lotto.Lotto;

public class LottoExcuteTest {

    @Test
    @DisplayName("excute lotto buy")
    void lottoExcuteTest() {
        InputView inputView = new InputView();
        inputView.buy();

//        ResultView resultView = new ResultView(lotto);
//        resultView.getBuyResult();
//
//        inputView.setWinningNumbers();
//        resultView.getWinningResult();
    }
}

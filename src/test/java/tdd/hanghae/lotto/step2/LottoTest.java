package tdd.hanghae.lotto.step2;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import tdd.practice.hanghae.lotto.step2.Lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LottoTest {

    private int buyAmount = 5000;
    @Test
    @DisplayName("get lotto buy count by buy amount")
    void getLottoCountByBuyAmountTest() {
        Lotto lotto = new Lotto(buyAmount);
        int buyCount = lotto.getLottoBuyCountByBuyAmount(buyAmount);
        Assertions.assertThat(buyCount).isEqualTo(buyAmount/lotto.getLottoPrice());
    }

    @Test
    @DisplayName("get random lotto numbers list by lotto buy count.")
    void getLottoNumbersListTest() {
        Lotto lotto = new Lotto(buyAmount);
        int buyCount = lotto.getLottoBuyCountByBuyAmount(buyAmount);
        List<List<Integer>> lottoBuyList = lotto.generateRandomLottoNumbers(buyCount);
        Assertions.assertThat(lottoBuyList).size().isEqualTo(buyCount);
    }

}

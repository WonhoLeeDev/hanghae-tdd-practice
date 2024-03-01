package tdd.hanghae.lotto.step2;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import tdd.practice.hanghae.lotto.step2.Lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LottoTest {

    int buyAmount = 5000;
    Lotto lotto = new Lotto(buyAmount);
    int buyCount = lotto.getLottoBuyCountByBuyAmount(buyAmount);

    @Test
    @DisplayName("get lotto buy count by buy amount")
    void getLottoCountByBuyAmountTest() {
        Assertions.assertThat(buyCount).isEqualTo(buyAmount/lotto.getLottoPrice());
    }

    @Test
    @DisplayName("get random lotto numbers list by lotto buy count.")
    void getLottoNumbersListTest() {
        List<List<Integer>> lottoBuyList = lotto.generateRandomLottoNumbers(buyCount);
        Assertions.assertThat(lottoBuyList).size().isEqualTo(buyCount);
    }

    @Test
    @DisplayName("count matched lotto numbers with winning numbers")
    void getLottoNumbersMatchCountTest() {
        List<List<Integer>> boughtLottoList = lotto.generateRandomLottoNumbers(buyCount);
        List<Integer> winningNumbers = Lotto.getShuffledRandomLottoNumbers();
        int matchCount = lotto.getLottoNumbersMatchCount(boughtLottoList.get(0), winningNumbers);
        System.out.println("matchCount :"+matchCount);
        Assertions.assertThat(matchCount).isBetween(0,6);
    }

}

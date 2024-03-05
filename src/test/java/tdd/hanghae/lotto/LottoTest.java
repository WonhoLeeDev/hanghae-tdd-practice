package tdd.hanghae.lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import tdd.practice.hanghae.lotto.Lotto;
import tdd.practice.hanghae.lotto.Rank;

import java.util.List;
import java.util.function.Predicate;

public class LottoTest {

    private static Lotto lotto;

    @BeforeAll
    static void setUp() {
        int buyAmount = 7000;
        lotto = new Lotto(buyAmount);
    }

    @Test
    @DisplayName("get lotto buy count by buy amount")
    void getLottoCountByBuyAmountTest() {
        Assertions.assertThat(lotto.getBuyCount()).isEqualTo(lotto.getBuyAmount()/lotto.getLottoPrice());
    }

    @Test
    @DisplayName("get random lotto numbers list by lotto buy count.")
    void getLottoNumbersListTest() {
        List<List<Integer>> lottoBuyList = lotto.generateRandomLottoNumbers();
        Assertions.assertThat(lottoBuyList).size().isEqualTo(lotto.getBuyCount());
    }

    @Test
    @DisplayName("match lotto numbers with winning numbers")
    void matchWinningNumbersTest() {
        lotto.buy();
        lotto.setWinningNumbers(Lotto.getShuffledRandomLottoNumbers());
        List<Integer> matchedNumbers = lotto.matchWinningNumbers(lotto.getBoughtLottoList().get(0));

        List<Integer> matchWinningNumbers = lotto.getBoughtLottoList().get(0).stream()
                        .filter(boughtLotto -> lotto.getWinningNumbers().stream().anyMatch(Predicate.isEqual(boughtLotto)))
                        .toList();

        Assertions.assertThat(matchWinningNumbers.containsAll(matchedNumbers)).isTrue();
    }

    @Test
    @DisplayName("get winning numbers match result")
    void setWinningResultTest() {
        lotto.buy();
        lotto.setWinningNumbers(Lotto.getShuffledRandomLottoNumbers());
        lotto.setWinningResult();
        Assertions.assertThat(lotto.getWinningResult().size()).isEqualTo(lotto.getBuyCount());
    }

    @Test
    void rankEnumValueOfTest() {
        Rank rank = Rank.FIFTH;
        Assertions.assertThat(Rank.valueOf(rank.getCountOfMatch(), false)).isEqualTo(rank);
    }

}

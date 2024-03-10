package tdd.hanghae.lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import tdd.practice.hanghae.lotto.Lotto;
import tdd.practice.hanghae.lotto.Rank;

import java.util.ArrayList;
import java.util.Arrays;
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
    void generateLottoNumbersSizeTest() {
        Assertions.assertThat(lotto.getShuffledRandomLottoNumbers().size()).isEqualTo(6);
    }

    @Test
    void getLottoNumbersListTest() {
        List<List<Integer>> lottoBuyList = lotto.generateRandomLottoNumbers();
        Assertions.assertThat(lottoBuyList).size().isEqualTo(lotto.getBuyCount());
    }


    @Test
    void rankEnumValueOfTest() {
        Assertions.assertThat(Rank.valueOf(0, false)).isEqualTo(Rank.MISS);
        Assertions.assertThat(Rank.valueOf(1, false)).isEqualTo(Rank.MISS);
        Assertions.assertThat(Rank.valueOf(2, false)).isEqualTo(Rank.MISS);
        Assertions.assertThat(Rank.valueOf(3, false)).isEqualTo(Rank.FIFTH);
        Assertions.assertThat(Rank.valueOf(4, false)).isEqualTo(Rank.FOURTH);
        Assertions.assertThat(Rank.valueOf(5, false)).isEqualTo(Rank.THIRD);
        Assertions.assertThat(Rank.valueOf(5, true)).isEqualTo(Rank.SECOND);
        Assertions.assertThat(Rank.valueOf(6, false)).isEqualTo(Rank.FIRST);
    }

    @Test
    void getWinningCountTest() {
        lotto.setWinningNumbers(Arrays.asList(1,2,3,4,5,6));
        Assertions.assertThat(lotto.getWinningCount(Arrays.asList(7,8,9,10,12,13))).isEqualTo(0);
        Assertions.assertThat(lotto.getWinningCount(Arrays.asList(1,2,3,11,12,13))).isEqualTo(3);
        Assertions.assertThat(lotto.getWinningCount(Arrays.asList(1,2,3,4,12,13))).isEqualTo(4);
        Assertions.assertThat(lotto.getWinningCount(Arrays.asList(1,2,3,4,5,13))).isEqualTo(5);
        Assertions.assertThat(lotto.getWinningCount(Arrays.asList(1,2,3,4,5,6))).isEqualTo(6);
    }

    @Test
    void getRankTest() {
        lotto.setWinningNumbers(Arrays.asList(1,2,3,4,5,6));
        Assertions.assertThat(lotto.getRank(Arrays.asList(7,8,9,10,12,13))).isEqualTo(Rank.MISS);
        Assertions.assertThat(lotto.getRank(Arrays.asList(1,2,3,11,12,13))).isEqualTo(Rank.FIFTH);
        Assertions.assertThat(lotto.getRank(Arrays.asList(1,2,3,4,12,13))).isEqualTo(Rank.FOURTH);
        Assertions.assertThat(lotto.getRank(Arrays.asList(1,2,3,4,5,13))).isEqualTo(Rank.THIRD);
        Assertions.assertThat(lotto.getRank(Arrays.asList(1,2,3,4,5,6))).isEqualTo(Rank.FIRST);
    }

    @Test
    void secondWinningTest() {
        List<Integer> manualBuyNumbers = Arrays.asList(1,2,3,4,12,13);
        lotto.buyManually(List.of(manualBuyNumbers));
        lotto.setWinningNumbers(Arrays.asList(1,2,3,4,5,6));
        lotto.setBonusNumber(13);

        lotto.setWinningResults();

        Assertions.assertThat(lotto.getWinningResults().get(Rank.SECOND)).isEqualTo(1);
    }

}

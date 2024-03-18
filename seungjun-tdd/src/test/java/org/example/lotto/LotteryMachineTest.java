package org.example.lotto;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;


class LotteryMachineTest {
    @Test
    void create() {
        LotteryMachine lotteryMachine = new LotteryMachine();

        assertThat(lotteryMachine).isNotNull();
    }

    @Test
    void saveWinningNumber() {
        WinningNumber winningNumber = new WinningNumber(List.of(new Number(2)));
        int bonusNumber = 5;

        LotteryMachine lotteryMachine = new LotteryMachine();
        lotteryMachine.saveWinningNumber(winningNumber, bonusNumber);

        assertThat(lotteryMachine.extractWinningNumber()).isNotNull();
        assertThat(lotteryMachine.extractWinningNumber().getWinningNumber().get(0)).isEqualTo(new Number(2));
    }

    @Test
    void matchLottoNumber() {
        List<Number> winningNumbers = new ArrayList<>(List.of(
                new Number(1),
                new Number(2),
                new Number(3),
                new Number(4),
                new Number(5),
                new Number(6))
        );

        WinningNumber winningNumber = new WinningNumber(winningNumbers);
        int bonusNumber = 7;

        LotteryMachine lotteryMachine = new LotteryMachine();
        lotteryMachine.saveWinningNumber(winningNumber, bonusNumber);

        Lotto lotto = new Lotto(List.of(
                new Number(12),
                new Number(37),
                new Number(5),
                new Number(43),
                new Number(2),
                new Number(1))
        );

        int matchNumber = lotteryMachine.matchLottoNumber(lotto);

        assertThat(matchNumber).isEqualTo(3);
    }

    @Test
    void matchBonusNumber() {
        List<Number> winningNumbers = new ArrayList<>(List.of(
                new Number(1),
                new Number(2),
                new Number(3),
                new Number(4),
                new Number(5),
                new Number(6))
        );

        WinningNumber winningNumber = new WinningNumber(winningNumbers);
        int bonusNumber = 41;

        LotteryMachine lotteryMachine = new LotteryMachine();
        lotteryMachine.saveWinningNumber(winningNumber, bonusNumber);

        Lotto lotto = new Lotto(List.of(
                new Number(40),
                new Number(41),
                new Number(42),
                new Number(43),
                new Number(44),
                new Number(45))
        );

        assertTrue(lotteryMachine.matchBonusNumber(lotto));
    }
}

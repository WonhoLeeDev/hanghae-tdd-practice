package org.example.lotto;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class WinningNumberCountTest {
    @Test
    void create() {
        WinningNumberCount winningNumberCount = new WinningNumberCount();

        assertThat(winningNumberCount.three()).isEqualTo(0);
        assertThat(winningNumberCount.four()).isEqualTo(0);
        assertThat(winningNumberCount.five()).isEqualTo(0);
        assertThat(winningNumberCount.six()).isEqualTo(0);
    }

    @Test
    void addWinningNumberCount() {
        WinningNumberCount winningNumberCount = new WinningNumberCount();

        assertThat(winningNumberCount.three()).isEqualTo(0);

        boolean isMatchBonus = false;
        winningNumberCount.addCount(WinningMoney.from(3, isMatchBonus));

        assertThat(winningNumberCount.three()).isEqualTo(1);
    }

    @Test
    void addFiveWinningNumberCountAndBonus() {
        WinningNumberCount winningNumberCount = new WinningNumberCount();

        assertThat(winningNumberCount.fiveBonus()).isEqualTo(0);
        assertThat(winningNumberCount.five()).isEqualTo(0);

        boolean isMatchBonus = true;
        winningNumberCount.addCount(WinningMoney.from(5, isMatchBonus));

        assertThat(winningNumberCount.fiveBonus()).isEqualTo(1);
        assertThat(winningNumberCount.five()).isEqualTo(0);
    }
}

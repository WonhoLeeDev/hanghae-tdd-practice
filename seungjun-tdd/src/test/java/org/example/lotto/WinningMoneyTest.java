package org.example.lotto;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class WinningMoneyTest {
    @Test
    void create() {
        WinningMoney winningMoney = WinningMoney.FIFTH;

        assertThat(winningMoney.getWinningMoney()).isEqualTo(5_000);
    }

    @Test
    void createUsedToMatchNumber() {
        WinningMoney winningMoney = WinningMoney.from(3, false);

        assertThat(winningMoney).isEqualTo(WinningMoney.FIFTH);
    }

    @Test
    void createSecondWinningMoney() {
        WinningMoney winningMoney = WinningMoney.from(5, true);

        assertThat(winningMoney).isEqualTo(WinningMoney.SECOND);
    }
}

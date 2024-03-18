package org.example.lotto;

public enum WinningMoney {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    MISS(0, 0);

    private final int matchNumber;
    private final int winningMoney;

    WinningMoney(int matchNumber, int winningMoney) {
        this.matchNumber = matchNumber;
        this.winningMoney = winningMoney;
    }

    public static WinningMoney from(int matchNumber, boolean isMatchBonus) {
        for (WinningMoney winningMoney : WinningMoney.values()) {
            if (matchNumber == 5 && isMatchBonus) {
                return WinningMoney.SECOND;
            }

            if (winningMoney.matchNumber == matchNumber) {
                return winningMoney;
            }
        }

        return MISS;
    }

    public int getMatchNumber() {
        return matchNumber;
    }

    public int getWinningMoney() {
        return winningMoney;
    }
}

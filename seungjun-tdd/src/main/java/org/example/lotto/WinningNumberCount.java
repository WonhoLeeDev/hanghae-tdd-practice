package org.example.lotto;

public class WinningNumberCount {
    private int three;
    private int four;
    private int five;
    private int fiveBonus;
    private int six;

    public WinningNumberCount() {
        this.three = 0;
        this.four = 0;
        this.five = 0;
        this.fiveBonus = 0;
        this.six = 0;
    }

    public int three() {
        return three;
    }

    public int four() {
        return four;
    }

    public int five() {
        return five;
    }

    public int fiveBonus() {
        return fiveBonus;
    }

    public int six() {
        return six;
    }

    public void addCount(WinningMoney winningMoney) {
        if (WinningMoney.FIFTH == winningMoney) {
            three += 1;
        }

        if (WinningMoney.FOURTH == winningMoney) {
            four += 1;
        }

        if (WinningMoney.THIRD == winningMoney) {
            five += 1;
        }

        if (WinningMoney.SECOND == winningMoney) {
            fiveBonus += 1;
        }

        if (WinningMoney.FIRST == winningMoney) {
            six += 1;
        }
    }
}

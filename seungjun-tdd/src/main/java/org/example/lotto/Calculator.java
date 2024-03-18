package org.example.lotto;

public class Calculator {
    public static double calculateInvestment(int purchaseAmount, int winningAmount) {
        return Math.round((double) winningAmount / purchaseAmount * 100) / 100.0;
    }
}

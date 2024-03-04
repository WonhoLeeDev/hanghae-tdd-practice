package org.example.lotto;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CalculatorTest {
    @Test
    void calculateYield() {
        int purchaseAmount = 10000;
        int winningAmount = 5000;
        double yield = Calculator.calculateInvestment(purchaseAmount, winningAmount);

        assertThat(yield).isEqualTo(0.5);
    }
}

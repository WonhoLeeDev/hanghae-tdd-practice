package org.example.lotto;

import java.util.ArrayList;
import java.util.List;

public class WinningNumber {
    private final List<Number> winningNumbers;

    public WinningNumber(List<Number> numbers) {
        this.winningNumbers = numbers;
    }

    public List<Number> getWinningNumber() {
        return new ArrayList<>(winningNumbers);
    }
}

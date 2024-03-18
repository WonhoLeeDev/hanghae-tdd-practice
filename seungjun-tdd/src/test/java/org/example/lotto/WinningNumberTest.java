package org.example.lotto;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


class WinningNumberTest {
    @Test
    void create() {
        List<Number> numbers = new ArrayList<>(List.of(new Number(1),
                new Number(2),
                new Number(3),
                new Number(4),
                new Number(5),
                new Number(6))
        );

        WinningNumber winningNumber = new WinningNumber(numbers);

        assertThat(winningNumber).isNotNull();
        assertThat(winningNumber.getWinningNumber().size()).isEqualTo(6);
    }
}

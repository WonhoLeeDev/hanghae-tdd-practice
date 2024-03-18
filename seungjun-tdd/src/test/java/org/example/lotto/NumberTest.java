package org.example.lotto;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class NumberTest {
    @Test
    void createLottoNumber() {
        Number number = new Number(1);

        assertThat(number).isNotNull();
        assertThat(number.getNumber()).isEqualTo(1);
    }

    @Test
    void equalsLottoNumber() {
        Number number = new Number(2);
        Number otherNumber = new Number(2);

        assertThat(number).isEqualTo(otherNumber);
    }
}

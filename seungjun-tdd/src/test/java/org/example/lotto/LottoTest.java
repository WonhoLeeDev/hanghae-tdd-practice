package org.example.lotto;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoTest {
    @Test
    void createLotto() {
        Lotto lotto = Lotto.create();

        assertThat(lotto).isNotNull();
    }

    @Test
    void lottoSize() {
        Lotto lotto = Lotto.create();

        assertThat(lotto.size()).isEqualTo(6);
    }

}

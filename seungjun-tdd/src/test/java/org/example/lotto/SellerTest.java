package org.example.lotto;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SellerTest {
    @Test
    void create() {
        Seller seller = new Seller();

        assertThat(seller).isNotNull();
    }

    @Test
    void sellLotto() {
        Seller seller = new Seller();

        int money = 10_000;
        int lottoQuantity = seller.sell(money);

        assertThat(lottoQuantity).isEqualTo(10);
    }

    @Test
    void lackOfMoney() {
        Seller seller = new Seller();

        int money = 999;
        int lottoQuantity = seller.sell(money);

        assertThat(lottoQuantity).isEqualTo(0);
    }
}

package org.example.lotto;

public class Seller {
    private static final int LOTTO_PRICE = 1_000;
    public int sell(int money) {
        if (money < LOTTO_PRICE) {
            System.out.println("금액이 충분하지 않습니다.");
            return 0;
        }
        return money / LOTTO_PRICE;
    }
}

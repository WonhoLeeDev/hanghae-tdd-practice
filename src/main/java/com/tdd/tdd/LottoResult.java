package com.tdd.tdd;

import java.security.InvalidParameterException;
import java.util.Arrays;

public enum LottoResult {
    FIRST(6, 2_000_000_000),
    SECOND_BONUS(5, 3_000_000),
    SECOND(5, 1_500_000),
    THIRD(4, 50_000),
    FOURTH(3, 5_000),
    ;

    private int correct;
    private int rewardMoney;

    LottoResult(int correct, int rewardMoney) {
        this.correct = correct;
        this.rewardMoney = rewardMoney;
    }

    public int getCorrect() {
        return correct;
    }

    public int getRewardMoney() {
        return rewardMoney;
    }

    public static LottoResult valueOf(int correct){
        return Arrays.stream(values())
                .filter(result->result.getCorrect()==correct)
                .findFirst()
                .orElseThrow(InvalidParameterException::new);
    }
}

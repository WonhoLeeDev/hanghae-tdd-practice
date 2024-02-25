package com.tdd.tdd;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class AutoLottoTest {
    private InputView inputView= new InputView();
    private AutoLotto autoLotto = new AutoLotto();

    @Test
    public void generateLotto(){
        String input = "14000";
        ByteArrayInputStream testIn = new ByteArrayInputStream(input.getBytes());
        System.setIn(testIn);
        int buyCount = inputView.getBuyCount();
        Map<Integer, List<Integer>> map = autoLotto.autoLottoPrint(buyCount);
        assertThat(map.size()).isEqualTo(14);
    }

}
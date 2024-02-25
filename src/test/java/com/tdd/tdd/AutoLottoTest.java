package com.tdd.tdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class AutoLottoTest {
    private InputView inputView;
    private ResultView resultView= new ResultView();
    private Calculator calculator=new Calculator();
    private AutoLotto autoLotto = new AutoLotto();


    @BeforeEach
    public void beforeEach(){
        String purchase = "14000\n";
        String answer = "1, 2, 3, 4, 5, 6";
        byte[] purchaseBytes = purchase.getBytes();
        byte[] answerBytes = answer.getBytes();
        byte[] inputs = new byte[purchaseBytes.length + answerBytes.length];
        System.arraycopy(purchaseBytes, 0, inputs, 0, purchaseBytes.length);
        System.arraycopy(answerBytes, 0, inputs, purchaseBytes.length, answerBytes.length);
        ByteArrayInputStream testIn = new ByteArrayInputStream(inputs);
        System.setIn(testIn);
        inputView = new InputView(System.in);
    }
    @Test
    public void generateLotto(){
        int buyCount = inputView.getBuyCount();
        Map<Integer, List<Integer>> lottoNumbers = autoLotto.autoLottoPrint(buyCount);
        assertThat(lottoNumbers.size()).isEqualTo(14);
        Set<Integer> winningNumbers = inputView.printLottoWinningNumbers();
        Map<Integer, Integer> result = calculator.calculate(lottoNumbers, winningNumbers);
        resultView.printResult(buyCount, result);
    }

}
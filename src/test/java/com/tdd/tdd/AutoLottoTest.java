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
        String purchase = "150000\n";
        String answer = "28, 32, 30, 9, 40, 11\n";
        String bonusNumber="7\n";
        byte[] purchaseBytes = purchase.getBytes();
        byte[] answerBytes = answer.getBytes();
        byte[] bonusNumberBytes = bonusNumber.getBytes();
        byte[] inputs = new byte[purchaseBytes.length + answerBytes.length+bonusNumberBytes.length];
        System.arraycopy(purchaseBytes, 0, inputs, 0, purchaseBytes.length);
        System.arraycopy(answerBytes, 0, inputs, purchaseBytes.length, answerBytes.length);
        System.arraycopy(bonusNumberBytes, 0, inputs, purchaseBytes.length + answerBytes.length, bonusNumberBytes.length);
        ByteArrayInputStream testIn = new ByteArrayInputStream(inputs);
        System.setIn(testIn);
        inputView = new InputView(System.in);
    }
    @Test
    public void generateLotto(){
        int buyCount = inputView.getBuyCount();
        Map<Integer, List<Integer>> lottoNumbers = autoLotto.autoLottoPrint(buyCount);
        assertThat(lottoNumbers.size()).isEqualTo(150);
        Set<Integer> winningNumbers = inputView.printLottoWinningNumbers();
        Integer bonusNumber = inputView.printBonusNumber();
        Map<LottoResult, Integer> result = calculator.calculate(lottoNumbers, winningNumbers, bonusNumber);
        resultView.printResult(buyCount, result);
    }

}
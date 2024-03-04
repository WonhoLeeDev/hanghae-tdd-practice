package org.example;

import org.example.lotto.*;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        Seller seller = new Seller();
        LotteryMachine lotteryMachine = new LotteryMachine();

        int amount = inputView.buyAmount();
        int lottoNumber = seller.sell(amount);
        if (lottoNumber == 0) {
            return;
        }

        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < lottoNumber; i += 1) {
            lottos.add(Lotto.create());
        }

        outputView.outputLottoNumber(lottos);
        WinningNumber winningNumber = inputView.winningNumber();
        int bonusNumber = inputView.bonusNumber();
        lotteryMachine.saveWinningNumber(winningNumber, bonusNumber);

        WinningNumberCount winningNumberCount = new WinningNumberCount();
        int totalWinningAmount = 0;
        for (Lotto lotto : lottos) {
            int matchNumber = lotteryMachine.matchLottoNumber(lotto);
            boolean isMatchBonus = lotteryMachine.matchBonusNumber(lotto);
            WinningMoney winningMoney = WinningMoney.from(matchNumber, isMatchBonus);
            totalWinningAmount += winningMoney.getWinningMoney();
            winningNumberCount.addCount(winningMoney);
        }
        
        double yield = Calculator.calculateInvestment(amount, totalWinningAmount);

        outputView.result(winningNumberCount, yield);
    }
}
package org.example;

import org.example.lotto.Lotto;
import org.example.lotto.WinningNumberCount;

import java.util.List;

public class OutputView {
    public void outputLottoNumber(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getLottoNumbers());
        }
    }

    public void result(WinningNumberCount winningNumberCount, double yield) {
        System.out.println("당첨 통계");
        System.out.println("---------");
        System.out.println("3개 일치 (5000원) - " + winningNumberCount.three() + "개");
        System.out.println("4개 일치 (50000원) - " + winningNumberCount.four() + "개");
        System.out.println("5개 일치 (1500000원) - " + winningNumberCount.five() + "개");
        System.out.println("5개 일치, 보너스 볼 일치(30000000원) - " + winningNumberCount.fiveBonus() + "개");
        System.out.println("6개 일치 (2000000000) - " + winningNumberCount.six() + "개");
        System.out.println("총 수익률은 " + yield + "입니다.");
    }
}

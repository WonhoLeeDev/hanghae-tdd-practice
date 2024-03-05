package com.tdd.tdd;

import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

public class ResultView {
    public void printResult(int buyCount, Map<LottoResult, Integer> resultMap) {
        int totalResult =0 ;
        TreeMap<LottoResult, Integer> sortedMap = new TreeMap<>(Collections.reverseOrder());
        sortedMap.putAll(resultMap);
        for (LottoResult result : sortedMap.keySet()) {
            int correct = result.getCorrect();
            int amount = result.getRewardMoney();
            if(result==LottoResult.SECOND_BONUS){
                System.out.printf("%d개 일치, 보너스 볼 일치(%d원)- %d개\n", correct, amount , resultMap.get(result));
            }else{
                System.out.printf("%d개 일치 (%d원)- %d개\n", correct, amount , resultMap.get(result));
            }
            totalResult += amount*(resultMap.get(result));
        }
        calculateRateOfReturn(buyCount, totalResult);
    }

    private void calculateRateOfReturn(int buyCount, int totalResult) {
        buyCount*=1000;
        double result = (double)totalResult / buyCount;
        System.out.printf("총 수익률은 %.2f입니다.\n",result);
    }
}

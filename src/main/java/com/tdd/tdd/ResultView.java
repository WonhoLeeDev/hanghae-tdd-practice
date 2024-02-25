package com.tdd.tdd;

import java.util.Map;

public class ResultView {
    public void printResult(int buyCount, Map<Integer, Integer> result) {
        int totalResult =0 ;
        for (Integer key : result.keySet()) {
            int amount = 5000*(key-2);
            System.out.printf("%d개 일치 (%d원)- %d개\n", key,amount , result.get(key));
            totalResult += amount*(result.get(key));
        }
        calculateRateOfReturn(buyCount, totalResult);
    }

    private void calculateRateOfReturn(int buyCount, int totalResult) {
        buyCount*=1000;
        double result = (double)totalResult / buyCount;
        System.out.printf("총 수익률은 %.2f입니다.\n",result);
    }
}

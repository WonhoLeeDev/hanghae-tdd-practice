package com.tdd.tdd;

import java.util.*;

public class Calculator {

    private Map<LottoResult, Integer> resultMap= new HashMap<>();

    private void mapInit() {
        resultMap.put(LottoResult.FOURTH,0);
        resultMap.put(LottoResult.THIRD,0);
        resultMap.put(LottoResult.SECOND,0);
        resultMap.put(LottoResult.SECOND_BONUS,0);
        resultMap.put(LottoResult.FIRST,0);
    }
    public Map<LottoResult, Integer> calculate(Map<Integer, List<Integer>> lottoNumbers, Set<Integer> winningNumbers, Integer bonusNumber){
        mapInit();
        for (Integer key : lottoNumbers.keySet()) {
            List<Integer> lottoNumber = lottoNumbers.get(key);
            int matchResult = compare(lottoNumber, winningNumbers);
            boolean isBonusNumberMatch=compareBonusNumber(lottoNumber, bonusNumber);
            if(matchResult>2){
                if(matchResult==5 && isBonusNumberMatch){
                    resultMap.put(LottoResult.SECOND_BONUS, resultMap.get(LottoResult.SECOND_BONUS)+1);
                }else{
                    resultMap.put(LottoResult.valueOf(matchResult), resultMap.get(LottoResult.valueOf(matchResult))+1);
                }
            }
        }
        return resultMap;
    }

    private boolean compareBonusNumber(List<Integer> lottoNumber, Integer bonusNumber) {
        return lottoNumber.contains(bonusNumber);
    }


    private int compare(List<Integer> lottoNumber, Set<Integer> winningNumbers) {
        int matchCount=0;
        for (Integer number : lottoNumber) {
            if(winningNumbers.contains(number)){
                matchCount++;
            }
        }
        return matchCount;
    }
}

package com.tdd.tdd;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Calculator {

    private Map<Integer, Integer> resultMap= new HashMap<>();

    private void mapInit() {
        resultMap.put(3,0);
        resultMap.put(4,0);
        resultMap.put(5,0);
        resultMap.put(6,0);
    }
    public Map<Integer, Integer> calculate(Map<Integer, List<Integer>> lottoNumbers, Set<Integer> winningNumbers){
        mapInit();
        for (Integer key : lottoNumbers.keySet()) {
            List<Integer> lottoNumber = lottoNumbers.get(key);
            int matchResult = compare(lottoNumber, winningNumbers);
            if(matchResult>2){
               resultMap.put(matchResult, resultMap.get(matchResult)+1);
            }
        }
        return resultMap;
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

package com.tdd.tdd;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class AutoLotto {

    private final int START_NUMBER = 1;
    private final int END_NUMBER = 46;

    private List<Integer> NUMBERS = new ArrayList<>(IntStream.range(START_NUMBER, END_NUMBER).boxed().toList());
    public Map<Integer, List<Integer>> autoLottoPrint(int count){
        Map<Integer, List<Integer>> lottoMap = new HashMap<>();
        for(int i=0;i<count;i++){
           lottoMap.put(i, generateRandomNumber());
           System.out.println(lottoMap.get(i));
        }
        return lottoMap;
    }

    private List<Integer> generateRandomNumber() {
        Collections.shuffle(NUMBERS);
        return NUMBERS.stream().limit(6).collect(Collectors.toList());
    }
}

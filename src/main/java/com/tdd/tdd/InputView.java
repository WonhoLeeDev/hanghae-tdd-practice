package com.tdd.tdd;

import java.io.InputStream;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class InputView {

    private Scanner sc;

    public InputView(InputStream inputStream){
        this.sc = new Scanner(inputStream);
    }
    public int getBuyCount(){
        System.out.println("구매금액을 입력해주세요.");
        int buy = sc.nextInt()/1000;
        sc.nextLine();
        System.out.println(buy+"개를 구매했습니다.");
        return buy;
    }


    public Set<Integer> printLottoWinningNumbers(){
        System.out.println("\n지난 주 당첨 번호를 입력해주세요.");
        String result = sc.nextLine();
        String[] winningNumbers = result.split(", ");
        return Arrays.stream(winningNumbers)
                .map(Integer::parseInt)
                .collect(Collectors.toSet());
    }


}

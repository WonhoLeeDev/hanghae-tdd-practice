package com.tdd.tdd;

import java.util.Scanner;

public class InputView {

    public int getBuyCount(){
        Scanner sc = new Scanner(System.in);
        System.out.println("구매금액을 입력해주세요.");
        int buy = sc.nextInt()/1000;
        System.out.println(buy+"개를 구매했습니다.");
        return buy;
    }


}

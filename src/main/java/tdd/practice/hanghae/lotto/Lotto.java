package tdd.practice.hanghae.lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {
    public static final int PRICE = 1000;
    private int buyMoney = 0;

    private int buyCount = 0;

    private List<List<Integer>> boughtLottoList = new ArrayList<>();

    public Lotto(int buyMoney) {
        this.buyMoney = buyMoney;
        this.buyCount = buyMoney/Lotto.PRICE;
    }

    public int getBuyMoney() {
        return buyMoney;
    }

    public int getBuyCount() {
        return buyCount;
    }

    public List<List<Integer>> getBoughtLottoList() {
        return boughtLottoList;
    }

    public void buyLotto() {
        for(int i = 0; i< this.buyCount; i++) {
            this.boughtLottoList.add(getLottoNumbers());
        }
    }

    private static List<Integer> getLottoNumbers() {
        List<Integer> numbers = get45Numbers();
        Collections.shuffle(numbers);
        List<Integer> lottoNumbers = numbers.subList(0, 6);
        Collections.sort(lottoNumbers);
        return lottoNumbers;
    }

    private static List<Integer> get45Numbers() {
        List<Integer> numbers = new ArrayList<>();
        for(int i=1; i<46; i++) {
            numbers.add(i);
        }
        return numbers;
    }


    public void printBoughtLottoList() {
        for (List<Integer> integers : this.boughtLottoList) {
            System.out.println(integers);
        }
    }
}

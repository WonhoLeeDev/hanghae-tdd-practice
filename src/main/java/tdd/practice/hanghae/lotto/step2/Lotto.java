package tdd.practice.hanghae.lotto.step2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {
    private final int LOTTO_PRICE = 1000;

    int buyAmount;

    public Lotto(int buyAmount) {
        this.buyAmount = buyAmount;

    }

    public List<List<Integer>> generateRandomLottoNumbers(int buyCount) {
        List<Integer> lottoNumbers = generateLottoNumbers();

        List<List<Integer>> boughtLottoList = new ArrayList<>();
        for(int i = 0; i< buyCount; i++) {
            List<Integer> randomLottoNumbers = getShuffledRandomLottoNumbers(lottoNumbers);
            boughtLottoList.add(randomLottoNumbers);
        }
        return boughtLottoList;
    }

    private static List<Integer> getShuffledRandomLottoNumbers(List<Integer> lottoNumbers) {
        Collections.shuffle(lottoNumbers);
        List<Integer> randomLottoNumbers = lottoNumbers.subList(0, 6);
        Collections.sort(randomLottoNumbers);
        return randomLottoNumbers;
    }

    private static List<Integer> generateLottoNumbers() {
        List<Integer> lottoNumbers = new ArrayList<>();
        for(int i=1; i<46; i++) {
            lottoNumbers.add(i);
        }
        return lottoNumbers;
    }

    public int getLottoBuyCountByBuyAmount(int buyAmount) {
        return buyAmount/this.LOTTO_PRICE;
    }

    public int getLottoPrice() {
        return this.LOTTO_PRICE;
    }
}

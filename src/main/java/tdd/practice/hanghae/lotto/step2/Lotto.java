package tdd.practice.hanghae.lotto.step2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

public class Lotto {
    private final int LOTTO_PRICE = 1000;

    int buyAmount;

    public Lotto(int buyAmount) {
        this.buyAmount = buyAmount;

    }

    public List<List<Integer>> generateRandomLottoNumbers(int buyCount) {
        List<List<Integer>> boughtLottoList = new ArrayList<>();
        for(int i = 0; i< buyCount; i++) {
            List<Integer> randomLottoNumbers = getShuffledRandomLottoNumbers();
            boughtLottoList.add(randomLottoNumbers);
        }
        return boughtLottoList;
    }

    public static List<Integer> getShuffledRandomLottoNumbers() {
        List<Integer> lottoNumbers = new ArrayList<>(generateLottoNumbers());
        Collections.shuffle(lottoNumbers);
        Collections.sort(lottoNumbers.subList(0, 6));
        return lottoNumbers;
    }

    public static Set<Integer> generateLottoNumbers() {
        return (Set<Integer>) Stream.iterate(0, n -> n + 1).limit(45);
    }

    public int getLottoBuyCountByBuyAmount(int buyAmount) {
        return buyAmount/this.LOTTO_PRICE;
    }

    public int getLottoPrice() {
        return this.LOTTO_PRICE;
    }

    public int getLottoNumbersMatchCount(List<Integer> boughtLotto, List<Integer> winningNumbers) {
        return 0;
    }
}

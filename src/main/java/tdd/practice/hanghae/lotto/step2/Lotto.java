package tdd.practice.hanghae.lotto.step2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Lotto {
    private final int LOTTO_PRICE = 1000;

    int buyAmount;

    int buyCount;

    public Lotto(int buyAmount) {
        this.buyAmount = buyAmount;
        this.buyCount = setLottoBuyCountByBuyAmount();
    }

    public int getBuyAmount() {
        return buyAmount;
    }

    public int getBuyCount() {
        return buyCount;
    }

    public List<List<Integer>> generateRandomLottoNumbers() {
        List<List<Integer>> boughtLottoList = new ArrayList<>();
        IntStream.range(0, this.buyCount)
                .mapToObj(i -> getShuffledRandomLottoNumbers())
                .forEach(boughtLottoList::add);
        System.out.println(boughtLottoList);
        return boughtLottoList;
    }

    public static List<Integer> getShuffledRandomLottoNumbers() {
        List<Integer> generatedlottoNumbers = new ArrayList<>(generateLottoNumbers());
        Collections.shuffle(generatedlottoNumbers);
        List<Integer> shuffledLottoNumbers = generatedlottoNumbers.subList(0, 6);
        Collections.sort(shuffledLottoNumbers);
        return shuffledLottoNumbers;
    }

    public static List<Integer> generateLottoNumbers() {
        return IntStream.rangeClosed(1, 45).boxed().collect(Collectors.toList());
    }

    public int setLottoBuyCountByBuyAmount() {
        return this.buyAmount/this.LOTTO_PRICE;
    }

    public int getLottoPrice() {
        return this.LOTTO_PRICE;
    }

    public int getLottoNumbersMatchCount(List<Integer> boughtLotto, List<Integer> winningNumbers) {
        return 0;
    }
}

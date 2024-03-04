package tdd.practice.hanghae.lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lotto {
    private final int LOTTO_PRICE = 1000;

    int buyAmount;

    int buyCount;

    List<List<Integer>> boughtLottoList;

    List<List<Integer>> winningResult;

    List<Integer> winningNumbers;

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

    public void setWinningResult() {
        this.winningResult = this.boughtLottoList.stream()
                .map(this::matchWinningNumbers)
                .toList();
    }

    public List<List<Integer>> getWinningResult() {
        return winningResult;
    }

    public void setWinningNumbers(List<Integer> winningNumbers) {
        this.winningNumbers = winningNumbers;
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }

    public void buy() {
        this.boughtLottoList = this.generateRandomLottoNumbers();
    }

    public List<List<Integer>> getBoughtLottoList() {
        return boughtLottoList;
    }

    public List<List<Integer>> generateRandomLottoNumbers() {
        List<List<Integer>> boughtLottoList = new ArrayList<>();
        IntStream.range(0, this.buyCount)
                .mapToObj(i -> getShuffledRandomLottoNumbers())
                .forEach(boughtLottoList::add);
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

    public List<Integer> matchWinningNumbers(List<Integer> boughtLotto) {
        return boughtLotto.stream()
                .filter(lotto -> winningNumbers.stream().anyMatch(Predicate.isEqual(lotto)))
                .toList();
    }
}

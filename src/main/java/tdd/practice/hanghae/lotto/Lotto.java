package tdd.practice.hanghae.lotto;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lotto {
    private final int LOTTO_PRICE = 1000;

    private int buyAmount;

    private int buyCount;

    private List<List<Integer>> boughtLottoList;

    private List<List<Integer>> winningResult;

    private Map<Rank, Integer> winningResult2 = new HashMap<>();

    private List<Integer> winningNumbers;

    private int bonusNumber;

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

    public void setWinningResult2() {
        for (List<Integer> boughtLotto : this.boughtLottoList) {
            int winningCount = getWinningCount(boughtLotto);

            boolean matchBonus = false;
            // winnningCount 4개 2등체크
            if(winningCount == 4 && boughtLotto.contains(this.bonusNumber)) {
                matchBonus = true;
            }

            Rank rank = Rank.valueOf(getWinningCount(boughtLotto), matchBonus);
            this.winningResult2.merge(rank, 1, Integer::sum);
        }
        System.out.println("result : " + this.winningResult2);
    }

    private int getWinningCount(List<Integer> boughtLotto) {
        return (int) boughtLotto.stream()
                .filter(winningNumbers::contains)
                .count();
    }

    public List<Integer> matchWinningNumbers2(List<Integer> boughtLotto) {
        return boughtLotto.stream()
                .filter(lotto -> winningNumbers.stream().anyMatch(Predicate.isEqual(lotto)))
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

    public void setBonusNumber(int bonusNumber) {
        this.bonusNumber = bonusNumber;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    public void buyAutomatically() {
        this.boughtLottoList = this.generateRandomLottoNumbers();
    }

    public void buyManually(List<List<Integer>> numbers) {
        this.boughtLottoList = numbers;
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

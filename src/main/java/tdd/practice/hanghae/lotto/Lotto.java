package tdd.practice.hanghae.lotto;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lotto {
    private static final int LOTTO_PRICE = 1000;

    private int buyAmount;

    private int buyCount;

    private List<List<Integer>> boughtLottoList;

    private List<List<Integer>> winningResult;

    private Map<Rank, Integer> winningResults = new HashMap<>();

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

    public void setWinningResults() {
        for (List<Integer> boughtLotto : this.boughtLottoList) {
            this.winningResults.merge(getRank(boughtLotto), 1, Integer::sum);
        }
    }

    public Rank getRank(List<Integer> boughtLotto) {
        int winningCount = getWinningCount(boughtLotto);
        boolean matchBonus = false;
        if(winningCount == 4 && boughtLotto.contains(this.bonusNumber)) {
            winningCount++;
            matchBonus = true;
        }
        return Rank.valueOf(winningCount, matchBonus);
    }

    public Map<Rank, Integer> getWinningResults() {
        return winningResults;
    }

    public int getWinningCount(List<Integer> boughtLotto) {
        return (int) boughtLotto.stream()
                .filter(winningNumbers::contains)
                .count();
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
        this.validateBuyAmount();
        this.boughtLottoList = this.generateRandomLottoNumbers();
    }

    public void buyManually(List<List<Integer>> numbers) {
        this.validateBuyAmount();
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

    public void validateBuyAmount() {
        if (this.buyAmount < Lotto.LOTTO_PRICE) {
            throw new IllegalArgumentException("금액 부족");
        }
    }

    public void validateWinningNumbers(List<Integer> winningNumbers) {
        validateWinningNumbersSize(winningNumbers);

        validateWinningNumbersDupl(winningNumbers);
    }

    public void validateWinningNumbersDupl(List<Integer> winningNumbers) {
        Set<Integer> winningNumbersSet = Set.copyOf(winningNumbers);
        if (winningNumbersSet.size() != 6) {
            throw new IllegalArgumentException("당첨번호 중복");
        }
    }

    public void validateWinningNumbersSize(List<Integer> WinningNumbers) {
        if (WinningNumbers.size() > 6) {
            throw new IllegalArgumentException("당첨번호 갯수 초과");
        }

        if (WinningNumbers.size() < 6) {
            throw new IllegalArgumentException("당첨번호 갯수 부족");
        }
    }

}

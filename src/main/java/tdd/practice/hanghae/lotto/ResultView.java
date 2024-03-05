package tdd.practice.hanghae.lotto;

import java.util.List;

public class ResultView {

    Lotto lotto;

    public ResultView(Lotto lotto) {
        this.lotto = lotto;
    }

    public void getBuyCount() {
        System.out.println(this.lotto.getBuyCount()+"개를 구매했습니다.");
    }

    public void getBoughtLottoList() {
        List<List<Integer>> boughtLottoList = this.lotto.getBoughtLottoList();
        for (List<Integer> boughtLotto : boughtLottoList) {
            System.out.println(boughtLotto);
        }
    }

    public void getWinningResult() {
        printWinningResult(getMatchCount());
    }

    private void printWinningResult(int[] matchCount) {
        int fifthMoney = Rank.valueOf(matchCount[3], false).getWinningMoney();
        int fourthMoney = Rank.valueOf(matchCount[4], false).getWinningMoney();
        int thirdMoney = Rank.valueOf(matchCount[5], false).getWinningMoney();
        int firstMoney = Rank.valueOf(matchCount[6], false).getWinningMoney();

        System.out.println("당첨 통계");
        System.out.println("--------");
        System.out.println("3개 일치 (" + fifthMoney + "원)-" + matchCount[3] + "개");
        System.out.println("4개 일치 (" + fourthMoney + "원)-" + matchCount[4] + "개");
        System.out.println("5개 일치 (" + thirdMoney + "원)-" + matchCount[5] + "개");
        System.out.println("6개 일치 (" + firstMoney + "원)-" + matchCount[6] + "개");
        int winningPrize = ((fifthMoney * matchCount[3]) +
                            (fourthMoney * matchCount[4]) +
                            (thirdMoney * matchCount[5]) +
                            (firstMoney * matchCount[6])) / this.lotto.getBuyAmount();
        System.out.println("총 수익률은" + winningPrize + "입니다.");
    }

    private int[] getMatchCount() {
        int[] matchCount = new int[7];
        List<List<Integer>> winningResult = this.lotto.getWinningResult();
        winningResult.stream()
                .map(List::size)
                .filter(size -> size >= 3 && size <= 6)
                .forEach(size -> matchCount[size]++);
        return matchCount;
    }
}

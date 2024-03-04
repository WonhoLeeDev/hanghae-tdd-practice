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
        System.out.println("당첨 통계");
        System.out.println("--------");

        int[] matchCount = new int[7];
        List<List<Integer>> winningResult = this.lotto.getWinningResult();
        for (List<Integer> winning : winningResult) {
            int size = winning.size();
            if (size >= 3 && size <= 6) {
                matchCount[size]++;
            }
        }
        System.out.println("3개 일치 (" + (5000 * matchCount[3]) + "원)-" + matchCount[3] + "개");
        System.out.println("4개 일치 (" + (50000 * matchCount[4]) + "원)-" + matchCount[4] + "개");
        System.out.println("5개 일치 (" + (1500000 * matchCount[5]) + "원)-" + matchCount[5] + "개");
        System.out.println("6개 일치 (" + (2000000000 * matchCount[6]) + "원)-" + matchCount[6] + "개");
        int winningPrize = ( (5000 * matchCount[3]) + (50000 * matchCount[4]) + (1500000 * matchCount[5]) + (2000000000 * matchCount[6]) ) / this.lotto.getBuyAmount();
        System.out.println("총 수익률은" + winningPrize + "입니다.");
    }
}

package tdd.practice.hanghae.lotto;

import java.util.List;
import java.util.Map;

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
        System.out.println("3개 일치 (" + Rank.FIFTH.getWinningMoney() + "원)-" + checkWinningResultNull(Rank.FIFTH) + "개");
        System.out.println("4개 일치 (" + Rank.FOURTH.getWinningMoney() + "원)-" + checkWinningResultNull(Rank.FOURTH) + "개");
        System.out.println("5개 일치 (" + Rank.THIRD.getWinningMoney() + "원)-" + checkWinningResultNull(Rank.THIRD) + "개");
        System.out.println("5개 일치 , 보너스 볼 일치(" + Rank.SECOND.getWinningMoney() + "원)-" + checkWinningResultNull(Rank.SECOND) + "개");
        System.out.println("6개 일치 (" + Rank.FIRST.getWinningMoney() + "원)-" + checkWinningResultNull(Rank.FIRST) + "개");
        int winningPrize = (
                (Rank.FIFTH.getWinningMoney() * checkWinningResultNull(Rank.FIFTH)) +
                (Rank.FOURTH.getWinningMoney() * checkWinningResultNull(Rank.FOURTH)) +
                (Rank.THIRD.getWinningMoney() * checkWinningResultNull(Rank.THIRD)) +
                (Rank.SECOND.getWinningMoney() * checkWinningResultNull(Rank.SECOND)) +
                (Rank.FIRST.getWinningMoney() * checkWinningResultNull(Rank.FIRST))
        )/ this.lotto.getBuyAmount();
        System.out.println("총 수익률은" + winningPrize + "입니다.");
    }

    private int checkWinningResultNull(Rank rank) {
        Map<Rank, Integer> winningResults = this.lotto.getWinningResults();
        return winningResults.get(rank) == null ? 0 : winningResults.get(rank);
    }
}

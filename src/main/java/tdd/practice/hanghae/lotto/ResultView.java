package tdd.practice.hanghae.lotto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ResultView {

    private Lotto lotto;
    private String[] winningLottoNumbers;

    public ResultView(Lotto lotto, String[] winningLottoNumbers) {
        this.lotto = lotto;
        this.winningLottoNumbers = winningLottoNumbers;
    }

    public void showLottoResult() {
        System.out.println("총 수익률은 " + getPrizeMoney()/lotto.getBuyMoney() + "입니다.");
    }

    /* 리팩토링 해야됨 */
    public int getPrizeMoney() {
        int matched3NumbersCount = 0;
        int matched4NumbersCount = 0;
        int matched5NumbersCount = 0;
        int matched6NumbersCount = 0;

        for (Integer i : getMatchTotalCount()) {
            if(i==3) {
                matched3NumbersCount++;
            }
            if(i==4) {
                matched4NumbersCount++;
            }
            if(i==5) {
                matched5NumbersCount++;
            }
            if(i==6) {
                matched6NumbersCount++;
            }
        }
        System.out.println("당첨 통계");
        System.out.println("--------");
        System.out.println("3개 일치 (" + 5000 + "원)- " + matched3NumbersCount+"개");
        System.out.println("4개 일치 (" + 50000 + "원)- " + matched4NumbersCount+"개");
        System.out.println("5개 일치 (" + 159000 + "원)- " + matched5NumbersCount+"개");
        System.out.println("6개 일치 (" + 2000000000 + "원)- " + matched6NumbersCount+"개");
        return (5000*matched3NumbersCount) + (50000*matched4NumbersCount) + (159000*matched5NumbersCount) + (2000000000*matched6NumbersCount);
    }

    public List<Integer> getMatchTotalCount() {
        List<Integer> matchTotalCount = new ArrayList<>();
        for (List<Integer> boughtLotto : lotto.getBoughtLottoList()) {
            int matchCount = getMatchCount(boughtLotto);
            if(matchCount>=3) {
                matchTotalCount.add(matchCount);
            }
        }
        return matchTotalCount;
    }

    public int getMatchCount(List<Integer> boughtLotto) {
        int matchCount = 0;
        for (String winningLottoNumber : this.winningLottoNumbers) {
            if(boughtLotto.contains(Integer.parseInt(winningLottoNumber))) {
                matchCount++;
            };
        }
        return matchCount;
    }
}

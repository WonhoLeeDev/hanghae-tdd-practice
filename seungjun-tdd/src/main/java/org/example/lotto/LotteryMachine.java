package org.example.lotto;

public class LotteryMachine {
    private WinningNumber winningNumber;
    private Number bonusNumber;

    public void saveWinningNumber(WinningNumber winningNumber, int bonusNumber) {
       this.winningNumber = winningNumber;
       this.bonusNumber = new Number(bonusNumber);
    }

    public WinningNumber extractWinningNumber() {
        return winningNumber;
    }

    public int matchLottoNumber(Lotto lotto) {
        int matchNumber = 0;
        for (int i = 0; i < lotto.size(); i += 1) {
            if (winningNumber.getWinningNumber().contains(lotto.getLottoNumbers().get(i))) {
                matchNumber += 1;
            }
        }

        return matchNumber;
    }

    public boolean matchBonusNumber(Lotto lotto) {
        return lotto.getLottoNumbers().contains(bonusNumber);
    }
}

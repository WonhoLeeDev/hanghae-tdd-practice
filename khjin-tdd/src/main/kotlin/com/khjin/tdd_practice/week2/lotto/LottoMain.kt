package com.khjin.tdd_practice.week2.lotto

val lottoUI = LottoUI()
val lotto = Lotto()

fun main() {
    val money = lottoUI.moneyInput()
    val games = lotto.purchaseGames(LottoConstants.GAME_PRICE, money)

    lottoUI.printGames(games)

    val winningNumberInput = lottoUI.winningNumberInput()

    val winningNumbers = lotto.parseWinnerInput(winningNumberInput)
    val gameResult = lotto.runGames(winningNumbers, games)

    lottoUI.printGameResult(gameResult)

    val profitRate = lotto.calculateProfitRate(
        purchase = games.size * LottoConstants.GAME_PRICE,
        prize = lotto.calculatePrizeMoney(gameResult)
    )

    lottoUI.printProfitRate(profitRate)

}
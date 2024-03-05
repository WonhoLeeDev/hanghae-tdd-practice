package com.khjin.tdd_practice.week2.lotto

import com.khjin.tdd_practice.week2.WinningNumber

class Lotto {

    private val lottoUI = LottoUI()
    private val lottoResultHandler = LottoResultHandler()
    private val gameGenerator = GameGenerator()
    private val winningNumber = WinningNumber()
    private val gameNumberMatcher = GameNumberMatcher()

    fun run() {

        // 1. receive money input
        val money = lottoUI.moneyInput()

        // 2. purchase games
        val games = gameGenerator.purchaseGames(LottoConstants.GAME_PRICE, money)

        // 3. print games
        lottoUI.printGames(games)

        // 4. receive winning number input
        val winningNumberInput = lottoUI.winningNumberInput()

        // 5. parse input
        val winningNumbers = winningNumber.parseWinnerInput(winningNumberInput)

        // 6. match all game numbers against winning number
        val gameResult = gameNumberMatcher.matchAllGames(winningNumbers, games)

        // 7. print game result
        lottoUI.printGameResult(gameResult)

        // 8. calculate and print profit rate
        val profitRate = lottoResultHandler.calculateProfitRate(
            purchase = games.size * LottoConstants.GAME_PRICE,
            prize = lottoResultHandler.calculatePrizeMoney(gameResult)
        )
        lottoUI.printProfitRate(profitRate)


    }

}
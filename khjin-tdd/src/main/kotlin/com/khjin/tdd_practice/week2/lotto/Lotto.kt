package com.khjin.tdd_practice.week2.lotto

import com.khjin.tdd_practice.week2.WinningNumber
import com.khjin.tdd_practice.week2.lotto.constants.LottoConstants

class Lotto {

    private val lottoUI = LottoUI()
    private val lottoResult = LottoResult()
    private val gameGenerator = GameGenerator()
    private val winningNumber = WinningNumber()
    private val lottoValidator = LottoValidator()

    fun run() {

        // 1. receive money input
        val money = lottoUI.moneyInput()

        // 2. purchase games
        val games = gameGenerator.purchaseGames(LottoConstants.GAME_PRICE, money)

        // 3. print games
        lottoUI.printGames(games)

        // 4. receive winning number and bonus number
        val winningNumberInput = lottoUI.winningNumberInput()
        val bonusNumber = lottoUI.bonusNumberInput()

        // 5. parse and validate input
        val winningNumbers = winningNumber.parseWinnerInput(winningNumberInput)
        lottoValidator.validateGameNumber(bonusNumber)

        // 6. get result
        val gameResult = lottoResult.getResult(winningNumbers, bonusNumber, games)

        // 7. print game result
        lottoUI.printGameResult(gameResult)

        // 8. calculate and print profit rate
        val totalPrizeMoney = lottoResult.calculateTotalPrizeMoney(gameResult)
        val profitRate = lottoResult.calculateProfitRate(
            purchase = games.size * LottoConstants.GAME_PRICE,
            prizeMoney = totalPrizeMoney
        )
        lottoUI.printProfitRate(profitRate)


    }

}
package com.khjin.tdd_practice.week2.lotto

import com.khjin.tdd_practice.week2.lotto.exception.InsufficientMoneyException
import kotlin.math.floor

/**
 * 구매
 * 게임 만들기
 * 당첨번호 validation
 * 당첨 확인
 * 상금 계산
 * 수익률 계산
 */

class Lotto {

    private val lottoValidator: LottoValidator = LottoValidator()

    fun purchaseGames(price: Int, money: Int): List<List<Int>> {
        val result = mutableListOf<List<Int>>()

        if(price > money)
            throw InsufficientMoneyException("돈이 충분하지 않습니다")

        for(i in 0..<money/price){
            result.add(this.createGame())
        }
        return result
    }

    fun createGame(): List<Int> {
        val candidates = IntArray(LottoConstants.GAME_NUMBER_MAX - LottoConstants.GAME_NUMBER_MIN) {
            it + LottoConstants.GAME_NUMBER_MIN
        }
        candidates.shuffle()
        return candidates
            .slice(0..<LottoConstants.GAME_SIZE)
            .sorted()
    }

    fun parseWinnerInput(winnerInput: String): List<Int> {
        val numList = winnerInput.split(LottoConstants.INPUT_DELIMITER)

        lottoValidator.validateWinningNumberInput(numList)

        return numList.map{ it.trim().toInt() }
    }

    fun matchNumbers(winningNumbers: List<Int>, game: List<Int>): Int{
        var result = 0
        for(num in game)
            if (winningNumbers.contains(num))
                result++

        return result
    }

    fun runGames(winningNumbers: List<Int>, gameSet: List<List<Int>>): IntArray {
        val result = IntArray(LottoConstants.GAME_SIZE+1)

        for (game in gameSet){
            result[matchNumbers(winningNumbers, game)]++
        }

        return result
    }

    fun calculatePrizeMoney(gameResult: IntArray): Int {
        var result = 0
        for(unmatched in (0..<4)){
            val wonGames = gameResult[LottoConstants.GAME_SIZE - unmatched]
            result += when(unmatched){
                0 -> wonGames * LottoConstants.FIRST_PRIZE_MONEY
                1 -> wonGames * LottoConstants.SECOND_PRIZE_MONEY
                2 -> wonGames * LottoConstants.THIRD_PRIZE_MONEY
                else -> wonGames * LottoConstants.FOURTH_PRIZE_MONEY
            }
        }
        return result
    }

    fun calculateProfitRate(purchase: Int, prize: Int): Double {
        return floor((prize-purchase).toDouble() / purchase.toDouble()*100) / 100
    }
}
package com.khjin.tdd_practice.week2.lotto

import com.khjin.tdd_practice.week2.lotto.exception.InsufficientMoneyException
import com.khjin.tdd_practice.week2.lotto.exception.InvalidWinnerInputException
import java.lang.NumberFormatException
import kotlin.math.floor
import kotlin.math.round

class Lotto {
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
        try {
            val result = winnerInput.split(LottoConstants.INPUT_DELIMITER).map{ it.trim().toInt() }

            if(result.size != LottoConstants.GAME_SIZE)
                throw InvalidWinnerInputException("당첨 번호는 총 ${LottoConstants.GAME_SIZE}개의 숫자로 이뤄져야 합니다")

            for(num in result){
                if(num !in LottoConstants.GAME_NUMBER_MIN..LottoConstants.GAME_NUMBER_MAX){
                    throw InvalidWinnerInputException(
                        "숫자는 ${LottoConstants.GAME_NUMBER_MIN}과 ${LottoConstants.GAME_NUMBER_MAX} 사이여야 합니다")
                }
            }

            return result
        }catch(nfe: NumberFormatException) {
            throw InvalidWinnerInputException("유효하지 않은 당첨 번호입니다.\n당첨 번호는 쉼표로 구분된 숫자로만 입력해야 합니다.")        }
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
            when(unmatched){
                0 -> result += wonGames * LottoConstants.FIRST_PRIZE_MONEY
                1 -> result += wonGames * LottoConstants.SECOND_PRIZE_MONEY
                2 -> result += wonGames * LottoConstants.THIRD_PRIZE_MONEY
                else -> result += wonGames * LottoConstants.FOURTH_PRIZE_MONEY
            }
        }
        return result
    }

    fun calculateProfitRate(purchase: Int, prize: Int): Double {
        return floor((prize-purchase).toDouble() / purchase.toDouble()*100) / 100
    }
}
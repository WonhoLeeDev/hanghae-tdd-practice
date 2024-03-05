package com.khjin.tdd_practice.week2.lotto

import kotlin.math.floor

class LottoResultHandler {

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
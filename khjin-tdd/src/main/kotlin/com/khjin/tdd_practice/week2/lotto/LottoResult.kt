package com.khjin.tdd_practice.week2.lotto

import com.khjin.tdd_practice.week2.lotto.enums.Rank
import kotlin.math.floor

class LottoResult {

    private val gameNumberMatcher = GameNumberMatcher()

    fun getResult(winningNumbers:List<Int>, bonusNumber: Int, gameList:List<List<Int>>) : Map<Rank, Int>{
        val result = HashMap<Rank, Int>()
        for(rank in Rank.entries){
            result[rank] = 0
        }

        for(game in gameList){
            val matches = gameNumberMatcher.matchOneGame(winningNumbers, game)
            val isBonusNumberMatch = gameNumberMatcher.matchBonusNumber(bonusNumber, game)
            val gameRank = Rank.getRank(matches, isBonusNumberMatch)

            result[gameRank] = result[gameRank]!!.plus(1)
        }
        return result
    }

    fun calculateTotalPrizeMoney(gameResult: Map<Rank, Int>): Int {
        var totalPrizeMoney = 0

        for(rank in gameResult.keys){
            totalPrizeMoney += (gameResult[rank]?:0) * rank.getPrizeMoney()
        }

        return totalPrizeMoney
    }

    fun calculateProfitRate(purchase: Int, prizeMoney: Int): Double {
        return floor((prizeMoney-purchase).toDouble() / purchase.toDouble()*100) / 100
    }
}
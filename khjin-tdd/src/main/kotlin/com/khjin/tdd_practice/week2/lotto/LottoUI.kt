package com.khjin.tdd_practice.week2.lotto

import com.khjin.tdd_practice.week2.lotto.constants.LottoConstants

class LottoUI {
    fun moneyInput(): Int {
        println("구매금액을 입력해 주세요")
        return readln().toInt()
    }

    fun printGames(games : List<List<Int>>){
        println("${games.size} 개를 구매했습니다")
        for(game in games){
            println(game)
        }
    }

    fun winningNumberInput(): String {
        println("지난주 당첨번호를 입력하세요")
        return readln()
    }

    fun printGameResult(gameResult: IntArray) {
        for(unmatched in (0..<4).reversed()){
            val matches = LottoConstants.GAME_SIZE - unmatched
            val wonGames = gameResult[matches]
            val prizeMoney = when(unmatched){
                0 -> LottoConstants.FIRST_PRIZE_MONEY
                1 -> LottoConstants.SECOND_PRIZE_MONEY
                2 -> LottoConstants.THIRD_PRIZE_MONEY
                else -> LottoConstants.FOURTH_PRIZE_MONEY
            }
            println("${matches}개 일치 (${prizeMoney}원) - $wonGames 개")
        }
    }

    fun printProfitRate(profitRate: Double) {
        println("총 수익률은 ${(profitRate * 100).toInt()}% 입니다.")
    }

    fun bonusNumberInput(): Int {
        println("보너스 볼을 입력해주세요")
        return readln().toInt()
    }

}
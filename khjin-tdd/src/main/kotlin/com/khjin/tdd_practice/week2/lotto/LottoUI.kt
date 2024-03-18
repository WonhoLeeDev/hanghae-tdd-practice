package com.khjin.tdd_practice.week2.lotto

import com.khjin.tdd_practice.week2.lotto.enums.Rank

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

    fun printGameResult(gameResult: Map<Rank, Int>) {
        val messageBuilder = StringBuilder()
        for(rank in Rank.entries.reversed()){
            if(rank == Rank.MISS) continue

            messageBuilder.append("${rank.getMatches()} 개 일치")
            if(rank == Rank.SECOND){
                messageBuilder.append(", 보너스 볼 일치")
            }
            messageBuilder.append("(${rank.getPrizeMoney()}원) - ${gameResult[rank]}개\n")

        }
        println(messageBuilder.toString())
    }

    fun printProfitRate(profitRate: Double) {
        println("총 수익률은 ${(profitRate * 100).toInt()}% 입니다.")
    }

    fun bonusNumberInput(): Int {
        println("보너스 볼을 입력해주세요")
        return readln().toInt()
    }

}
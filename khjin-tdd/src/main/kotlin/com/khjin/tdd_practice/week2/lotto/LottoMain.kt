package com.khjin.tdd_practice.week2.lotto

fun main() {
    println("구매금액을 입력해 주세요")
    val money = readln().toInt()

    val lotto = Lotto()
    val games = lotto.purchaseGames(LottoConstants.GAME_PRICE, money)
    println("${games.size} 개를 구매했습니다")
    for(game in games){
        println(game)
    }
    println("지난주 당첨번호를 입력하세요")
    val winningNumbers = lotto.parseWinnerInput(readln())
    val gameResult = lotto.runGames(winningNumbers, games)

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

    val profitRate = lotto.calculateProfitRate(
        purchase = games.size * LottoConstants.GAME_PRICE,
        prize = lotto.calculatePrizeMoney(gameResult)
    )

    println("총 수익률은 ${(profitRate * 100).toInt()}% 입니다.")

}
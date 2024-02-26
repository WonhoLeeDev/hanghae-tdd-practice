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
    println(lotto.parseWinnerInput(readln()))
}
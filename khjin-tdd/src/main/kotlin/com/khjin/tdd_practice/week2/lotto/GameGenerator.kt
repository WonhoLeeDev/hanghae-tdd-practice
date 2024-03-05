package com.khjin.tdd_practice.week2.lotto

import com.khjin.tdd_practice.week2.lotto.exception.InsufficientMoneyException

class GameGenerator {

    private val gameNumberCandidates = IntArray(LottoConstants.GAME_NUMBER_MAX - LottoConstants.GAME_NUMBER_MIN){
        it + LottoConstants.GAME_NUMBER_MIN
    }

    fun purchaseGames(price: Int, money: Int): List<List<Int>> {
        val games = mutableListOf<List<Int>>()

        if(price > money)
            throw InsufficientMoneyException("돈이 충분하지 않습니다")

        for(i in 0..<money/price){
            games.add(this.createOneGame())
        }
        return games
    }

    fun createOneGame(): List<Int> {
        gameNumberCandidates.shuffle()
        return gameNumberCandidates
            .slice(0..<LottoConstants.GAME_SIZE)
            .sorted()
    }

}
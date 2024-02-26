package com.khjin.tdd_practice.week2.lotto

import com.khjin.tdd_practice.week2.lotto.exception.InsufficientMoneyException

class Lotto {
    fun purchaseGames(price: Int, money: Int): List<List<Int>> {
        val result = mutableListOf<List<Int>>()

        if(price > money)
            throw InsufficientMoneyException("돈이 충분하지 않습니다")

        for(i in 0..<money/price){
            result.add(this.runGame())
        }
        return result
    }

    fun runGame(): List<Int> {
        val candidates = IntArray(45) {it + 1}
        candidates.shuffle()
        return candidates.slice(0..5)
    }
}
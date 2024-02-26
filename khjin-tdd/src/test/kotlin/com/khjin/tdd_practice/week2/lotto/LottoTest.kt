package com.khjin.tdd_practice.week2.lotto

import com.khjin.tdd_practice.week2.lotto.exception.InsufficientMoneyException
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class LottoTest {

    @Test
    fun `when money is given, the number of games should be the quotient of money and lotto price`() {
        val lotto = Lotto()
        assertEquals(10, lotto.purchaseGames(price = 1000, money = 10100).size)
        assertEquals(5, lotto.purchaseGames(price = 2000, money = 10999).size)
    }

    @Test
    fun `when given money is less than game price, InsufficientMoneyException should be thrown`() {
        val lotto = Lotto()
        assertThrows(InsufficientMoneyException::class.java){
            lotto.purchaseGames(price = 5000, money = 4999)
        }
    }

    @Test
    fun `a game should be a list of six random numbers`() {
        val lotto = Lotto()
        assertEquals(LottoConstants.GAME_SIZE, lotto.createGame().size)
    }

    @Test
    fun `the numbers in a game should be between 1 and 45`() {
        val lotto = Lotto()
        //run 100 games
        for(i in 0..<100){
            val game = lotto.createGame()
            for (num in game){
                assertTrue(num in LottoConstants.GAME_NUMBER_MIN..LottoConstants.GAME_NUMBER_MAX)
            }
        }
    }

    @Test
    fun `there should be no duplicate numbers in a game`() {
        val lotto = Lotto()
        //run 100 games
        for(i in 0..<100){
            val game = lotto.createGame()
            for(j in 0..<game.size-1){
                val set = game.toHashSet()
                assertTrue(set.size == game.size)
            }
        }
    }
}
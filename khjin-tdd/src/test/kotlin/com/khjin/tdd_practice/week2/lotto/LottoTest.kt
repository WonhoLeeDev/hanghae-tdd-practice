package com.khjin.tdd_practice.week2.lotto

import com.khjin.tdd_practice.week2.lotto.exception.InsufficientMoneyException
import com.khjin.tdd_practice.week2.lotto.exception.InvalidWinnerInputException
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
        //create 100 games
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
        //create 100 games
        for(i in 0..<100){
            val game = lotto.createGame()
            val set = game.toHashSet()
            assertTrue(set.size == game.size)
        }
    }

    @Test
    fun `the numbers in a game should be in increasing order`() {
        val lotto = Lotto()
        //create 100 games
        for(i in 0..<100){
            val game = lotto.createGame()
            for(j in 0..<game.size-1){
                assertTrue(game[j] < game[j+1])
            }
        }
    }

    @Test
    fun `the winner input should be a string of numbers delimited with commas`() {
        val lotto = Lotto()
        assertEquals(listOf(1,2,3,4,5,6), lotto.parseWinnerInput("1, 2, 3, 4, 5, 6"))
        assertThrows(InvalidWinnerInputException::class.java){
            lotto.parseWinnerInput("1,rr,2,5,1f")
        }
        assertThrows(InvalidWinnerInputException::class.java){
            lotto.parseWinnerInput("1|2|3|4|5|6")
        }
    }

    @Test
    fun `the winning numbers should be between 1 and 45`() {
        val lotto = Lotto()
        assertThrows(InvalidWinnerInputException::class.java){
            lotto.parseWinnerInput("1,56,2,5,24,45")
        }
        assertThrows(InvalidWinnerInputException::class.java){
            lotto.parseWinnerInput("0,40,2,11,24,45")
        }
    }

    @Test
    fun `the size of the winning numbers list should be exactly 6`() {
        val lotto = Lotto()
        assertThrows(InvalidWinnerInputException::class.java){
           lotto.parseWinnerInput("1,2,3,4,5,6,7")
        }
        assertThrows(InvalidWinnerInputException::class.java){
            lotto.parseWinnerInput("1,2,3,4")
        }
    }

    @Test
    fun `the number of numbers matching the winning numbers should be returned when a game is run`() {
        val lotto = Lotto()
        val winningNumbers = listOf(1, 2, 3, 4, 5, 6)
        assertEquals(3, lotto.matchNumbers(winningNumbers, listOf(1, 2, 3, 10, 20, 30)))
        assertEquals(4, lotto.matchNumbers(winningNumbers, listOf(3, 4, 4, 6, 10, 20)))
    }

    @Test
    fun `the number of matches for the set of games should be returned`() {
        val lotto = Lotto()
        val winningNumbers = listOf(1,2,3,4,5,6)
        val gameSet = listOf(
            listOf(1, 2, 3, 4, 5, 6),
            listOf(1, 2, 3, 4, 5, 38),
            listOf(2, 3, 4, 5, 6, 44),
            listOf(1, 2, 3, 4, 41, 42),
            listOf(1, 3, 4, 5, 42, 45),
            listOf(3, 4, 5, 6, 42, 43),
            listOf(1, 2, 3, 32, 38, 45),
            listOf(1, 2, 3, 36, 39, 41),
            listOf(1, 3, 5, 14, 22, 45),
            listOf(1, 6, 38, 41, 43, 44),
            listOf(2, 8, 9, 18, 19, 21),
            listOf(13, 14, 18, 21, 23, 35),
            listOf(17, 21, 29, 37, 42, 45),
            listOf(7, 8, 27, 30, 35, 44),
        )
        val gamesResult = lotto.runGames(winningNumbers, gameSet)
        assertEquals(1, gamesResult[6])
        assertEquals(2, gamesResult[5])
        assertEquals(3, gamesResult[4])
        assertEquals(3, gamesResult[3])
        assertEquals(1, gamesResult[2])
        assertEquals(1, gamesResult[1])
        assertEquals(3, gamesResult[0])
    }

    @Test
    fun `the final prize money for the given game result should be returned`() {
        val lotto = Lotto()
        assertEquals(2_000_050_000, lotto.calculatePrizeMoney(intArrayOf(0,10,4,0,1,0,1)))
        assertEquals(5000, lotto.calculatePrizeMoney(intArrayOf(1,2,4,1,0,0,0)))
    }

    @Test
    fun `profit rate for the games should be returned for given set of games`() {
        val lotto = Lotto()
        assertEquals(-0.65, lotto.calculateProfitRate(purchase = 14000, prize=5000))
    }
}
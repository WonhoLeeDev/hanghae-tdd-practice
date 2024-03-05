package com.khjin.tdd_practice.week2.lotto

import com.khjin.tdd_practice.week2.WinningNumber
import com.khjin.tdd_practice.week2.lotto.constants.LottoConstants
import com.khjin.tdd_practice.week2.lotto.exception.GameNumberOutOfRangeException
import com.khjin.tdd_practice.week2.lotto.exception.InsufficientMoneyException
import com.khjin.tdd_practice.week2.lotto.exception.InvalidWinnerInputException
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class LottoTest {

    private val lottoResultHandler = LottoResultHandler()
    private val gameGenerator = GameGenerator()
    private val winningNumber = WinningNumber()
    private val gameNumberMatcher = GameNumberMatcher()

    @Test
    fun `when money is given, the number of games should be the quotient of money and lotto price`() {
        assertEquals(10, gameGenerator.purchaseGames(price = 1000, money = 10100).size)
        assertEquals(5, gameGenerator.purchaseGames(price = 2000, money = 10999).size)
    }

    @Test
    fun `when given money is less than game price, InsufficientMoneyException should be thrown`() {
        assertThrows(InsufficientMoneyException::class.java){
            gameGenerator.purchaseGames(price = 5000, money = 4999)
        }
    }

    @Test
    fun `a game should be a list of six random numbers`() {
        assertEquals(LottoConstants.GAME_SIZE, gameGenerator.createOneGame().size)
    }

    @Test
    fun `the numbers in a game should be between 1 and 45`() {
        //create 100 games
        for(i in 0..<100){
            val game = gameGenerator.createOneGame()
            for (num in game){
                assertTrue(num in LottoConstants.GAME_NUMBER_MIN..LottoConstants.GAME_NUMBER_MAX)
            }
        }
    }

    @Test
    fun `there should be no duplicate numbers in a game`() {
        //create 100 games
        for(i in 0..<100){
            val game = gameGenerator.createOneGame()
            val set = game.toHashSet()
            assertTrue(set.size == game.size)
        }
    }

    @Test
    fun `the numbers in a game should be in increasing order`() {
        //create 100 games
        for(i in 0..<100){
            val game = gameGenerator.createOneGame()
            for(j in 0..<game.size-1){
                assertTrue(game[j] < game[j+1])
            }
        }
    }

    @Test
    fun `the winner input should be a string of numbers delimited with commas`() {
        assertEquals(listOf(1,2,3,4,5,6), winningNumber.parseWinnerInput("1, 2, 3, 4, 5, 6"))
        assertThrows(InvalidWinnerInputException::class.java){
            winningNumber.parseWinnerInput("1,rr,2,5,1f")
        }
        assertThrows(InvalidWinnerInputException::class.java){
            winningNumber.parseWinnerInput("1|2|3|4|5|6")
        }
    }

    @Test
    fun `the winning numbers should be between 1 and 45`() {
        assertThrows(GameNumberOutOfRangeException::class.java){
            winningNumber.parseWinnerInput("1,56,2,5,24,45")
        }
        assertThrows(GameNumberOutOfRangeException::class.java){
            winningNumber.parseWinnerInput("0,40,2,11,24,45")
        }
    }

    @Test
    fun `the size of the winning numbers list should be exactly 6`() {
        assertThrows(InvalidWinnerInputException::class.java){
            winningNumber.parseWinnerInput("1,2,3,4,5,6,7")
        }
        assertThrows(InvalidWinnerInputException::class.java){
            winningNumber.parseWinnerInput("1,2,3,4")
        }
    }

    @Test
    fun `the number of numbers matching the winning numbers should be returned when a game is run`() {
        val winningNumbers = listOf(1, 2, 3, 4, 5, 6)
        assertEquals(3, gameNumberMatcher.matchOneGame(winningNumbers, listOf(1, 2, 3, 10, 20, 30)))
        assertEquals(4, gameNumberMatcher.matchOneGame(winningNumbers, listOf(3, 4, 4, 6, 10, 20)))
    }

    @Test
    fun `the number of matches for the set of games should be returned`() {
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
        val gamesResult = gameNumberMatcher.matchAllGames(winningNumbers, gameSet)
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
        assertEquals(2_000_050_000, lottoResultHandler.calculatePrizeMoney(intArrayOf(0,10,4,0,1,0,1)))
        assertEquals(5000, lottoResultHandler.calculatePrizeMoney(intArrayOf(1,2,4,1,0,0,0)))
    }

    @Test
    fun `profit rate for the games should be returned for given set of games`() {
        assertEquals(-0.65, lottoResultHandler.calculateProfitRate(purchase = 14000, prize=5000))
    }
}
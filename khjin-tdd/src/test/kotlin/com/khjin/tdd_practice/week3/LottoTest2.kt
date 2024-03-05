package com.khjin.tdd_practice.week3

import com.khjin.tdd_practice.week2.lotto.GameNumberMatcher
import com.khjin.tdd_practice.week2.lotto.LottoResult
import com.khjin.tdd_practice.week2.lotto.LottoValidator
import com.khjin.tdd_practice.week2.lotto.enums.Rank
import com.khjin.tdd_practice.week2.lotto.exception.GameNumberOutOfRangeException
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class LottoTest2 {

    private val gameNumberMatcher = GameNumberMatcher()
    private val lottoValidator = LottoValidator()
    private val lottoResult = LottoResult()

    @Test
    fun `bonus number should be between minimum and maximum game number`() {
        assertThrows(GameNumberOutOfRangeException::class.java) {
            lottoValidator.validateGameNumber(46)
        }
        assertThrows(GameNumberOutOfRangeException::class.java) {
            lottoValidator.validateGameNumber(0)
        }

    }

    @Test
    fun `when bonus number matches, should return true`() {
        val game = listOf(1,2,3,4,5,11)
        assertTrue(gameNumberMatcher.matchBonusNumber(
            bonusNumber = 5,
            game = game
        ))
        assertFalse(gameNumberMatcher.matchBonusNumber(
            bonusNumber = 23,
            game = game
        ))
    }

    @Test
    fun `when 5 numbers match and bonus number match, game result should be 2nd place`() {
        val game = listOf(1,2,3,4,5,11)
        val winningNumber = listOf(1,2,3,4,5,6)
        val bonusNumber = 11

        val matches = gameNumberMatcher.matchOneGame(winningNumber, game)
        val isBonusNumberMatch = gameNumberMatcher.matchBonusNumber(bonusNumber, game)

        assertEquals(5, matches)
        assertTrue(isBonusNumberMatch)
        assertEquals(Rank.SECOND, Rank.getRank(matches, isBonusNumberMatch))
    }

    @Test
    fun `when 5 numbers match and bonus number does not match, game result should be THIRD`() {
        val game = listOf(1,2,3,4,5,11)
        val winningNumber = listOf(1,2,3,4,5,6)
        val bonusNumber = 42

        val matches = gameNumberMatcher.matchOneGame(winningNumber, game)
        val isBonusNumberMatch = gameNumberMatcher.matchBonusNumber(bonusNumber, game)

        assertEquals(5, matches)
        assertFalse(isBonusNumberMatch)
        assertEquals(Rank.THIRD, Rank.getRank(matches, isBonusNumberMatch))
    }


    @Test
    fun `a hashmap of rank and the number of games that matches the rank should be returned given a set of games`() {
        val winningNumber = listOf(1,2,3,4,5,6)
        val bonusNumber = 42
        val gameList = listOf(
            listOf(1, 2, 3, 4, 5, 6),   //FIRST
            listOf(1, 2, 3, 4, 5, 42),  //SECOND
            listOf(2, 3, 4, 5, 6, 42),  //SECOND
            listOf(2, 3, 4, 5, 6, 21),  //THIRD
            listOf(1, 2, 4, 5, 6, 43),  //THIRD
            listOf(1, 2, 3, 4, 41, 42), //FOURTH
            listOf(1, 3, 4, 5, 42, 45), //FOURTH
            listOf(3, 4, 5, 6, 42, 43), //FOURTH
            listOf(1, 2, 3, 32, 38, 45), //FIFTH
            listOf(1, 2, 3, 36, 39, 41), //FIFTH
            listOf(1, 3, 5, 14, 22, 45), //FIFTH
            listOf(1, 6, 38, 41, 43, 44),//MISS
            listOf(2, 8, 9, 18, 19, 21), //MISS
            listOf(13, 14, 18, 21, 23, 35),//MISS
            listOf(17, 21, 29, 37, 42, 45),//MISS
            listOf(7, 8, 27, 30, 35, 44),//MISS
        )

        val result = lottoResult.getResult(winningNumber, bonusNumber, gameList)

        assertEquals(1, result[Rank.FIRST])
        assertEquals(2, result[Rank.SECOND])
        assertEquals(2, result[Rank.THIRD])
        assertEquals(3, result[Rank.FOURTH])
        assertEquals(3, result[Rank.FIFTH])
        assertEquals(5, result[Rank.MISS])

    }

    @Test
    fun `the final prize money for the given game result should be returned`() {
        val result1 = HashMap<Rank, Int>()
        result1[Rank.FIRST] = 1
        result1[Rank.SECOND] = 1
        result1[Rank.THIRD] = 1
        assertEquals(2_031_500_000, lottoResult.calculateTotalPrizeMoney(result1))

        val result2 = HashMap<Rank, Int>()
        result2[Rank.FOURTH] = 1
        result2[Rank.FIFTH] = 2
        assertEquals(60_000, lottoResult.calculateTotalPrizeMoney(result2))
    }

}
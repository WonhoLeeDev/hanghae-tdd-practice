package com.khjin.tdd_practice.week3

import com.khjin.tdd_practice.week2.lotto.GameNumberMatcher
import com.khjin.tdd_practice.week2.lotto.LottoValidator
import com.khjin.tdd_practice.week2.lotto.enums.Rank
import com.khjin.tdd_practice.week2.lotto.exception.GameNumberOutOfRangeException
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class LottoTest2 {

    private val gameNumberMatcher = GameNumberMatcher()
    private val lottoValidator = LottoValidator()

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

}
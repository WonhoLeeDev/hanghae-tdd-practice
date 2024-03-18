package com.khjin.tdd_practice.week1.calculator

import com.khjin.tdd_practice.week1.calculator.exception.InvalidExpressionException
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith
import kotlin.test.assertNotEquals

class CalculatorTest {

    @Test
    fun shouldReturnZero_whenExpressionIsEmpty() {
        val calculator = Calculator()
        assertEquals(0, calculator.add(""))
        assertNotEquals(123, calculator.add(""))
    }

    @Test
    fun shouldReturnNumber_whenExpressionHasOnlyOneNumber() {
        val calculator = Calculator()
        assertEquals(1, calculator.add("1"))
        assertEquals(999, calculator.add("999"))
        assertNotEquals(0, calculator.add("1"))
    }

    @Test
    fun shouldReturnSum_whenExpressionHasTwoNumbersSeparatedByComma() {
        val calculator = Calculator()
        assertEquals(3, calculator.add("1,2"))
        assertEquals(30, calculator.add("12,18"))
        assertNotEquals(0, calculator.add("1,2"))
    }

    @Test
    fun shouldReturnSum_whenExpressionHasMoreThanTwoNumbersSeparatedByComma() {
        val calculator = Calculator()
        assertEquals(10, calculator.add("1,2,3,4"))
        assertEquals(195, calculator.add("19,29,39,49,59"))
        assertNotEquals(10,calculator.add("123,454,123,55"))
    }

    @Test
    fun shouldReturnSum_whenDelimiterIsCommaOrNewline() {
        val calculator = Calculator()
        assertEquals(15, calculator.add("1,2\n3,4\n5"))
        assertEquals(150, calculator.add("10\n20\n30\n40\n50"))
        assertNotEquals(10,calculator.add("12\n45,23\n55"))
    }

    @Test
    fun shouldThrowInvalidExpressionException_whenExpressionEndsWithDelimiter() {
        val calculator = Calculator()
        assertThrows<InvalidExpressionException>{
            calculator.add("1,2,4,")
        }
        assertThrows<InvalidExpressionException>{
            calculator.add("4\n5,6\n")
        }
    }

    @Test
    fun shouldReturnChangedDelimiter_whenExpressionStartsWithNewDelimiter () {
        val calculator = Calculator()
        assertEquals("|", calculator.extractDelimiter("//|\n1|2|3"))
        assertEquals("delimiter", calculator.extractDelimiter("//delimiter\n10delimiter20"))
    }

    @Test
    fun shouldReturnSum_whenDelimiterIsChanged() {
        val calculator = Calculator()
        assertEquals(6, calculator.add("//|\n1|2|3"))
        assertEquals(30, calculator.add("//delimiter\n10delimiter20"))
        assertNotEquals(10, calculator.add("//;\n4;5;6"))
    }

    @Test
    fun shouldThrowInvalidExpressionException_whenUnknownDelimiterIsUsed() {
        val calculator = Calculator()
        assertFailsWith<InvalidExpressionException>(
            message = "'|' expected but ',' found at position 3"
            , block = {
                calculator.add("//|\n1|2,3")
            }
        )
        assertFailsWith<InvalidExpressionException>(
            message = "'sep' expected but 'aaa' found at position 12"
            , block = {
                calculator.add("//sep\n10sep20sep30aaa40sep50")
            }
        )
    }

    @Test
    fun shouldThrowInvalidExpression_whenNumberIsNegative() {
        val calculator = Calculator()

        assertFailsWith<InvalidExpressionException>(
            message = "Negative number(s) not allowed: -2"
            , block = {
                calculator.add("1,-2")
            }
        )
        assertFailsWith<InvalidExpressionException>(
            message = "Negative number(s) not allowed: -4,-9"
            , block = {
                calculator.add("2,-4,-9")
            }
        )
        assertFailsWith<InvalidExpressionException>(
            message = "Negative number(s) not allowed: -4,-9"
            , block = {
                calculator.add("//sep\n2sep-4sep-9")
            }
        )
    }

    @Test
    fun shouldShowAllErrorMessages_whenTwoOrMoreErrorsOccur() {
        val calculator = Calculator()

        assertFailsWith<InvalidExpressionException>(
            message = "Negative number(s) not allowed: -3\n'|' expected but ',' found at position 3"
            , block = {
                calculator.add("//sep\n2sep-4sep-9")
            }
        )
    }

    @Test
    fun shouldNotAdd_whenNumberIsLargerThan1000() {
        val calculator = Calculator()
        assertEquals(6, calculator.add("//|\n1|1234|5678|2|3"))

    }
}
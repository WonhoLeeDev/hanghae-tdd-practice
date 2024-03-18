package com.khjin.tdd_practice.week1.fizzbuzz

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class FizzBuzzTest {

    @Test
    fun shouldReturnFizz_whenInputIsMultipleOfThree() {
        val fizzBuzz = FizzBuzz()

        assertEquals("Fizz", fizzBuzz.fizzBuzz(3))
    }

    @Test
    fun `shouldReturBuzz_whenInputIsMultipleOfFive()`() {
        val fizzBuzz = FizzBuzz()

        assertEquals("Buzz", fizzBuzz.fizzBuzz(10))
        assertEquals("Buzz", fizzBuzz.fizzBuzz(20))
        assertEquals("Buzz", fizzBuzz.fizzBuzz(25))
        assertEquals("Buzz", fizzBuzz.fizzBuzz(35))
    }

    @Test
    fun shouldReturnFizzBuzz_whenInputIsMultipleOfThreeAndFive() {
        val fizzBuzz = FizzBuzz()

        assertEquals("FizzBuzz", fizzBuzz.fizzBuzz(15))
        assertEquals("FizzBuzz", fizzBuzz.fizzBuzz(30))
        assertEquals("FizzBuzz", fizzBuzz.fizzBuzz(45))
    }

    @Test
    fun shouldReturnNumberInString_whenNumberIsNotMulitpleOfThreeOrFive() {
        val fizzBuzz = FizzBuzz()

        assertEquals("17", fizzBuzz.fizzBuzz(17))
        assertEquals("23", fizzBuzz.fizzBuzz(23))
        assertEquals("44", fizzBuzz.fizzBuzz(44))
    }
}
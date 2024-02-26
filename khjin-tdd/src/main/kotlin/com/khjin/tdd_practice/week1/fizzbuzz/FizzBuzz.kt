package com.khjin.tdd_practice.week1.fizzbuzz

class FizzBuzz {

    fun fizzBuzz(input: Int): String {
        var result = input.toString()
        if( input % 3 == 0 && input % 5 == 0){
            result = "FizzBuzz"
        }
        else if( input % 3 == 0 ){
            result = "Fizz"
        }
        else if( input % 5 == 0){
            result = "Buzz"
        }
        return result

    }

    /**
    fun fizzBuzz_v1(input: Int) : String {
        return if (input % 3 == 0) "Fizz" else "??"
    }

    fun fizzBuzz_v2(input: Int) : String {
        var result = ""
        if( input % 3 == 0 ){
            result = "Fizz"
        }
        else if( input % 5 == 0 ){
            result = "Buzz"
        }
        return result
    }

    fun fizzBuzz_v3(input: Int): String {
        var result = ""
        if( input % 3 == 0 && input % 15 == 0){
            result = "FizzBuzz"
        }
        else if( input % 3 == 0 ){
            result = "Fizz"
        }
        else if( input % 5 == 0){
            result = "Buzz"
        }
        return result
    }
    */

}

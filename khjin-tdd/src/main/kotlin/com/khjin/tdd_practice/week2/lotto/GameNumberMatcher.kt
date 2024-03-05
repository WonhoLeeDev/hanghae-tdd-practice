package com.khjin.tdd_practice.week2.lotto

class GameNumberMatcher {
    fun matchOneGame(winningNumbers: List<Int>, game: List<Int>): Int{
        var result = 0
        for(num in game)
            if (winningNumbers.contains(num))
                result++

        return result
    }

    fun matchAllGames(winningNumbers: List<Int>, gameSet: List<List<Int>>): IntArray {
        val result = IntArray(LottoConstants.GAME_SIZE+1)

        for (game in gameSet){
            result[matchOneGame(winningNumbers, game)]++
        }

        return result
    }

}
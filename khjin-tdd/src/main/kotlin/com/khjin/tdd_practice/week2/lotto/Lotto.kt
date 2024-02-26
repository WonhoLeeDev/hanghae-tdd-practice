package com.khjin.tdd_practice.week2.lotto

import com.khjin.tdd_practice.week2.lotto.exception.InsufficientMoneyException
import com.khjin.tdd_practice.week2.lotto.exception.InvalidWinnerInputException
import java.lang.NumberFormatException

class Lotto {
    fun purchaseGames(price: Int, money: Int): List<List<Int>> {
        val result = mutableListOf<List<Int>>()

        if(price > money)
            throw InsufficientMoneyException("돈이 충분하지 않습니다")

        for(i in 0..<money/price){
            result.add(this.createGame())
        }
        return result
    }

    fun createGame(): List<Int> {
        val candidates = IntArray(LottoConstants.GAME_NUMBER_MAX - LottoConstants.GAME_NUMBER_MIN) {
            it + LottoConstants.GAME_NUMBER_MIN
        }
        candidates.shuffle()
        return candidates
            .slice(0..<LottoConstants.GAME_SIZE)
            .sorted()
    }

    fun parseWinnerInput(winnerInput: String): List<Int> {
        try {
            val result = winnerInput.split(LottoConstants.INPUT_DELIMITER).map{ it.trim().toInt() }

            if(result.size != LottoConstants.GAME_SIZE)
                throw InvalidWinnerInputException("당첨 번호는 총 ${LottoConstants.GAME_SIZE}개의 숫자로 이뤄져야 합니다")

            for(num in result){
                if(num !in LottoConstants.GAME_NUMBER_MIN..LottoConstants.GAME_NUMBER_MAX){
                    throw InvalidWinnerInputException(
                        "숫자는 ${LottoConstants.GAME_NUMBER_MIN}과 ${LottoConstants.GAME_NUMBER_MAX} 사이여야 합니다")
                }
            }

            return result
        }catch(nfe: NumberFormatException) {
            throw InvalidWinnerInputException("유효하지 않은 당첨 번호입니다.\n당첨 번호는 쉼표로 구분된 숫자로만 입력해야 합니다.")        }
    }
}
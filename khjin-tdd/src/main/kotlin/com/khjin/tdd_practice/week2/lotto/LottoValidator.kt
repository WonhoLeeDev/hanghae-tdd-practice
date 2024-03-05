package com.khjin.tdd_practice.week2.lotto

import com.khjin.tdd_practice.week2.lotto.constants.LottoConstants
import com.khjin.tdd_practice.week2.lotto.exception.GameNumberOutOfRangeException
import com.khjin.tdd_practice.week2.lotto.exception.InvalidWinnerInputException

class LottoValidator {

    fun validateWinningNumberInput(numList: List<String>): Boolean{

        if( numList.size != LottoConstants.GAME_SIZE) {
            throw InvalidWinnerInputException("당첨 번호는 총 ${LottoConstants.GAME_SIZE}개의 숫자로 이뤄져야 합니다")
        }

        for(str in numList){
            if( !isNumeric(str) ) {
                throw InvalidWinnerInputException("유효하지 않은 당첨 번호입니다.\n당첨 번호는 쉼표로 구분된 숫자로만 입력해야 합니다.")
            }else{
                validateGameNumber(str.toInt())
            }
        }

        return true
    }

    private fun isNumeric(str : String) : Boolean {
        return str.toIntOrNull() != null
    }

    fun validateGameNumber(num: Int): Boolean {
        if(num !in LottoConstants.GAME_NUMBER_MIN..LottoConstants.GAME_NUMBER_MAX){
            throw GameNumberOutOfRangeException(
                "숫자는 ${LottoConstants.GAME_NUMBER_MIN}과 ${LottoConstants.GAME_NUMBER_MAX} 사이여야 합니다"
            )
        }
        return true
    }


}
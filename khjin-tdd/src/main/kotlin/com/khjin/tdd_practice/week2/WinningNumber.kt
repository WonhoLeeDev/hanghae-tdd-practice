package com.khjin.tdd_practice.week2

import com.khjin.tdd_practice.week2.lotto.constants.LottoConstants
import com.khjin.tdd_practice.week2.lotto.LottoValidator

class WinningNumber {

    private val lottoValidator = LottoValidator()

    fun parseWinnerInput(winnerInput: String): List<Int> {
        val numList = winnerInput.split(LottoConstants.INPUT_DELIMITER).map{ it.trim() }

        lottoValidator.validateWinningNumberInput(numList)

        return numList.map{ it.toInt() }
    }

}
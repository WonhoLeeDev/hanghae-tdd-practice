package com.khjin.tdd_practice.week2.passwordvalidator

import com.khjin.tdd_practice.week2.passwordvalidator.exception.InvalidPasswordException

class PasswordValidator {

    fun validate(password: String): Boolean{
        val errorMessage = StringBuilder()

        if(password.length < 8){
            errorMessage.append("Password must be at least 8 characters")
        }

        var numCount = 0
        var capitalLetterFlag = false
        for (c in password.toCharArray()){
            if(c.isDigit()){
                numCount++
            }
            if( !capitalLetterFlag && c.isUpperCase()){
                capitalLetterFlag = true
            }
        }

        if( numCount < 2 ){
            if(errorMessage.isNotEmpty())   errorMessage.append("\n")
            errorMessage.append("The password must contain at least 2 numbers")
        }

        if( !capitalLetterFlag ){
            if(errorMessage.isNotEmpty())   errorMessage.append("\n")
            errorMessage.append("password must contain at least one capital letter")
        }

        if(errorMessage.isNotEmpty())
            throw InvalidPasswordException(errorMessage.toString())

        return true
    }

}

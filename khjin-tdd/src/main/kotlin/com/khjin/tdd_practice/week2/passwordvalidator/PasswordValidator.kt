package com.khjin.tdd_practice.week2.passwordvalidator

import com.khjin.tdd_practice.week2.passwordvalidator.exception.InvalidPasswordException

class PasswordValidator {

    fun validate(password: String): Boolean{
        if(password.length < 8){
            throw InvalidPasswordException("Password must be at least 8 characters")
        }

        var numCount = 0
        for (c in password.toCharArray()){
            if(c.isDigit()){
                numCount++
            }
        }

        if( numCount < 2 )
            throw InvalidPasswordException("The password must contain at least 2 numbers")

        return true
    }

}

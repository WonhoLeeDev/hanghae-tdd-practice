package com.khjin.tdd_practice.week2.passwordvalidator

import com.khjin.tdd_practice.week2.passwordvalidator.exception.InvalidPasswordException

class PasswordValidator {

    fun validate(password: String): Boolean{
        if(password.length < 8){
            throw InvalidPasswordException("Password must be at least 8 characters")
        }
        return true
    }

}

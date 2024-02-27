package com.khjin.tdd_practice.week2.passwordvalidator

import com.khjin.tdd_practice.week2.passwordvalidator.exception.InvalidPasswordException
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class PasswordValidatorTest {

    private val passwordValidator = PasswordValidator()
    private val validPassword = "Password1234"

    @Test
    fun `password must be at least 8 characters long`() {
        val targetMessage = "Password must be at least 8 characters"
        var testMessage = ""
        try{
            passwordValidator.validate("aaaaa")
        }catch(e:InvalidPasswordException){
            testMessage = e.localizedMessage
        }
        assertEquals(targetMessage, testMessage)

        assertTrue(passwordValidator.validate(validPassword))
    }


    @Test
    fun `password must contain at least 2 numbers`() {

        val targetMessage = "The password must contain at least 2 numbers"
        var testMessage = ""
        try{
            passwordValidator.validate("aaaaaaaaa1")
        }catch(e:InvalidPasswordException){
            testMessage = e.localizedMessage
        }
        assertEquals(targetMessage, testMessage)

        assertTrue(passwordValidator.validate(validPassword))
    }

    @Test
    fun `validation function should handle multiple validation errors`() {

        val targetMessage = "Password must be at least 8 characters\nThe password must contain at least 2 numbers"
        var testMessage = ""
        try{
            passwordValidator.validate("aaaaaa")
        }catch(e:InvalidPasswordException){
            testMessage = e.localizedMessage
        }
        assertEquals(targetMessage, testMessage)
        assertTrue(passwordValidator.validate(validPassword))
    }

    @Test
    fun `The password must contain at least one capital letter`() {
        val targetMessage = "password must contain at least one capital letter"
        var testMessage = ""
        try{
            passwordValidator.validate("aaaaaa1234")
        }catch(e:InvalidPasswordException){
            testMessage = e.localizedMessage
        }
        assertEquals(targetMessage, testMessage)

        val targetMessage2 = "The password must contain at least 2 numbers\npassword must contain at least one capital letter"
        try{
            passwordValidator.validate("aaaaaabbbb")
        }catch(e:InvalidPasswordException){
            testMessage = e.localizedMessage
        }
        assertEquals(targetMessage2, testMessage)

        assertTrue(passwordValidator.validate(validPassword))
    }
}
package com.khjin.tdd_practice.week2.passwordvalidator

import com.khjin.tdd_practice.week2.passwordvalidator.exception.InvalidPasswordException
import org.junit.jupiter.api.Test
import kotlin.test.assertFailsWith
import kotlin.test.assertTrue

class PasswordValidatorTest {

    private val passwordValidator = PasswordValidator()
    private val validPassword = "password1234"

    @Test
    fun `password must be at least 8 characters long`() {
        assertFailsWith<InvalidPasswordException>(
            message = "Password must be at least 8 characters",
            block = {
                passwordValidator.validate("aaaa")
            }
        )
        assertTrue(passwordValidator.validate(validPassword))
    }


    @Test
    fun `password must contain at least 2 numbers`() {
        assertFailsWith<InvalidPasswordException>(
            message = "The password must contain at least 2 numbers",
            block = {
                passwordValidator.validate("aaaaaaaa1")
            }
        )
        assertTrue(passwordValidator.validate(validPassword))
    }

}
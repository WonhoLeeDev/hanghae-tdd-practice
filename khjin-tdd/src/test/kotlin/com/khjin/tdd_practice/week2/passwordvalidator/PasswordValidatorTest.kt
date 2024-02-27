package com.khjin.tdd_practice.week2.passwordvalidator

import com.khjin.tdd_practice.week2.passwordvalidator.exception.InvalidPasswordException
import org.junit.jupiter.api.Test
import kotlin.test.assertFailsWith
import kotlin.test.assertTrue

class PasswordValidatorTest {

    @Test
    fun `password must be at least 8 characters long`() {
        val passwordValidator = PasswordValidator()
        assertFailsWith<InvalidPasswordException>(
            message = "Password must be at least 8 characters",
            block = {
                passwordValidator.validate("aaaa")
            }
        )
        assertTrue(passwordValidator.validate("password1234"))
    }
}
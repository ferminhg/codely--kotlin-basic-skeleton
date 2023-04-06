package com.codely.demo

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class CodelyberTest {
    @Test
    fun `it should greet successfully`() {
        val expectedGreet = WELCOME_MESSAGE
        assertEquals(expectedGreet, Codelyber().greet())
    }
}

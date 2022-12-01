package common

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class TemplateTest {

    private val exampleInput = listOf(
        "test"
    )

    @Test
    fun testPartOneWithExampleInput() {
        val solver = Template()
        val result = solver.problemOne(exampleInput)
        assertEquals(7, result)
    }

    @Test
    fun testPartTwoExampleInput() {
        val solver = Template()
        val result = solver.problemTwo(exampleInput)
        assertEquals(5, result)
    }
}
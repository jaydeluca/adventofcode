package twentytwentythree

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class Day9Test {

    private val exampleInput = listOf(
        "test"
    )

    @Test
    fun testPartOneWithExampleInput() {
        val solver = Day9()
        val result = solver.problemOne(exampleInput)
        assertEquals(7, result)
    }

    @Test
    fun testPartTwoExampleInput() {
        val solver = Day9()
        val result = solver.problemTwo(exampleInput)
        assertEquals(5, result)
    }
}
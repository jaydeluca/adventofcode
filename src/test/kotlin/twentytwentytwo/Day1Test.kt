package twentytwentytwo

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class Day1Test {

    private val exampleInput = listOf(
        "test"
    )

    @Test
    fun testPartOneWithExampleInput() {
        val solver = Day1()
        val result = solver.problemOne(exampleInput)
        assertEquals(7, result)
    }

    @Test
    fun testPartOneCustomInputTest() {
        val testInput = listOf(
            "100",
        )

        val solver = Day1()
        val result = solver.problemOne(testInput)
        assertEquals(8, result)
    }

    @Test
    fun testPartTwoExampleInput() {
        val solver = Day1()
        val result = solver.problemTwo(exampleInput)
        assertEquals(5, result)
    }
}
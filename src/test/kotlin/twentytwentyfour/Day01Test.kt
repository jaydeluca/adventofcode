package twentytwentyfour

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class Day01Test {

    private val exampleInput = listOf(
        "3   4",
        "4   3",
        "2   5",
        "1   3",
        "3   9",
        "3   3",
    )

    @Test
    fun testPartOneWithExampleInput() {
        val solver = Day01()
        val result = solver.problemOne(exampleInput)
        assertEquals(11, result)
    }

    @Test
    fun testPartTwoExampleInput() {
        val solver = Day01()
        val result = solver.problemTwo(exampleInput)
        assertEquals(31, result)
    }
}
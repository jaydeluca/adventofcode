package twentytwentytwo

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class Day2Test {

    private val exampleInput = listOf(
        "A Y",
        "B X",
        "C Z"
    )

    @Test
    fun testPartOneWithExampleInput() {
        val solver = Day2()
        val result = solver.problemOne(exampleInput)
        assertEquals(15, result)
    }

    @Test
    fun testPartTwoExampleInput() {
        val solver = Day2()
        val result = solver.problemTwo(exampleInput)
        assertEquals(12, result)
    }
}
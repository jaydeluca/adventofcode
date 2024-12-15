package twentytwentyfour

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class Day2Test {

    private val exampleInput = listOf(
        "7 6 4 2 1",
        "1 2 7 8 9",
        "9 7 6 2 1",
        "1 3 2 4 5",
        "8 6 4 4 1",
        "1 3 6 7 9",
    )

    @Test
    fun testPartOneWithExampleInput() {
        val solver = Day2()
        val result = solver.problemOne(exampleInput)
        assertEquals(2, result)
    }

    @Test
    fun testPartTwoExampleInput() {
        val solver = Day2()
        val result = solver.problemTwo(exampleInput)
        assertEquals(4, result)
    }
}
package twentytwentythree

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class Day6Test {

    private val exampleInput = listOf(
        "Time:      7  15   30",
        "Distance:  9  40  200",
    )

    @Test
    fun testPartOneWithExampleInput() {
        val solver = Day6()
        val result = solver.problemOne(exampleInput)
        assertEquals(288, result)
    }

    @Test
    fun testPartTwoExampleInput() {
        val solver = Day6()
        val result = solver.problemTwo(exampleInput)
        assertEquals(71503, result)
    }
}
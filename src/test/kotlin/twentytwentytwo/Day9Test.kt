package twentytwentytwo

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class Day9Test {

    private val exampleInput = listOf(
        "R 4",
        "U 4",
        "L 3",
        "D 1",
        "R 4",
        "D 1",
        "L 5",
        "R 2",
    )

    @Test
    fun testPartOneWithExampleInput() {
        val solver = Day9()
        val result = solver.problemOne(exampleInput)
        assertEquals(13, result)
    }

    @Test
    fun testPartTwoExampleInput() {
        val solver = Day9()
        val result = solver.problemTwo(exampleInput)
        assertEquals(5, result)
    }
}
package twentytwentytwo

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class Day8Test {

    private val exampleInput = listOf(
        "30373",
        "25512",
        "65332",
        "33549",
        "35390",
    )

    @Test
    fun testPartOneWithExampleInput() {
        val solver = Day8()
        val result = solver.problemOne(exampleInput)
        assertEquals(21, result)
    }

    @Test
    fun testPartTwoExampleInput() {
        val solver = Day8()
        val result = solver.problemTwo(exampleInput)
        assertEquals(8, result)
    }
}
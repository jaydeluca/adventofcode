package twentytwentyone

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class Day03KtTest {

    private val exampleInput = listOf(
        "00100",
        "11110",
        "10110",
        "10111",
        "10101",
        "01111",
        "00111",
        "11100",
        "10000",
        "11001",
        "00010",
        "01010",
    )

    @Test
    fun testPartOneWithExampleInput() {
        val solver = Day03()
        val result = solver.problemOne(exampleInput)
        assertEquals(198, result)
    }

    @Test
    fun testPartTwoWithExampleInput() {
        val solver = Day03()
        val result = solver.problemTwo(exampleInput)
        assertEquals(230, result)
    }
}
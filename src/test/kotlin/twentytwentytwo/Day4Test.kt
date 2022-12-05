package twentytwentytwo

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class Day4Test {

    private val exampleInput = listOf(
        "2-4,6-8",
        "2-3,4-5",
        "5-7,7-9",
        "2-8,3-7",
        "6-6,4-6",
        "2-6,4-8"
    )

    @Test
    fun testPartOneWithExampleInput() {
        val solver = Day4()
        val result = solver.problemOne(exampleInput)
        assertEquals(2, result)
    }

    @Test
    fun testPartTwoExampleInput() {
        val solver = Day4()
        val result = solver.problemTwo(exampleInput)
        assertEquals(4, result)
    }
}
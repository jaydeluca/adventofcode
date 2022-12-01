package twentytwentytwo

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class Day1Test {

    private val exampleInput = listOf(
        "1000",
        "2000",
        "3000",
        "",
        "4000",
        "",
        "5000",
        "6000",
        "",
        "7000",
        "8000",
        "9000",
        "",
        "10000",
    )

    @Test
    fun testPartOneWithExampleInput() {
        val solver = Day1()
        val result = solver.problemOne(exampleInput)
        assertEquals(24000, result)
    }

    @Test
    fun testPartTwoExampleInput() {
        val solver = Day1()
        val result = solver.problemTwo(exampleInput)
        assertEquals(45000, result)
    }
}
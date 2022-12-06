package twentytwentytwo

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class Day6Test {

    private val exampleInput = listOf(
        "mjqjpqmgbljsphdztnvjfqwrcgsmlb"
    )

    @Test
    fun testPartOneWithExampleInput() {
        val solver = Day6()
        val result = solver.problemOne(exampleInput[0])
        assertEquals(7, result)
    }


    @Test
    fun testPartTwoExampleInput() {
        val solver = Day6()
        val result = solver.problemTwo("mjqjpqmgbljsphdztnvjfqwrcgsmlb")
        assertEquals(19, result)
    }
}
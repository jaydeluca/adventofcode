package twentytwentyone

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class Day05KtTest {

    private val exampleInput: List<String> = listOf(
        "0,9 -> 5,9",
        "8,0 -> 0,8",
        "9,4 -> 3,4",
        "2,2 -> 2,1",
        "7,0 -> 7,4",
        "6,4 -> 2,0",
        "0,9 -> 2,9",
        "3,4 -> 1,4",
        "0,0 -> 8,8",
        "5,5 -> 8,2",
    )

    @Test
    fun testPartOneWithExampleInput() {
        val solver = Day05()
        val result = solver.problemOne(exampleInput)
        assertEquals(5, result)
    }

    @Test
    fun testPartTwoWithExampleInput() {
        val solver = Day05()
        val result = solver.problemTwo(exampleInput)
        assertEquals(17, result)
    }
}
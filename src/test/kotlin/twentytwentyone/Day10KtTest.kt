package twentytwentyone

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class Day10KtTest {

    private val exampleInput: List<String> = listOf(
    )

    @Test
    fun testPartOneWithExampleInput() {
        val solver = Day10()
        val result = solver.problemOne(exampleInput)
        assertEquals(26, result)
    }

    @Test
    fun testPartTwoWithExampleInput() {
        val solver = Day10()
        val result = solver.problemTwo(exampleInput)
        assertEquals(61229, result)
    }
}
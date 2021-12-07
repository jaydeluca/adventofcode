package twentytwentyone

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class Day06KtTest {

    private val exampleInput: List<String> = listOf()

    @Test
    fun testPartOneWithExampleInput() {
        val solver = Day06()
        val result = solver.problemOne(exampleInput)
        assertEquals(4512, result)
    }

    @Test
    fun testPartTwoWithExampleInput() {
        val solver = Day06()
        val result = solver.problemTwo(exampleInput)
        assertEquals(1924, result)
    }
}
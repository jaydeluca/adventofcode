package twentytwentyone

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class Day07KtTest {

    private val exampleInput: List<String> = listOf()

    @Test
    fun testPartOneWithExampleInput() {
        val solver = Day07()
        val result = solver.problemOne(exampleInput)
        assertEquals(37, result)
    }

    @Test
    fun testPartTwoWithExampleInput() {
        val solver = Day07()
        val result = solver.problemTwo(exampleInput)
        assertEquals(17, result)
    }
}
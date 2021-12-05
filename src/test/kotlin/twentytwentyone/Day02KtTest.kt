package twentytwentyone

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class Day02KtTest {

    private val exampleInput = listOf(
        "forward 5",
        "down 5",
        "forward 8",
        "up 3",
        "down 8",
        "forward 2",
    )

    @Test
    fun testPartOneWithExampleInput() {
        val solver = Day02()
        val result = solver.problemOne(exampleInput)
        assertEquals(150, result)
    }

    @Test
    fun testPartTwoWithExampleInput() {
        val solver = Day02()
        val result = solver.problemTwo(exampleInput)
        assertEquals(900, result)
    }
}
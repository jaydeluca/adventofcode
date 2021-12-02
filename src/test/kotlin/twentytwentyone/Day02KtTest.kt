package twentytwentyone

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class Day02KtTest {

    @Test
    fun testPartOneWithExampleInput() {
        val testInput = listOf(
            "forward 5",
            "down 5",
            "forward 8",
            "up 3",
            "down 8",
            "forward 2",
        )

        val solver = Day02()
        val result = solver.problemOne(testInput)
        assertEquals(150, result)
    }

    @Test
    fun testPartTwoWithExampleInput() {
        val testInput = listOf(
            "forward 5",
            "down 5",
            "forward 8",
            "up 3",
            "down 8",
            "forward 2",
        )

        val solver = Day02()
        val result = solver.problemTwo(testInput)
        assertEquals(900, result)
    }
}
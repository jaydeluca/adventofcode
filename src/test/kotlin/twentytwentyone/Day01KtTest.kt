package twentytwentyone

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class Day01KtTest {

    @Test
    fun testDay01PartOneWithExampleInput() {
        val testInput = listOf(
            "199",
            "200",
            "208",
            "210",
            "200",
            "207",
            "240",
            "269",
            "260",
            "263",
        )

        val solver = Day01()
        val result = solver.problemOne(testInput)
        assertEquals(7, result)
    }

    @Test
    fun testDay01PartOneCustomInputTest() {
        val testInput = listOf(
            "100",
            "101",
            "105",
            "106",
            "103",
            "104",
            "106",
            "108",
            "112",
            "123",
        )

        val solver = Day01()
        val result = solver.problemOne(testInput)
        assertEquals(8, result)
    }

    @Test
    fun testDay01PartTwoExampleInput() {
        val testInput = listOf(
            "199",
            "200",
            "208",
            "210",
            "200",
            "207",
            "240",
            "269",
            "260",
            "263",
        )

        val solver = Day01()
        val result = solver.problemTwo(testInput)
        assertEquals(5, result)
    }
}
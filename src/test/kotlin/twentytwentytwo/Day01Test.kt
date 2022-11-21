package twentytwentytwo

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class Day01Test {

    private val exampleInput = listOf(
        "test"
    )

    @Test
    fun testPartOneWithExampleInput() {
        val solver = Day01()
        val result = solver.problemOne(exampleInput)
        assertEquals(7, result)
    }

    @Test
    fun testPartOneCustomInputTest() {
//        val testInput = listOf(
//            "100",
//            "101",
//            "105",
//            "106",
//            "103",
//            "104",
//            "106",
//            "108",
//            "112",
//            "123",
//        )
//
//        val solver = Day01()
//        val result = solver.problemOne(testInput)
//        assertEquals(8, result)
    }

    @Test
    fun testPartTwoExampleInput() {
//        val solver = Day01()
//        val result = solver.problemTwo(exampleInput)
//        assertEquals(5, result)
    }
}
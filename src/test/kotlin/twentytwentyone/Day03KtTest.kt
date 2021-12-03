package twentytwentyone

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class Day03KtTest {

    @Test
    fun testPartOneWithExampleInput() {
        val testInput = listOf(
            "00100",
            "11110",
            "10110",
            "10111",
            "10101",
            "01111",
            "00111",
            "11100",
            "10000",
            "11001",
            "00010",
            "01010",
        )

        val solver = Day03()
        val result = solver.problemOne(testInput)
        assertEquals(198, result)
    }

//    @Test
//    fun testPartTwoWithExampleInput() {
//        val testInput = listOf(
//            "forward 5",
//            "down 5",
//            "forward 8",
//            "up 3",
//            "down 8",
//            "forward 2",
//        )
//
//        val solver = Day03()
//        val result = solver.problemTwo(testInput)
//        assertEquals(900, result)
//    }
}
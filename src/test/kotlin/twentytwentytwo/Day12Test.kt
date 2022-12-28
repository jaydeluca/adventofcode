package twentytwentytwo

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class Day12Test {

    private val exampleInput = listOf(
        "Sabqponm",
        "abcryxxl",
        "accszExk",
        "acctuvwj",
        "abdefghi",
    )

    @Test
    fun testConvertCharToNumber() {
        val result = Day12.TerrainMap.convertCharToNum('a')
        assertEquals(1, result)
    }

    @Test
    fun testPartOneWithExampleInput() {
        val solver = Day12()
        val result = solver.problemOne(exampleInput)
        assertEquals(31, result)
    }

    @Test
    fun testPartTwoExampleInput() {
        val solver = Day12()
        val result = solver.problemTwo(exampleInput)
        assertEquals(5, result)
    }
}
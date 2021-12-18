package twentytwentyone

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class Day09KtTest {

    private val exampleInput: List<String> = listOf(
        "2199943210",
        "3987894921",
        "9856789892",
        "8767896789",
        "9899965678",
    )

    @Test
    fun testCheckIfLowestMethod() {
        val solver = Day09()
        val result = solver.checkLowest(0, 1, solver.parseInput(exampleInput))
        assertTrue(result)

        val result2 = solver.checkLowest(0, 0, solver.parseInput(exampleInput))
        assertFalse(result2)

        val result3 = solver.checkLowest(2, 3, solver.parseInput(exampleInput))
        assertFalse(result3)
    }


    @Test
    fun testPartOneWithExampleInput() {
        val solver = Day09()
        val result = solver.problemOne(exampleInput)
        assertEquals(15, result)
    }

    @Test
    fun testPartTwoWithExampleInput() {
        val solver = Day09()
        val result = solver.problemTwo(exampleInput)
        assertEquals(61229, result)
    }
}
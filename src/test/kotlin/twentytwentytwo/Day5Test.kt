package twentytwentytwo

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class Day5Test {

    private val exampleInput = listOf(
        "    [D]    ",
        "[N] [C]    ",
        "[Z] [M] [P]",
        "1   2   3 ",
        "",
        "move 1 from 2 to 1",
        "move 3 from 1 to 3",
        "move 2 from 2 to 1",
        "move 1 from 1 to 2",
    )

    @Test
    fun testPartOneWithExampleInput() {
        val solver = Day5()
        val result = solver.problemOne(exampleInput)
        assertEquals("CMZ", result)
    }

    @Test
    fun testPartTwoExampleInput() {
        val solver = Day5()
        val result = solver.problemTwo(exampleInput)
        assertEquals("MCD", result)
    }
}
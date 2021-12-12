package twentytwentyone

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class Day11KtTest {

    private val exampleInput: List<String> = listOf(
        "5483143223",
        "2745854711",
        "5264556173",
        "6141336146",
        "6357385478",
        "4167524645",
        "2176841721",
        "6882881134",
        "4846848554",
        "5283751526",
    )

    @Test
    fun testStepFunction() {
        val cavern = Day11.Cavern.parse(exampleInput)
        cavern.step()
        assertEquals(6, cavern.gridItems[0][0].value)
        assertEquals(0, cavern.flashes)

        for (i in 0..8) {
            cavern.step()
        }

        assertEquals(0, cavern.gridItems[0][0].value)
        assertEquals(204, cavern.flashes)
    }


    @Test
    fun testPartOneWithExampleInput() {
        val solver = Day11()
        val result = solver.problemOne(exampleInput)
        assertEquals(1656, result)
    }

    @Test
    fun testPartTwoWithExampleInput() {
        val solver = Day11()
        val result = solver.problemTwo(exampleInput)
        assertEquals(17, result)
    }
}
package twentytwentyone

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class Day05KtTest {

    private val exampleInput: List<String> = listOf(
        "0,9 -> 5,9",
        "8,0 -> 0,8",
        "9,4 -> 3,4",
        "2,2 -> 2,1",
        "7,0 -> 7,4",
        "6,4 -> 2,0",
        "0,9 -> 2,9",
        "3,4 -> 1,4",
        "0,0 -> 8,8",
        "5,5 -> 8,2",
    )

    @Test
    fun testPartOneWithExampleInput() {
        val solver = Day05()
        val result = solver.problemOne(exampleInput)
        assertEquals(5, result)
    }

    @Test
    fun testPointsGeneratedFromLines() {
        val line1 = Day05.Line(
            start = Day05.Point(1, 1),
            end = Day05.Point(1,3)
        )

        val line2 = Day05.Line(
            start = Day05.Point(9, 7),
            end = Day05.Point(7,7)
        )

        val line1Expected = setOf(
            Day05.Point(1, 1),
            Day05.Point(1, 2),
            Day05.Point(1, 3),
        )

        val line2Expected = setOf(
            Day05.Point(9, 7),
            Day05.Point(8, 7),
            Day05.Point(7, 7),
        )

        assertEquals(line1Expected, line1.generatePoints())
        assertEquals(line2Expected, line2.generatePoints())
    }

    @Test
    fun testPointsGeneratedFromDiagonalLines() {
        val line1 = Day05.Line(
            start = Day05.Point(1, 1),
            end = Day05.Point(3,3)
        )

        val line2 = Day05.Line(
            start = Day05.Point(9, 7),
            end = Day05.Point(7,9)
        )

        val line1Expected = setOf(
            Day05.Point(1, 1),
            Day05.Point(2, 2),
            Day05.Point(3, 3),
        )

        val line2Expected = setOf(
            Day05.Point(9, 7),
            Day05.Point(8, 8),
            Day05.Point(7, 9),
        )

        assertEquals(line1Expected, line1.generatePoints())
        assertEquals(line2Expected, line2.generatePoints())
    }

    @Test
    fun testPartTwoWithExampleInput() {
        val solver = Day05()
        val result = solver.problemTwo(exampleInput)
        assertEquals(12, result)
    }
}
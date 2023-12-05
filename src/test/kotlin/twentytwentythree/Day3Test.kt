package twentytwentythree

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class Day3Test {

    private val exampleInput = listOf(
        "467..114..",
        "...*......",
        "..35..633.",
        "......#...",
        "617*......",
        ".....+.58.",
        "..592.....",
        "......755.",
        "...$.*....",
        ".664.598..",
    )

    @Test
    fun testPartOneWithExampleInput() {
        val solver = Day3(exampleInput)

        val result = solver.problemOne()
        assertEquals(4361, result)
    }


    @Test
    fun numberHasAdjacentSymbol() {
        val input = listOf(
            "467..114..",
            "...*......",
        )
        val solver = Day3(input)

        val result = solver.partOneProcessLine(0)
        assertEquals(467, result)
    }

    @Test
    fun testActualInput() {

        val input = listOf(
            "...............307............130..................969...601...186.........................................312....628..........878..........",
            "......479#../..*..............................#.....*......*............../309.....484........................*......-..........+.....89....",
            "...........726..352...461..69..............435.....390...625....................................459.........152...-....580............*.....",
            ".......................*.......454*674.448......65................257....104*762....&..............*269.........558.&.....*907.........652..",
            ".....................164.....-..............532*.....................................484......108........955.........252..........321.......",
        )

        val solver = Day3(input)

        var result = solver.partOneProcessLine(0)
        assertEquals(3695, result)

        result = solver.partOneProcessLine(1)
        assertEquals(877, result)

        result = solver.partOneProcessLine(2)
        assertEquals(4180, result)

        result = solver.partOneProcessLine(3)
        assertEquals(4445, result)

        result = solver.problemOne()
        assertEquals(14629, result)
    }

    @Test
    fun testIsSymbol() {
        listOf("*", "&", "=", "/", "-", "+", "@", "%", "$", "#").forEach {
            val solver = Day3(listOf(it))
            assertTrue(solver.checkIsSymbol(0, 0))
        }

        val solver2 = Day3(listOf("."))
        assertFalse(solver2.checkIsSymbol(0, 0))

        val solver3 = Day3(listOf("3"))
        assertFalse(solver3.checkIsSymbol(0, 0))
    }

    @Test
    fun lineHasMultiple() {
        val input = listOf(
            "467*114...",
        )
        val solver = Day3(input)
        val result = solver.partOneProcessLine(0)
        assertEquals(581, result)
    }

    @Test
    fun testPartTwoExampleInput() {
        val solver = Day3(exampleInput)
        val result = solver.problemTwo()
        assertEquals(467835, result)
    }
}
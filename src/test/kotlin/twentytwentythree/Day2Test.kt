package twentytwentythree

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class Day2Test {

    private val exampleInput = listOf(
        "Game 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green",
        "Game 2: 1 blue, 2 green; 3 green, 4 blue, 1 red; 1 green, 1 blue",
        "Game 3: 8 green, 6 blue, 20 red; 5 blue, 4 red, 13 green; 5 green, 1 red",
        "Game 4: 1 green, 3 red, 6 blue; 3 green, 6 red; 3 green, 15 blue, 14 red",
        "Game 5: 6 red, 1 blue, 3 green; 2 blue, 1 red, 2 green",
    )

    @Test
    fun testParseLine() {
        val solver = Day2()
        val result = solver.calculatePossibleGame("Game 2: 1 blue, 2 green; 3 green, 4 blue, 1 red; 1 green, 1 blue")
        assertEquals(2, result)
        val result2 = solver.calculatePossibleGame("Game 3: 8 green, 6 blue, 20 red; 5 blue, 4 red, 13 green; 5 green, 1 red")
        assertEquals(0, result2)
    }

    @Test
    fun testParseLineWithManyGames() {
        val solver = Day2()
        val result = solver.calculatePossibleGame("Game 51: 6 red, 3 green, 8 blue; 5 green, 16 blue, 1 red; 2 green, 13 red, 14 blue; 14 red, 12 green, 19 blue; 19 blue, 13 green, 9 red; 6 red, 15 blue, 7 green")
        assertEquals(0, result)
    }

    @Test
    fun testFindPowerOfMinimum() {
        val solver = Day2()
        val result = solver.calculateMinimumPossibleGame("Game 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green")
        assertEquals(48, result)
    }

    @Test
    fun testPartOneWithExampleInput() {
        val solver = Day2()
        val result = solver.problemOne(exampleInput)
        assertEquals(8, result)
    }

    @Test
    fun testPartTwoExampleInput() {
        val solver = Day2()
        val result = solver.problemTwo(exampleInput)
        assertEquals(2286, result)
    }
}
package twentytwentythree

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class Day4Test {

    private val exampleInput = listOf(
        "Card 1: 41 48 83 86 17 | 83 86  6 31 17  9 48 53",
        "Card 2: 13 32 20 16 61 | 61 30 68 82 17 32 24 19",
        "Card 3:  1 21 53 59 44 | 69 82 63 72 16 21 14  1",
        "Card 4: 41 92 73 84 69 | 59 84 76 51 58  5 54 83",
        "Card 5: 87 83 26 28 32 | 88 30 70 12 93 22 82 36",
        "Card 6: 31 18 13 56 72 | 74 77 10 23 35 67 36 11",
    )

    @Test
    fun testPartOneWithExampleInput() {
        val solver = Day4()
        val result = solver.problemOne(exampleInput)
        assertEquals(13, result)
    }

    @Test
    fun testPartOneSpaces() {
        val solver = Day4()
        val result = solver.problemOne(listOf("Card 161:  6 15 69 39 76 73 99 84 21 32 | 82  5 64 79 92 91  2 48  6 12 45 43 80 95 33 21 55 15 66 34 73 16 58 39 54"))
        assertEquals(13, result)
    }


    @Test
    fun testPartTwoExampleInput() {
        val solver = Day4()
        val result = solver.problemTwo(exampleInput)
        assertEquals(30, result)
    }
}
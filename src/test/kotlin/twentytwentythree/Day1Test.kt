package twentytwentythree

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class Day1Test {

    private val exampleInput = listOf(
        "1abc2",
        "pqr3stu8vwx",
        "a1b2c3d4e5f",
        "treb7uchet",
    )
    private val exampleInput2 = listOf(
            "two1nine",
            "eightwothree",
            "abcone2threexyz",
            "xtwone3four",
            "4nineeightseven2",
            "zoneight234",
            "7pqrstsixteen",
    )

    @Test
    fun testPartOneWithExampleInput() {
        val solver = Day1()
        val result = solver.problemOne(exampleInput)
        assertEquals(142, result)
    }

    @Test
    fun testParseOverlapping() {
        val solver = Day1()
        val result = solver.convertLineToNumeric("eightwothree")
        assertEquals("823", result)
    }

    @Test
    fun testParseBothNumbersAndAlpha() {
        val solver = Day1()
        val result = solver.convertLineToNumeric("dssmtmrkonedbbhdhjbf9hq")
        assertEquals("19", result)

        val result2 = solver.convertLineToNumeric("2njsevenszzsfltconesixhsflpbpd")
        assertEquals("2716", result2)
    }


    @Test
    fun testPartTwoExampleInput() {
        val solver = Day1()
        val result = solver.problemTwo(exampleInput2)
        assertEquals(281, result)
    }
}
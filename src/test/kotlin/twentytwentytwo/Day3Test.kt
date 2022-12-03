package twentytwentytwo

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class Day3Test {

    private val exampleInput = listOf(
        "vJrwpWtwJgWrhcsFMMfFFhFp",
        "jqHRNqRjqzjGDLGLrsFMfFZSrLrFZsSL",
        "PmmdzqPrVvPwwTWBwg",
        "wMqvLMZHhHMvwLHjbvcjnnSBnvTQFn",
        "ttgJtRGJQctTZtZT",
        "CrZsJsPPZsGzwwsLwLmpwMDw",
    )

    @Test
    fun testPartOneWithExampleInput() {
        val solver = Day3()
        val result = solver.problemOne(exampleInput)
        assertEquals(157, result)
    }


    @Test
    fun testPartTwoExampleInput() {
        val solver = Day3()
        val result = solver.problemTwo(exampleInput)
        assertEquals(70, result)
    }
}
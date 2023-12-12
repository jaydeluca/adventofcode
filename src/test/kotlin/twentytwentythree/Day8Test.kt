package twentytwentythree

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class Day8Test {

    private val exampleInput = listOf(
        "RL",
        "",
        "AAA = (BBB, CCC)",
        "BBB = (DDD, EEE)",
        "CCC = (ZZZ, GGG)",
        "DDD = (DDD, DDD)",
        "EEE = (EEE, EEE)",
        "GGG = (GGG, GGG)",
        "ZZZ = (ZZZ, ZZZ)",
    )
    private val exampleInput2 = listOf(
        "LLR",
        ",",
        "AAA = (BBB, BBB)",
        "BBB = (AAA, ZZZ)",
        "ZZZ = (ZZZ, ZZZ)",
    )


    @Test
    fun testPartOneWithExampleInput() {
        val solver = Day8()
        val result = solver.problemOne(exampleInput)
        assertEquals(2, result)
    }

    @Test
    fun testPartOneWithExampleInput2() {
        val solver = Day8()
        val result = solver.problemOne(exampleInput2)
        assertEquals(6, result)
    }

    @Test
    fun testPartTwoExampleInput() {

        val testInput = listOf(
            "LR",
            "",
            "11A = (11B, XXX)",
            "11B = (XXX, 11Z)",
            "11Z = (11B, XXX)",
            "22A = (22B, XXX)",
            "22B = (22C, 22C)",
            "22C = (22Z, 22Z)",
            "22Z = (22B, 22B)",
            "XXX = (XXX, XXX)",
        )
        val solver = Day8()
        val result = solver.problemTwo(testInput)
        assertEquals(6, result)
    }
}
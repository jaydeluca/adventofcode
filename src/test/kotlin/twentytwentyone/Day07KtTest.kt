package twentytwentyone

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class Day07KtTest {

    private val exampleInput: List<String> = listOf(
        "16,1,2,0,4,2,7,1,2,14"
    )

    @Test
    fun testFuelCalculation() {
        val solver = Day07()
        val crabDeets = Day07.CrabDeets.parse(exampleInput)

        val test1 = solver.calculateFuel(1, crabDeets.positions)
        assertEquals(41, test1)

        val test2 = solver.calculateFuel(3, crabDeets.positions)
        assertEquals(39, test2)

        val test3 = solver.calculateFuel(10, crabDeets.positions)
        assertEquals(71, test3)
    }

    @Test
    fun testPartOneWithExampleInput() {
        val solver = Day07()
        val result = solver.problemOne(exampleInput)
        assertEquals(37, result)
    }

    @Test
    fun testExpensiveFuelCalculation() {
        val solver = Day07()
        val crabDeets = Day07.CrabDeets.parse(exampleInput)

        val test1 = solver.calculateFuelExpensive(5, crabDeets.positions)
        assertEquals(168, test1)
    }

    @Test
    fun testPartTwoWithExampleInput() {
        val solver = Day07()
        val result = solver.problemTwo(exampleInput)
        assertEquals(168, result)
    }
}
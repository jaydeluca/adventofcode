package twentytwentyone

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import java.math.BigInteger

class Day06KtTest {

    private val exampleInput: List<String> = listOf(
        "3,4,3,1,2"
    )

    @Test
    fun testPartOneWithExampleInput() {
        val solver = Day06()
        val result = solver.problemOne(exampleInput)
        assertEquals(BigInteger.valueOf(5934), result)
    }

    @Test
    fun testPartTwoWithExampleInput() {
        val solver = Day06()
        val result = solver.problemTwo(exampleInput)
        assertEquals(BigInteger.valueOf(26984457539), result)
    }
}
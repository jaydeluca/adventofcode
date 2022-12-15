package twentytwentytwo

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class Day9Test {

    private val exampleInput = listOf(
        "R 4",
        "U 4",
        "L 3",
        "D 1",
        "R 4",
        "D 1",
        "L 5",
        "R 2",
    )

    @Test
    fun testPartOneWithExampleInput() {
        val solver = Day9()
        val result = solver.problemOne(exampleInput)
        assertEquals(13, result)
    }

    @Test
    fun testIsTouchingMethod() {
        val head = Day9.Position(x=4, y=1)
        val tail = Day9.Position(x=3, y=0)
        assertTrue(head.isTouching(tail))
    }

    @Test
    fun testMoves() {
        val solver = Day9()
        solver.parseInput(listOf("R 4"))

        solver.moves.forEach {
            (0 until it.spaces).forEach { cur ->
                solver.headLocation.processMove(Day9.Move(direction = it.direction, spaces = 1))
                val tailMove =  solver.headLocation.calculateTailMove(solver.tailLocation)
                solver.tailLocation.processMove(tailMove)
            }
        }
        assertEquals(solver.headLocation.x, 4)
        assertEquals(solver.headLocation.y, 0)
        assertEquals(solver.tailLocation.x, 3)
        assertEquals(solver.tailLocation.y, 0)


        solver.parseInput(listOf("U 4"))

        solver.moves.forEach {
            (0 until it.spaces).forEach { cur ->
                solver.headLocation.processMove(Day9.Move(direction = it.direction, spaces = 1))
                val tailMove =  solver.headLocation.calculateTailMove(solver.tailLocation)
                solver.tailLocation.processMove(tailMove)
            }
        }

        assertEquals(solver.headLocation.x, 4)
        assertEquals(solver.headLocation.y, 4)
        assertEquals(solver.tailLocation.x, 4)
        assertEquals(solver.tailLocation.y, 3)


        solver.parseInput(listOf("L 3"))

        solver.moves.forEach {
            (0 until it.spaces).forEach { cur ->
                solver.headLocation.processMove(Day9.Move(direction = it.direction, spaces = 1))
                val tailMove =  solver.headLocation.calculateTailMove(solver.tailLocation)
                solver.tailLocation.processMove(tailMove)
            }
        }

        assertEquals( 1, solver.headLocation.x)
        assertEquals(4, solver.headLocation.y)
        assertEquals(2, solver.tailLocation.x)
        assertEquals(4, solver.tailLocation.y)


        solver.parseInput(listOf("D 1"))

        solver.moves.forEach {
            (0 until it.spaces).forEach { cur ->
                solver.headLocation.processMove(Day9.Move(direction = it.direction, spaces = 1))
                val tailMove =  solver.headLocation.calculateTailMove(solver.tailLocation)
                solver.tailLocation.processMove(tailMove)
            }
        }

        assertEquals( 1, solver.headLocation.x)
        assertEquals(3, solver.headLocation.y)
        assertEquals(2, solver.tailLocation.x)
        assertEquals(4, solver.tailLocation.y)

        solver.parseInput(listOf("R 4"))

        solver.moves.forEach {
            (0 until it.spaces).forEach { cur ->
                solver.headLocation.processMove(Day9.Move(direction = it.direction, spaces = 1))
                val tailMove =  solver.headLocation.calculateTailMove(solver.tailLocation)
                solver.tailLocation.processMove(tailMove)
            }
        }

        assertEquals( 5, solver.headLocation.x)
        assertEquals(3, solver.headLocation.y)
        assertEquals(4, solver.tailLocation.x)
        assertEquals(3, solver.tailLocation.y)

    }

    @Test
    fun testPartTwoExampleInput() {
        val solver = Day9()
        val result = solver.problemTwo(exampleInput)
        assertEquals(36, result)
    }
}
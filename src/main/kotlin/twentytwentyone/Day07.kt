package twentytwentyone

import common.FileInput

class Day07 {

    data class CrabDeets(
        val positions: Map<Int, List<Int>>,
        val max: Int
    ) {
        companion object Factory {
            fun parse(input: List<String>): CrabDeets {
                val parsed = input[0]
                    .split(",")
                    .map(String::toInt)
                    .sorted()
                return CrabDeets(
                    positions = parsed.groupBy { it },
                    max = parsed.last()
                )
            }
        }
    }

    fun calculateFuel(
        position: Int, horizontalPositions: Map<Int, List<Int>>
    ) = horizontalPositions.map {
        kotlin.math.abs(it.key - position) * it.value.size
    }.sum()

    fun calculateFuelExpensive(
        position: Int, horizontalPositions: Map<Int, List<Int>>
    ) = horizontalPositions.map {
        val delta = kotlin.math.abs(it.key - position)
        val cost = if (delta > 0) {
            (1..delta).reduce(Int::plus)
        } else 0
        cost * it.value.size
    }.sum()


    fun problemOne(input: List<String>): Int {
        val crabDeets = CrabDeets.parse(input)

        return (1..crabDeets.max).map {
            calculateFuel(it, crabDeets.positions)
        }.minOrNull() ?: 0
    }

    fun problemTwo(input: List<String>): Int {
        val crabDeets = CrabDeets.parse(input)

        return (1..crabDeets.max).map {
            calculateFuelExpensive(it, crabDeets.positions)
        }.minOrNull() ?: 0
    }
}


fun main() {
    val input = FileInput().get("src/main/kotlin/twentytwentyone/inputs/day07.txt")
    val solver = Day07()
    println("Problem one: ${solver.problemOne(input)}")
    println("Problem two: ${solver.problemTwo(input)}")
}


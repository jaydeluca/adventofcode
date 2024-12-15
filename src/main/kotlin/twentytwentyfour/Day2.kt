package twentytwentyfour

import common.FileInput
import kotlin.math.abs


class Day2 {
    fun parseInput(input: List<String>): List<List<Int>> {
        return input.map {
            it.split(" ").map(String::toInt)
        }
    }

    enum class DIRECTION {
        INCREASING,
        DECREASING
    }

    fun problemOne(input: List<String>): Int {
        val inputs = parseInput(input)
        return inputs.count { isValidSequence(it) }
    }

    private fun isValidSequence(sequence: List<Int>): Boolean {
        if (sequence.size < 2) return false

        var delta = sequence[0] - sequence[1]
        if (delta == 0 || abs(delta) > 3) return false

        val direction = if (delta > 0) DIRECTION.DECREASING else DIRECTION.INCREASING

        for (i in 1 until sequence.size - 1) {
            delta = sequence[i] - sequence[i + 1]
            if (delta == 0 || abs(delta) > 3) return false
            if ((delta > 0 && direction == DIRECTION.INCREASING) || (delta < 0 && direction == DIRECTION.DECREASING)) return false
        }
        return true
    }

    private fun removeBadReport(sequence: List<Int>): List<Int> {

        var delta = sequence[0] - sequence[1]
        if (delta == 0 || abs(delta) > 3) return sequence.takeLast(sequence.size - 2)

        val direction = if (delta > 0) DIRECTION.DECREASING else DIRECTION.INCREASING

        for (i in 1 until sequence.size - 1) {
            delta = sequence[i] - sequence[i + 1]
            if (delta == 0 || abs(delta) > 3) {
                val result = sequence.take(i) + sequence.takeLast(sequence.size - i - 1)
                return result
            }
            if ((delta > 0 && direction == DIRECTION.INCREASING) || (delta < 0 && direction == DIRECTION.DECREASING)) {
                val result = sequence.take(i) + sequence.takeLast(sequence.size - i - 1)
                return result
            }
        }
        return sequence
    }

    fun problemTwo(input: List<String>) : Int {
        val inputs = parseInput(input)
        return inputs.map { removeBadReport(it) }.count{ isValidSequence(it)}
    }
}


fun main() {
    val input = FileInput().get("src/main/kotlin/twentytwentyfour/inputs/day2.txt")
    val solver = Day2()
    println("Problem one: ${solver.problemOne(input)}")
    println("Problem two: ${solver.problemTwo(input)}")
}

package twentytwentytwo

import common.FileInput


class Day4 {
    data class Range(val start: Int, val end: Int) {
        fun isWithin(otherRange: Range): Boolean {
            return this.start >= otherRange.start && this.end <= otherRange.end
        }

        fun overlapsWith(otherRange: Range): Boolean {
            return maxOf(this.start, otherRange.start) <= minOf(this.end, otherRange.end)
        }
    }

    private fun parseInput(input: List<String>) : List<List<Range>> {
        return input.map {
            val split = it.split(",")
            val pairA = split[0].split("-")
            val pairB = split[1].split("-")

            listOf(
                Range(pairA[0].toInt(), pairA[1].toInt()),
                Range(pairB[0].toInt(), pairB[1].toInt())
            )
        }
    }

    fun problemOne(input: List<String>) : Int {
        return parseInput(input).filter {
            it[0].isWithin(it[1]) || it[1].isWithin(it[0])
        }.size
    }

    fun problemTwo(input: List<String>) : Int {
        return parseInput(input).filter {
            it[0].overlapsWith(it[1])
        }.size
    }
}


fun main() {
    val input = FileInput().get("src/main/kotlin/twentytwentytwo/inputs/day4.txt")
    val solver = Day4()
    println("Problem one: ${solver.problemOne(input)}")
    println("Problem two: ${solver.problemTwo(input)}")
}

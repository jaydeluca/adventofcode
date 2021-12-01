package twentytwentyone

import common.FileInput


class Day01 {
    fun problemOne(input: List<String>) = input
        .filterIndexed { index, i -> if (index > 0) i.toInt() > input[index - 1].toInt() else false }
        .count()

    fun problemTwo(input: List<String>) : Int {
        val windowed = input.windowed(size = 3, step = 1)
            .map{ it -> it.sumOf { it.toInt() } }
            .toList()

        return windowed
            .filterIndexed { index, i -> if (index > 0) i > windowed[index - 1] else false }
            .count()
    }
}


fun main() {
    val input = FileInput().get("inputs/day01.txt")
    val day01 = Day01()
    println("Problem one: ${day01.problemOne(input)}")
    println("Problem two: ${day01.problemTwo(input)}")
}


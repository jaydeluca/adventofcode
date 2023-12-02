package twentytwentythree

import common.FileInput


class Day2 {
    private val cubeMap = mapOf(
        "red" to 12,
        "green" to 13,
        "blue" to 14
    )

    private val gameIdRegex = Regex("""Game (\d+)""")

    fun calculatePossibleGame(input: String): Int {
        val gameId = gameIdRegex.find(input)?.let { it.groupValues[1] }
        cubeMap.forEach {
            val colorRegex = Regex(""" (\d+) ${it.key}""")
            val results = colorRegex.findAll(input)
                .map { result -> result.groupValues[1] }.toList()
                .map(String::toInt).filter { count ->
                    count > it.value
                }
            if (results.isNotEmpty()) return 0
        }
        return gameId!!.toInt()
    }

    fun calculateMinimumPossibleGame(input: String): Int {
        return cubeMap.map {
            Regex(""" (\d+) ${it.key}""")
                .findAll(input)
                .map { result -> result.groupValues[1] }.maxOf(String::toInt)
        }.reduce { x, y -> x * y }
    }

    fun problemOne(input: List<String>): Int {
        return input.sumOf { (calculatePossibleGame(it)) }
    }

    fun problemTwo(input: List<String>): Int {
        return input.sumOf { calculateMinimumPossibleGame(it) }
    }
}

fun main() {
    val input = FileInput().get("src/main/kotlin/twentytwentythree/inputs/day2.txt")
    val solver = Day2()
    println("Problem one: ${solver.problemOne(input)}")
    println("Problem two: ${solver.problemTwo(input)}")
}

package twentytwentythree

import common.FileInput


class Day6 {

    data class Game(
        val time: Long,
        val distance: Long
    ) {
        fun calculateWins(): Int {
            return (0..time).filter {
                it * (time - it) > distance
            }.size
        }
    }

    fun problemOne(input: List<String>): Int {
        val times = input[0].split("\\s+".toRegex())
        val distances = input[1].split("\\s+".toRegex())
        val games = mutableListOf<Game>()
        (1 until times.size).forEach {
            games.add(Game(time = times[it].toLong(), distance = distances[it].toLong()))
        }

        return games.map { game ->
            game.calculateWins()
        }.reduce { x, y -> x * y }
    }

    fun problemTwo(input: List<String>): Int {
        val times = input[0]
            .split(":")[1]
                .split("\\s+".toRegex())
                .filter { it.isNotEmpty() }
                .joinToString(separator = "")
            .toLong()

        val distances = input[1]
            .split(":")[1]
                .split("\\s+".toRegex())
                .filter { it.isNotEmpty() }
                .joinToString(separator = "")
            .toLong()

        return Game(time = times, distance = distances).calculateWins()
    }
}


fun main() {
    val input = FileInput().get("src/main/kotlin/twentytwentythree/inputs/day6.txt")
    val solver = Day6()
    println("Problem one: ${solver.problemOne(input)}")
    println("Problem two: ${solver.problemTwo(input)}")
}

package twentytwentyone

import common.FileInput


class Day02 {
    enum class Direction() {
        FORWARD, DOWN, UP;
    }

    data class ProblemInput(
        val direction: Direction,
        val value: Int
    ) {
        companion object Factory {
            fun parse(input: String): ProblemInput {
                val inputs = input.split(" ")
                return ProblemInput(
                    direction = Direction.valueOf(inputs[0].uppercase()),
                    value = inputs[1].toInt()
                )
            }
        }
    }

    data class Location(
        private var horizontalPosition: Int = 0,
        private var depth: Int = 0,
        private var aim: Int = 0
    ) {
        fun move(input: String) {
            val problemInput = ProblemInput.parse(input)
            when (problemInput.direction) {
                Direction.FORWARD -> horizontalPosition += problemInput.value
                Direction.DOWN -> depth += problemInput.value
                Direction.UP -> depth -= problemInput.value
            }
        }

        fun moveWithAim(input: String) {
            val problemInput = ProblemInput.parse(input)
            when (problemInput.direction) {
                Direction.FORWARD -> {
                    horizontalPosition += problemInput.value
                    depth += aim * problemInput.value
                }
                Direction.DOWN -> aim += problemInput.value
                Direction.UP -> aim -= problemInput.value
            }
        }

        fun result() = horizontalPosition * depth
    }

    fun problemOne(input: List<String>): Int {
        val shipLocation = Location()
        input.forEach { shipLocation.move(it) }
        return shipLocation.result()
    }

    fun problemTwo(input: List<String>): Int {
        val shipLocation = Location()
        input.forEach { shipLocation.moveWithAim(it) }
        return shipLocation.result()
    }
}


fun main() {
    val input = FileInput().get("src/main/kotlin/twentytwentyone/inputs/day02.txt")
    val solver = Day02()
    println("Problem one: ${solver.problemOne(input)}")
    println("Problem two: ${solver.problemTwo(input)}")
}


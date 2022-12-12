package twentytwentytwo

import common.FileInput


class Day9 {

    // head (H) and tail (T) must always be touching (diagonally adjacent and even overlapping both count as touching)


    enum class Direction {
        UP,
        DOWN,
        RIGHT,
        LEFT,
        UPLEFT,
        UPRIGHT,
        DOWNLEFT,
        DOWNRIGHT
    }

    fun calculateTailMove(): Move {
        // If the head is ever two steps directly up, down, left, or right from the tail, the tail must also move one step in that direction so it remains close enough:
        if (headLocation.isSameColumn(tailLocation)) {
            if (headLocation.y - tailLocation.y > 0) {
                return Move(Direction.UP, 1)
            }
            if (headLocation.y - tailLocation.y < 0) {
                return Move(Direction.DOWN, 1)
            }
        }
        if (headLocation.isSameRow(tailLocation)) {
            if (headLocation.x - tailLocation.x > 0) {
                return Move(Direction.RIGHT, 1)
            }
            if (headLocation.x - tailLocation.x < 0) {
                return Move(Direction.LEFT, 1)
            }
        }

        // Otherwise, if the head and tail aren't touching and aren't in the same row or column, the tail always moves one step diagonally to keep up:
        if (headLocation.x - tailLocation.x > 1) {
            return Move(Direction.DOWNLEFT, 1)
        }
        if (headLocation.x - tailLocation.x < 0) {
            return Move(Direction.UPRIGHT, 1)
        }

        if (headLocation.y - tailLocation.y > 0) {
            return Move(Direction.UPRIGHT, 1)
        }
        if (headLocation.y - tailLocation.y < 0) {
            return Move(Direction.DOWN, 1)
        }


    }

    data class Move(val direction: Direction, val spaces: Int)

    private var headLocation = Position(x = 0, y = 0)
    private var tailLocation = Position(x = 0, y = 0)

    data class Position(val x: Int, val y: Int) {
        fun processMove(move: Move) {
            when (move.direction) {
                Direction.DOWN -> this.y - move.spaces
                Direction.UP -> this.y + move.spaces
                Direction.LEFT -> this.x - move.spaces
                Direction.RIGHT -> this.x + move.spaces
                Direction.UPLEFT -> {
                    this.x - 1
                    this.y + 1
                }
                Direction.DOWNLEFT -> {
                    this.y - 1
                    this.x - 1
                }
                Direction.DOWNRIGHT -> {
                    this.y - 1
                    this.x + 1
                }
                Direction.UPRIGHT -> {
                    this.x + 1
                    this.y + 1
                }
            }
        }

        fun isSameRow(position: Position): Boolean {
            return this.x == position.x
        }

        fun isSameColumn(position: Position): Boolean {
            return this.y == position.y
        }

    }

    private var moves = listOf<Move>()

    private fun parseInput(input: List<String>) {
        this.moves = input.map {
            val split = it.split(" ")
            val direction = when (split[0]) {
                "R" -> Direction.RIGHT
                "L" -> Direction.LEFT
                "U" -> Direction.UP
                "D" -> Direction.DOWN
                else -> throw RuntimeException()
            }
            Move(direction = direction, spaces = Integer.parseInt(split[1]))
        }
        headLocation = Position(x = 0, y = 0)
        tailLocation = Position(x = 0, y = 0)
    }

    fun problemOne(input: List<String>): Int {
        parseInput(input)


        val dataMap = HashMap<Int, HashMap<Int, Int>>()
        val headLocation = Position(x = 0, y = 0)
        val tailLocation = Position(x = 0, y = 0)

        moves.forEach {
            headLocation.processMove(it)



        }



        return 1
    }

    fun problemTwo(input: List<String>): Int {
        return 1
    }
}


fun main() {
    val input = FileInput().get("src/main/kotlin/twentytwentytwo/inputs/day9.txt")
    val solver = Day9()
    println("Problem one: ${solver.problemOne(input)}")
    println("Problem two: ${solver.problemTwo(input)}")
}

package twentytwentytwo

import common.FileInput


class Day9 {

    class Rope(root: Knot) {
        var size = 1
        var tail: Knot = root
        fun add(knot: Knot) {
            tail.add(knot)
            this.tail = knot
            size++
        }
    }

    class Knot(var position: Position, var child: Knot? = null, val index: Int) {
        fun add(knot: Knot) {
            this.child = knot
        }

        fun hasNext(): Boolean {
            return child !== null
        }
    }

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

    data class Move(val direction: Direction, val spaces: Int)

    var headLocation = Position(x = 0, y = 0)
    var tailLocation = Position(x = 0, y = 0)

    data class Position(var x: Int, var y: Int) {

        val history = mutableSetOf<Pair<Int, Int>>()

        fun processMove(move: Move) {
            history.add(Pair(this.x, this.y))
            when (move.direction) {
                Direction.DOWN -> this.y -= move.spaces
                Direction.UP -> this.y += move.spaces
                Direction.LEFT -> this.x -= move.spaces
                Direction.RIGHT -> this.x += move.spaces
                Direction.UPLEFT -> {
                    this.x -= 1
                    this.y += 1
                }
                Direction.DOWNLEFT -> {
                    this.y -= 1
                    this.x -= 1
                }
                Direction.DOWNRIGHT -> {
                    this.y -= 1
                    this.x += 1
                }
                Direction.UPRIGHT -> {
                    this.x += 1
                    this.y += 1
                }
            }
            history.add(Pair(this.x, this.y))
        }

        fun isSameRow(position: Position): Boolean {
            return this.y == position.y
        }

        fun isSameColumn(position: Position): Boolean {
            return this.x == position.x
        }

        fun isTouching(position: Position): Boolean {
            return kotlin.math.abs(this.x - position.x) <= 1 && kotlin.math.abs(this.y - position.y) <= 1
        }

        fun calculateTailMove(tailLocation: Position): Move {
            // If the head is ever two steps directly up, down, left, or right from the tail, the tail must also move one step in that direction so it remains close enough
            if (this.isTouching(tailLocation)) {
                return Move(Direction.DOWN, 0)
            }

            if (this.isSameRow(tailLocation)) {
                if (this.x - tailLocation.x > 0) {
                    return Move(Direction.RIGHT, 1)
                }
                return Move(Direction.LEFT, 1)
            }

            if (this.isSameColumn(tailLocation)) {
                if (this.y - tailLocation.y > 0) {
                    return Move(Direction.UP, 1)
                }
                return Move(Direction.DOWN, 1)
            }

            // Otherwise, if the head and tail aren't touching and aren't in the same row or column, the tail always moves one step diagonally to keep up
            if ((tailLocation.x + 1 == this.x && tailLocation.y + 2 == this.y)
                || (tailLocation.x + 2 == this.x && tailLocation.y + 1 == this.y)
            ) {
                return Move(Direction.UPRIGHT, 1)
            }

            if ((tailLocation.x - 1 == this.x && tailLocation.y + 2 == this.y)
                || (tailLocation.x - 2 == this.x && tailLocation.y + 1 == this.y)
            ) {
                return Move(Direction.UPLEFT, 1)
            }

            if ((tailLocation.x - 1 == this.x && tailLocation.y - 2 == this.y)
                || (tailLocation.x - 2 == this.x && tailLocation.y - 1 == this.y)
            ) {
                return Move(Direction.DOWNLEFT, 1)
            }

            if ((tailLocation.x + 1 == this.x && tailLocation.y - 2 == this.y)
                || (tailLocation.x + 2 == this.x && tailLocation.y - 1 == this.y)
            ) {
                return Move(Direction.DOWNRIGHT, 1)
            }
            return Move(Direction.DOWN, 0)
        }

    }

    var moves = listOf<Move>()

    fun parseInput(input: List<String>) {
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
    }

    fun problemOne(input: List<String>): Int {
        parseInput(input)
        headLocation = Position(x = 0, y = 0)
        tailLocation = Position(x = 0, y = 0)

        moves.forEach {
            (0 until it.spaces).forEach { cur ->
                headLocation.processMove(Move(direction = it.direction, spaces = 1))
                val tailMove = headLocation.calculateTailMove(tailLocation)
                tailLocation.processMove(tailMove)
            }
        }
        return tailLocation.history.size
    }

    fun problemTwo(input: List<String>): Int {
        parseInput(input)
        headLocation = Position(x = 0, y = 0)
        tailLocation = Position(x = 0, y = 0)

        val rootNode = Knot(position = Position(x = 0, y = 0), index = 0)
        val rope = Rope(rootNode)

        (1..9).forEach {
            val newNode = Knot(Position(x = 0, y = 0), index = it)
            rope.add(newNode)
        }


        moves.forEach {
            (0 until it.spaces).forEach { cur ->
                var currentNode = rootNode
                currentNode.position.processMove(Move(direction = it.direction, spaces = 1))
                while (currentNode.hasNext()) {
                    val tailMove = currentNode.position.calculateTailMove(currentNode.child!!.position)
                    currentNode.child!!.position.processMove(tailMove)
                    currentNode = currentNode.child!!
                }
            }
        }
        return rope.tail.position.history.size
    }
}


fun main() {
    val input = FileInput().get("src/main/kotlin/twentytwentytwo/inputs/day9.txt")
    val solver = Day9()
    println("Problem one: ${solver.problemOne(input)}")
    println("Problem two: ${solver.problemTwo(input)}")
}

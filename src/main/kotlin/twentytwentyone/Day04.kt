package twentytwentyone

import common.FileInput


class Day04 {

    data class Game(
        val moves: List<Int>,
        val boards: List<Board>
    ) {
        companion object Factory {
            fun parse(input: List<String>): Game {

                val inputCopy = input.toMutableList()

                val moves = inputCopy
                    .removeFirst()
                    .split(",")
                    .map(Integer::parseInt)

                val boards: MutableList<Board> = mutableListOf()

                while (inputCopy.size > 0) {
                    // throw away space
                    inputCopy.removeFirst()

                    val board = Board()
                    for (j in 0 until 5) {
                        board.populateRow(j, inputCopy.removeFirst().toString())
                    }
                    boards.add(board)
                }
                return Game(
                    moves = moves,
                    boards = boards
                )
            }
        }
    }

    data class BingoNode(
        val value: Int,
        var marked: Boolean = false
    )

    data class Board(
        private val rows: MutableMap<Int, MutableList<BingoNode>> = mutableMapOf(),
        private val columns: MutableMap<Int, MutableList<BingoNode>> = mutableMapOf(),
        var inPlay: Boolean = true
    ) {
        fun populateRow(index: Int, row: String) {
            val values = row
                .replace("  ", " ")
                .trim()
                .split(" ")
                .map(Integer::parseInt)

            val row: MutableList<BingoNode> = mutableListOf()
            for ((i, value) in values.withIndex()) {
                val node = BingoNode(value = value)
                row.add(node)

                val cols = columns.getOrDefault(i, mutableListOf())
                cols.add(index, node)
                columns[i] = cols
            }
            rows[index] = row
        }

        fun markPlace(value: Int) {
            rows.forEach { row ->
                row.value.map { t ->
                    if (t.value == value) t.marked = true
                }
            }
            columns.forEach { row ->
                row.value.map { t ->
                    if (t.value == value) t.marked = true
                }
            }
        }

        fun isAWinner(): Boolean {
            for (i in 0 until 5) {
                if (rows[i]?.count { t -> t.marked } == 5) return true
                if (columns[i]?.count { t -> t.marked } == 5) return true
            }
            return false
        }

        fun unmarkedScore(): Int {
            return rows.map { row ->
                row.value.filter { !it.marked }.sumOf { t -> t.value }
            }.sumOf { it }
        }
    }


    fun problemOne(input: List<String>): Int {
        val game = Game.parse(input as MutableList<String>)

        for (move in game.moves) {
            game.boards.forEach {
                it.markPlace(move)
                if (it.isAWinner() && it.inPlay) {
                    return it.unmarkedScore() * move
                }
            }
        }
        return 0
    }

    fun problemTwo(input: List<String>): Int {
        val game = Game.parse(input as MutableList<String>)
        var score = 0

        for (move in game.moves) {
            game.boards.forEach {
                it.markPlace(move)
                if (it.isAWinner() && it.inPlay) {
                    score = it.unmarkedScore() * move
                    it.inPlay = false
                }
            }
        }
        return score
    }
}


fun main() {
    val input = FileInput().get("src/main/kotlin/twentytwentyone/inputs/day04.txt")
    val solver = Day04()
    println("Problem one: ${solver.problemOne(input)}")
    println("Problem two: ${solver.problemTwo(input)}")
}


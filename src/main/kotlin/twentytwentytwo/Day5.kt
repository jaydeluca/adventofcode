package twentytwentytwo

import common.FileInput


class Day5 {
    data class Move(val quantity: Int, val startIndex: Int, val destinationIndex: Int)

    private val stacks = mutableMapOf<Int, ArrayDeque<String>>()
    private var moves = listOf<Move>()

    private fun parseInput(input: List<String>) {
        var splitIndex = 0
        var containerCount = 0
        input.forEachIndexed { index, line ->
            if (line.trim().startsWith("1")) {
                splitIndex = index
                containerCount = Integer.parseInt(line.trim().last().toString())
                return@forEachIndexed
            }
        }

        val containers = input.take(splitIndex).map {
            it
                .chunked(4)
                .map(String::trim)
        }

        for (i in 1..containerCount) {
            stacks[i] = ArrayDeque()
        }
        containers.forEach {
            it.forEachIndexed { index, item ->
                if (item.isNotEmpty()) {
                    stacks[index + 1]?.add(
                        item.replace("[", "")
                            .replace("]", "")
                    )
                }
            }
        }
        this.moves = input.takeLast(input.size - splitIndex - 1)
            .filter { it.isNotEmpty() }.map {
                val split = it.split("from ")
                val split2 = split[1].split(" to ")
                Move(
                    quantity = split[0].replace("move ", "").trim().toInt(),
                    startIndex = split2[0].toInt(),
                    destinationIndex = split2[1].toInt(),
                )
            }
    }


    fun problemOne(input: List<String>): String {
        parseInput(input)
        this.moves.forEach {
            for (i in 0 until it.quantity) {
                val box = this.stacks[it.startIndex]!!.removeFirst()
                this.stacks[it.destinationIndex]!!.addFirst(box)
            }
        }
        return this.stacks.values.joinToString(separator = "") { it.removeFirst() }
    }

    fun problemTwo(input: List<String>): String {
        parseInput(input)
        this.moves.forEach {
            val boxesToMove = mutableListOf<String>()
            for (i in 0 until it.quantity) {
                boxesToMove.add(this.stacks[it.startIndex]!!.removeFirst())
            }
            boxesToMove.reverse()
            boxesToMove.forEach { box ->
                this.stacks[it.destinationIndex]!!.addFirst(box)
            }
        }
        return this.stacks.values.joinToString(separator = "") { it.removeFirst() }
    }
}


fun main() {
    val input = FileInput().get("src/main/kotlin/twentytwentytwo/inputs/day5.txt")
    val solver = Day5()
    println("Problem one: ${solver.problemOne(input)}")
    println("Problem two: ${solver.problemTwo(input)}")
}

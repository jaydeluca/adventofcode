package twentytwentytwo

import common.FileInput


class Day8 {

    private var grid: MutableList<MutableList<Int>> = mutableListOf()

    private fun parseInput(input: List<String>) {
        input.map { row ->
            row.map { column ->
                Integer.parseInt(column.toString())
            }.toList()
        }.toList().also { this.grid = it as MutableList<MutableList<Int>> }
    }


    fun problemOne(input: List<String>): Int {
        parseInput(input)
        var initialCount = 0

        // check from left to right
        this.grid.forEach {
            var highest = it[0]

            (1 until it.size).forEach { cur ->
                if (it[cur] > highest) {
                    initialCount++
                    highest = it[cur]
                }
            }
        }

        // right to left
        this.grid.reversed().forEach {
            var highest = it[0]
            (1 until it.size).forEach { cur ->
                if (it[cur] > highest) {
                    initialCount++
                    highest = it[cur]
                }
            }

            it.forEach { item ->
                if (item > highest) {
                    initialCount++
                    highest = item
                }
            }
        }

        // top to bottom
        (0 until grid.size).forEach {
            var highest = grid[it][0]
            this.grid.forEach { value ->
                if (value[it] > highest) {
                    initialCount++
                    highest = value[it]
                }
            }
        }

        // bottom to top
        (0 until grid.size).forEach {
            var highest = grid[it].last()
            this.grid.reversed().forEach { value ->
                if (value[it] > highest) {
                    initialCount++
                    highest = value[it]
                }
            }
        }

        return initialCount

    }

    fun problemTwo(input: List<String>): Int {
        return 1
    }

}


fun main() {
    val input = FileInput().get("src/main/kotlin/twentytwentytwo/inputs/day8.txt")
    val solver = Day8()
    println("Problem one: ${solver.problemOne(input)}")
    println("Problem two: ${solver.problemTwo(input)}")
}

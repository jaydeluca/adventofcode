package twentytwentyone

import common.FileInput


class Day11 {

    data class Octopus(
        var value: Int,
        var isFlashing: Boolean = false
    )

    class Cavern(
        var gridItems: List<MutableList<Octopus>> = List(10) { mutableListOf() },
        var flashes: Int = 0,
        var flashingList: MutableList<Pair<Int, Int>> = mutableListOf()
    ) {
        companion object Factory {
            fun parse(input: List<String>): Cavern {
                val cavern = Cavern()
                input.forEachIndexed { index, line ->
                    line
                        .toCharArray()
                        .map(Char::digitToInt)
                        .forEach { num ->
                            cavern.gridItems[index].add(Octopus(value = num))
                        }
                }
                return cavern
            }
        }

        private fun printCavern() {
            gridItems.forEach {
                it.forEach { oct -> print(oct.value) }
                println()
            }
            println()
        }

        private fun processOctupus(x: Int, y: Int) {
            if (flashingList.contains(Pair(x, y))) return

            gridItems[x][y].value += 1

            if (gridItems[x][y].value > 9) {
                gridItems[x][y].value = 0
                flashes++
                flashContagion(x, y)
                flashingList.add(Pair(x, y))
            }
        }


        private fun flashContagion(x: Int, y: Int) {
            if (flashingList.contains(Pair(x, y))) return
            if (gridItems[x][y].value < 10) return

            gridItems[x][y].value = 0
            flashes++
            flashingList.add(Pair(x, y))

            // left side
            if (y > 0) {
                processOctupus(x, y - 1)
            }

            // right side
            if (y < 9) {
                processOctupus(x, y + 1)
            }

            // top left
            if (x > 0 && y > 0) {
                processOctupus(x - 1, y - 1)
            }

            // top mid
            if (x > 0) {
                processOctupus(x - 1, y)
            }

            // top right
            if (x > 0 && y < 9) {
                processOctupus(x - 1, y + 1)
            }

            // bottom left
            if (y > 0 && x < 9) {
                processOctupus(x + 1, y - 1)
            }

            // bottom mid
            if (x < 9) {
                processOctupus(x + 1, y)
            }

            // bottom right
            if (y < 9 && x < 9) {
                processOctupus(x + 1, y + 1)
            }
        }


        fun step() {
            flashingList = mutableListOf()
            var turns = 0
            increaseAllByOne()
            for (x in gridItems.indices) {
                for (y in 0..9) {
                    turns++
                    flashContagion(x, y)
                }
            }
            printCavern()
        }

        private fun increaseAllByOne() {
            for ((x, item) in gridItems.withIndex()) {
                for ((y, octopus) in item.withIndex()) {
                    gridItems[x][y].value = octopus.value.inc()
                }
            }
        }
    }


    fun problemOne(input: List<String>): Int {
        val cavern = Cavern.parse(input)

        for (i in 0..99) {
            cavern.step()
        }

        return cavern.flashes
    }

    fun problemTwo(input: List<String>): Int {
        return 0
    }
}


fun main() {
    val input = FileInput().get("src/main/kotlin/twentytwentyone/inputs/day11.txt")
    val solver = Day11()
    println("Problem one: ${solver.problemOne(input)}")
    println("Problem two: ${solver.problemTwo(input)}")
}


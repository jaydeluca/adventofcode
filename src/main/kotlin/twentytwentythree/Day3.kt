package twentytwentythree

import common.FileInput


data class Day3(
    val inputs: List<String>
) {

    private val symbols = mutableMapOf<Char, MutableList<Pair<Int, Int>>>()

    fun checkIsSymbol(x: Int, y: Int): Boolean {
        if (x < 0 || y < 0 || y > inputs.size - 1 || x > inputs[y].length - 1) return false
        val isSymbol = !inputs[y][x].isDigit() && inputs[y][x].toString() != "."

        if (isSymbol) {
            if (checkIsSymbol(x - 1, y)) {
                symbols.computeIfAbsent(inputs[x-1][y]) { mutableListOf() }.add(Pair(x, y))
            }
        }
        return isSymbol
    }


    private fun hasAdjacency(x: Int, y: Int): Boolean {
        return (
            // check same line, either side
            checkIsSymbol(x - 1, y) ||
            checkIsSymbol(x + 1, y) ||

            // check above
            checkIsSymbol(x - 1, y - 1) ||
            checkIsSymbol(x, y - 1) ||
            checkIsSymbol(x + 1, y - 1) ||

            // check below
            checkIsSymbol(x - 1, y + 1) ||
            checkIsSymbol(x, y + 1) ||
            checkIsSymbol(x + 1, y + 1)
        )
    }


    fun partOneProcessLine(y: Int): Int {
        var currentNumberString = ""
        val shouldCount = mutableListOf<Int>()
        var oneOreMoreAdjacent = false

        inputs[y].forEachIndexed { x, character ->
            if (character.isDigit()) {
                currentNumberString += character
                if (hasAdjacency(x, y)) {
                  oneOreMoreAdjacent = true
                }
            }
            // reset if no longer a number
            if ((!character.isDigit() && currentNumberString !== "") || x == inputs[y].length - 1) {
                if (oneOreMoreAdjacent) {
                    shouldCount.add(currentNumberString.toInt())
                }
                oneOreMoreAdjacent = false
                currentNumberString = ""
            }
        }
        return shouldCount.sum()
    }

    private val gearMap = mutableMapOf<Pair<Int, Int>, MutableList<Int>>()

    fun partTwoProcessLine(y: Int) {
        var currentNumberString = ""
        val gears = mutableSetOf<Pair<Int, Int>>()

        inputs[y].forEachIndexed { x, character ->
            if (character.isDigit()) {
                currentNumberString += character
                if (hasAdjacency(x, y)) {
                    gears.add(Pair(x, y))
                }
            }
            // reset if no longer a number
            if ((!character.isDigit() && currentNumberString !== "") || x == inputs[y].length - 1) {
//                if (currentNumberString !== "") {
////                    gears.forEach {
////                        gearMap.computeIfAbsent(it) { mutableListOf() }.add(currentNumberString.toInt())
////                    }
//                }

                currentNumberString = ""
            }
        }
    }

    fun problemOne(): Int {
        return inputs.indices.sumOf { partOneProcessLine(it) }
    }

    fun problemTwo(): Int {
        inputs.indices.forEach{
            partTwoProcessLine(it)
        }
        val gears = gearMap.filter { it.value.size == 2 }
        return gears.map { it.value }.map { it.reduce{x, y -> x * y}}.sum()
    }
}


fun main() {
    val input = FileInput().get("src/main/kotlin/twentytwentythree/inputs/day3.txt")
    val solver = Day3(input)
    println("Problem one: ${solver.problemOne()}")
    println("Problem two: ${solver.problemTwo()}")
}

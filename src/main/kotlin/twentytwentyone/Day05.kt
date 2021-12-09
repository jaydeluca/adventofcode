package twentytwentyone

import common.FileInput


class Day05 {

    private fun parseInputs(input: List<String>): List<List<Pair<Int, Int>>> =
        input.map {
            it.split(" -> ")
                .map { p ->
                    val cut = p.split(",")
                    Pair(cut[0].toInt(), cut[1].toInt())
                }
        }

    private fun generateRange(x1: Int, x2: Int): List<Int> {
        val result = mutableListOf<Int>()
        for (i in minOf(x1, x2)..maxOf(x1, x2)) {
            result.add((i))
        }
        return result
    }

    fun problemOne(input: List<String>): Int {
        val matrix = HashMap<Int, HashMap<Int, Int>>()
        val dangerZones = mutableSetOf<Pair<Int, Int>>()
        val parsedInput = parseInputs(input)

        parsedInput
            .filter { it[0].first == it[1].first || it[0].second == it[1].second }
            .forEach {
                val xRange = generateRange(it[0].first, it[1].first)
                val yRange = generateRange(it[0].second, it[1].second)
                for (x in xRange) {
                    if (!matrix.containsKey(x)) matrix[x] = hashMapOf()
                    for (y in yRange) {
                        var value = matrix[x]!!.getOrDefault(y, 0) + 1
                        matrix[x]!![y] = value
                        if (value > 1) dangerZones.add(Pair(x, y))
                    }
                }
            }

        return dangerZones.size
    }

    fun problemTwo(input: List<String>): Int {
        val matrix = HashMap<Int, HashMap<Int, Int>>()
        val dangerZones = mutableSetOf<Pair<Int, Int>>()
        val parsedInput = parseInputs(input)

        parsedInput.forEach {
            val xRange = generateRange(it[0].first, it[1].first)
            val yRange = generateRange(it[0].second, it[1].second)
            for (x in xRange) {
                if (!matrix.containsKey(x)) matrix[x] = hashMapOf()
                for (y in yRange) {
                    var value = matrix[x]!!.getOrDefault(y, 0) + 1
                    matrix[x]!![y] = value
                    if (value > 1) dangerZones.add(Pair(x, y))
                }

            }
        }

        for (x in matrix) {
            for (i in x.value) {
                print(i.value)
            }
            println()
        }


        return dangerZones.size
    }
}


fun main() {
    val input = FileInput().get("src/main/kotlin/twentytwentyone/inputs/day05.txt")
    val solver = Day05()
    println("Problem one: ${solver.problemOne(input)}")
    println("Problem two: ${solver.problemTwo(input)}")
}


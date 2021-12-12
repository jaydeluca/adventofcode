package twentytwentyone

import common.FileInput
import kotlin.math.absoluteValue

class Day05 {

    private fun parseInputs(input: List<String>): List<Line> =
        input.map {
            it
                .split(" -> ")
                .map { p -> p.split(",").map(String::toInt) }
                .map { (x, y) ->
                    Pair(x, y)
                }
        }.map { (p1, p2) -> Line(start = p1, end = p2) }

    data class Line(val start: Pair<Int, Int>, val end: Pair<Int, Int>) {
        private fun generateRange(x1: Int, x2: Int): IntProgression {
            return if (x1 <= x2) x1..x2 else x1 downTo x2
        }

        fun isVertical() = start.first == end.first
        fun isHorizontal() = start.second == end.second
        fun isDiagonal() =
            (start.first - end.first).absoluteValue == (start.second - end.second).absoluteValue

        fun xRange() = generateRange(this.start.first, this.end.first)
        fun yRange() = generateRange(this.start.second, this.end.second)
    }

    fun problemOne(input: List<String>): Int {
        val matrix = HashMap<Int, HashMap<Int, Int>>()
        val dangerZones = mutableSetOf<Pair<Int, Int>>()
        val parsedInput = parseInputs(input)

        parsedInput
            .filter { it.isVertical() || it.isHorizontal() }
            .forEach {
                for (x in it.xRange()) {
                    if (!matrix.containsKey(x)) matrix[x] = hashMapOf()
                    for (y in it.yRange()) {
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

        parsedInput
            .filter { it.isHorizontal() || it.isVertical() || it.isDiagonal() }
            .forEach {
                for (x in it.xRange()) {
                    if (!matrix.containsKey(x)) matrix[x] = hashMapOf()
                    for (y in it.yRange()) {
                        var value = matrix[x]!!.getOrDefault(y, 0) + 1
                        matrix[x]!![y] = value
                        if (value > 1) dangerZones.add(Pair(x, y))
                    }
                }
            }

//        for (x in matrix) {
//            for (i in x.value) {
//                print(i.value)
//            }
//            println()
//        }

        return dangerZones.size
    }
}


fun main() {
    val input = FileInput().get("src/main/kotlin/twentytwentyone/inputs/day05.txt")
    val solver = Day05()
    println("Problem one: ${solver.problemOne(input)}")
    // incomplete
//    println("Problem two: ${solver.problemTwo(input)}")
}


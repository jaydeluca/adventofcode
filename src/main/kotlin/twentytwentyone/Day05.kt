package twentytwentyone

import common.FileInput

class Day05 {

    private fun parseInputs(input: List<String>): List<Line> =
        input.map {
            it
                .split(" -> ")
                .map { p -> p.split(",").map(String::toInt) }
                .map { (x, y) ->
                    Point(x, y)
                }
        }.map { (p1, p2) -> Line(start = p1, end = p2) }

    data class Point(
        val x: Int,
        val y: Int
    )

    data class Line(val start: Point, val end: Point) {
        private fun generateRange(x1: Int, x2: Int): IntProgression {
            return if (x1 <= x2) x1..x2 else x1 downTo x2
        }

        fun isVertical() = start.x == end.x
        fun isHorizontal() = start.y == end.y

        private fun xRange() = generateRange(this.start.x, this.end.x)
        private fun yRange() = generateRange(this.start.y, this.end.y)

        fun generatePoints(): Set<Point> {
            return if (isVertical() || isHorizontal()) {
                xRange().map { x ->
                    yRange().map { y ->
                        Point(x, y)
                    }
                }.flatten().toSet()
            } else {
                xRange().zip(yRange()).map { Point(it.first, it.second) }.toSet()
            }
        }
    }

    fun problemOne(input: List<String>): Int {
        val matrix = HashMap<Int, HashMap<Int, Int>>()
        val dangerZones = mutableSetOf<Point>()

        parseInputs(input)
            .filter { it.isVertical() || it.isHorizontal() }
            .forEach {
                it.generatePoints().forEach { point ->
                    if (!matrix.containsKey(point.x)) matrix[point.x] = hashMapOf()
                    var value = matrix[point.x]!!.getOrDefault(point.y, 0) + 1
                    matrix[point.x]!![point.y] = value
                    if (value > 1) dangerZones.add(point)
                }
            }

        return dangerZones.size
    }

    fun problemTwo(input: List<String>): Int {
        val matrix = HashMap<Int, HashMap<Int, Int>>()
        val dangerZones = mutableSetOf<Point>()
        parseInputs(input)
            .forEach {
                it.generatePoints().forEach { point ->
                    if (!matrix.containsKey(point.x)) matrix[point.x] = hashMapOf()
                    var value = matrix[point.x]!!.getOrDefault(point.y, 0) + 1
                    matrix[point.x]!![point.y] = value
                    if (value > 1) dangerZones.add(point)
                }
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


package twentytwentyone

import common.FileInput

class Day09 {

    data class Point(
        val value: Int,
        var isLowest: Boolean = false
    )

    fun checkLowest(x: Int, y: Int, heightMap: List<List<Point>>): Boolean {
        val cur = heightMap[x][y].value
        var isLowest = true

        // left side
        if (x > 0) {
            if (heightMap[x-1][y].value < cur) return false
        }

        // top
        if (y > 0) {
            if (heightMap[x][y-1].value < cur) return false
        }

        //  right side
        if (x < heightMap.size-1) {
            if (heightMap[x+1][y].value < cur) return false
        }

        // bottom
        if (y < heightMap[x].size-1) {
            if (heightMap[x][y+1].value < cur) return false
        }

        return isLowest
    }


    fun parseInput(input: List<String>) = input.map { x ->
        x.map {
            Point(value = it.digitToInt())
        }
    }

    fun problemOne(input: List<String>): Int {
        val heightMap = parseInput(input)

        val result = heightMap.mapIndexed { x, col ->
            col.mapIndexed{ y, point ->
                point.isLowest = checkLowest(x, y, heightMap)
                point
            }
        }

        return result
            .flatten()
            .filter(Point::isLowest)
            .sumOf { it.value + 1 }
    }

    fun problemTwo(input: List<String>): Int {
        return 0
    }
}


fun main() {
    val input = FileInput().get("src/main/kotlin/twentytwentyone/inputs/day09.txt")
    val solver = Day09()

    println("Problem one: ${solver.problemOne(input)}")
    println("Problem two: ${solver.problemTwo(input)}")
}


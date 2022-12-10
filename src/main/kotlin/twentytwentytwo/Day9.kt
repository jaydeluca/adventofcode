package twentytwentytwo

import common.FileInput


class Day9 {
    fun problemOne(input: List<String>) : Int {
        return 1
    }

    fun problemTwo(input: List<String>) : Int {
        return 1
    }
}


fun main() {
    val input = FileInput().get("src/main/kotlin/twentytwentytwo/inputs/day9.txt")
    val solver = Day9()
    println("Problem one: ${solver.problemOne(input)}")
    println("Problem two: ${solver.problemTwo(input)}")
}

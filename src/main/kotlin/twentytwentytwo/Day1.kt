package twentytwentytwo

import common.FileInput


class Day1 {
    fun problemOne(input: List<String>) : Int {
        return 1
    }

    fun problemTwo(input: List<String>) : Int {
        return 1
    }
}


fun main() {
    val input = FileInput().get("src/main/kotlin/twentytwentytwo/inputs/day1.txt")
    val solver = Day1()
    println("Problem one: ${solver.problemOne(input)}")
    println("Problem two: ${solver.problemTwo(input)}")
}

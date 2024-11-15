package twentytwentyfour

import common.FileInput


class Day01 {
    fun problemOne(input: List<String>) : Int {
        return 1
    }

    fun problemTwo(input: List<String>) : Int {
        return 1
    }
}


fun main() {
    val input = FileInput().get("src/main/kotlin/twentytwentyfour/inputs/day01.txt")
    val solver = Day01()
    println("Problem one: ${solver.problemOne(input)}")
    println("Problem two: ${solver.problemTwo(input)}")
}

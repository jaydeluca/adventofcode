package twentytwentytwo

import common.FileInput


class Day1 {

    private fun calculateCalories(input: List<String>): List<Int> {
        val list = mutableListOf<Int>()
        var currentTotal = 0
        input.forEachIndexed { index, it ->
            if (it == "") {
                list.add(currentTotal)
                currentTotal = 0
            } else if (index == input.size - 1) {
                list.add(it.toInt())
            } else {
                currentTotal += it.toInt()
            }
        }
        return list
    }

    fun problemOne(input: List<String>) : Int? {
        return calculateCalories(input).maxOrNull()
    }

    fun problemTwo(input: List<String>) : Int {
        return calculateCalories(input)
            .sortedDescending()
            .take(3)
            .sum()
    }
}

fun main() {
    val input = FileInput().get("src/main/kotlin/twentytwentytwo/inputs/day1.txt")
    val solver = Day1()
    println("Problem one: ${solver.problemOne(input)}")
    println("Problem two: ${solver.problemTwo(input)}")
}

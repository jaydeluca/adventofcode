package twentytwentyfour

import common.FileInput
import kotlin.math.abs


class Day01 {

    fun parseInput(input: List<String>): Pair<List<Int>, List<Int>> {
        val list1 = mutableListOf<Int>()
        val list2 = mutableListOf<Int>()
        input.forEach {
            val split = it.split("   ")
            list1.add(split[0].toInt())
            list2.add(split[1].toInt())
        }
        return Pair(list1, list2)
    }

    fun problemOne(input: List<String>) : Int {
        val lists = parseInput(input)

        var distance = 0
        val list1 = lists.first.sorted()
        val list2 = lists.second.sorted()
        list1.forEachIndexed { index, i ->
            distance += abs(i - list2[index])
        }

        return distance
    }

    fun problemTwo(input: List<String>) : Int {
        val lists = parseInput(input)
        val numberFrequency: MutableMap<Int, Int> = mutableMapOf()

        lists.second.forEach {
            numberFrequency[it] = numberFrequency.getOrDefault(it, 0) + 1
        }

        return lists.first.sumOf { i ->
            if (numberFrequency.containsKey(i)) {
                numberFrequency[i]?.times(i) ?: 0
            } else {
                0
            }
        }
    }
}


fun main() {
    val input = FileInput().get("src/main/kotlin/twentytwentyfour/inputs/day01.txt")
    val solver = Day01()
    println("Problem one: ${solver.problemOne(input)}")
    println("Problem two: ${solver.problemTwo(input)}")
}

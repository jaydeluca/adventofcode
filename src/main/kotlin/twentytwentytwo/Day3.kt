package twentytwentytwo

import common.FileInput


class Day3 {
    data class Rucksack(val compartments: List<Set<Char>>) {
        fun findCommonPriority(): Int {
            val compare = compartments.reduce { acc: Set<Char>, set: Set<Char> ->
                acc.intersect(set)
            }
            return if (compare.first().isUpperCase()) {
                compare.first().code - 38
            } else {
                compare.first().code - 96
            }
        }
    }

    fun problemOne(input: List<String>): Int {
        return input.map {
            val split = it.chunked(it.length / 2)
            Rucksack(
                compartments = listOf(
                    split[0].toSet(),
                    split[1].toSet()
                )
            )
        }.sumOf { it.findCommonPriority() }
    }

    fun problemTwo(input: List<String>): Int {
        return input.chunked(3).map {
            Rucksack(compartments = it.map { item -> item.toSet() })
        }.sumOf { it.findCommonPriority() }
    }
}

fun main() {
    val input = FileInput().get("src/main/kotlin/twentytwentytwo/inputs/day3.txt")
    val solver = Day3()
    println("Problem one: ${solver.problemOne(input)}")
    println("Problem two: ${solver.problemTwo(input)}")
}

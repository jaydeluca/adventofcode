package twentytwentyone

import common.FileInput

class Day08 {

    data class Display(
        val signals: List<String>,
        val output: List<String>,
    ) {
        companion object Factory {
            fun parse(input: List<String>): List<Display> {
                return input.map {
                    val cut = it.split("|")
                    Display(
                        signals = cut[0].trim().split(" ").sortedBy(String::length),
                        output = cut[1].trim().split(" "),
                    )
                }
            }
        }
    }

    fun problemOne(input: List<String>): Int {
        val targets = listOf(2, 3, 4, 7)
        val display = Display.parse(input)
        return display.sumOf {
            it
                .output
                .map(String::length)
                .filter(targets::contains)
                .size
        }
    }

    fun problemTwo(input: List<String>): Int {
        return 0
    }
}


fun main() {
    val input = FileInput().get("src/main/kotlin/twentytwentyone/inputs/day08.txt")
    val solver = Day08()
    println("Problem one: ${solver.problemOne(input)}")
    println("Problem two: ${solver.problemTwo(input)}")
}


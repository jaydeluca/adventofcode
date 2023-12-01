package twentytwentythree

import common.FileInput
import java.lang.Double.parseDouble
import java.lang.StringBuilder


class Day1 {
    private val characterMap = mapOf(
        "one" to 1,
        "two" to 2,
        "three" to 3,
        "four" to 4,
        "five" to 5,
        "six" to 6,
        "seven" to 7,
        "eight" to 8,
        "nine" to 9
    )

    // for each line, start at each end and traverse until finding a character
    private fun parseLine(input: String): Int {
        var left: Char? = null
        var right: Char? = null
        for (i in input.indices) {
            if (input[i].isDigit() && left == null) {
                left = input[i]
            }
            if (input[input.length-1-i].isDigit() && right == null) {
                right = input[input.length-1-i]
            }
            if (left != null && right != null) break
        }
        return parseDouble(StringBuilder().append(left).append(right).toString()).toInt()
    }

    fun convertLineToNumeric(input: String): String {
        // iterate through all characters, see if they form a number, append if so
        var result = ""
        for (i in input.indices) {
            var currentWord = ""
            if (input[i].isDigit()) {
                result += input[i]
                continue
            }
            // max length of a numeric word is 5
            for (j in 0 until 5) {
                if (i+j > input.length - 1) break
                currentWord += input[i+j]
                if (characterMap.keys.contains(currentWord)) {
                    result += characterMap[currentWord]
                }
            }
        }
        return result
    }

    fun problemOne(input: List<String>) : Int {
        return input.sumOf {
            parseLine(it)
        }
    }

    fun problemTwo(input: List<String>) : Int {
        return input.map { convertLineToNumeric(it)}.sumOf { parseLine(it) }
    }
}


fun main() {
    val input = FileInput().get("src/main/kotlin/twentytwentythree/inputs/day1.txt")
    val solver = Day1()
    println("Problem one: ${solver.problemOne(input)}")
    println("Problem two: ${solver.problemTwo(input)}")
}

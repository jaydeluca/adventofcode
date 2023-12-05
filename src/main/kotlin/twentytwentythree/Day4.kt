package twentytwentythree

import common.FileInput


class Day4 {
    fun problemOne(input: List<String>) : Int {
        return input.map { line ->
            val lists = line.split(": ")[1].split(" | ")
            val winners = lists[0].split("\\s+".toRegex()).filter { it.isNotEmpty() }
            val numbers = lists[1].split("\\s+".toRegex()).filter { it.isNotEmpty() }
            val matches = numbers.filter { winners.contains(it) }

            var points = 0
            matches.forEach { _ ->
                if (points == 0) {
                    points = 1
                } else {
                    points *= 2
                }
            }
            points
        }.sum()
    }

    fun processCardStack(originalStack: List<String>, input: List<String>, total: Int): Int {
        if (input.isEmpty()) return total
        val newCards = mutableListOf<String>()
        var localTotal = 0
        input.map { line ->
            localTotal++
            val card = line.split(": ")
            val cardNumber = Regex("""\d+""").find(card[0])?.value!!.toInt()
            val lists = card[1].split(" | ")
            val winners = lists[0].split("\\s+".toRegex()).filter { it.isNotEmpty() }
            val numbers = lists[1].split("\\s+".toRegex()).filter { it.isNotEmpty() }
            numbers.filter { winners.contains(it) }.forEachIndexed{ i, _ ->
                newCards.add(originalStack[cardNumber + i])
            }
        }
        return processCardStack(originalStack, newCards, total+localTotal)
    }

    fun problemTwo(input: List<String>) : Int {
        return processCardStack(input, input, 0)
    }
}


fun main() {
    val input = FileInput().get("src/main/kotlin/twentytwentythree/inputs/day4.txt")
    val solver = Day4()
    println("Problem one: ${solver.problemOne(input)}")
    println("Problem two: ${solver.problemTwo(input)}")
}

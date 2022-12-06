package twentytwentytwo

import common.FileInput


class Day6 {
    fun problemOne(input: String) : Int {
        val queue = ArrayDeque<Char>()
        var iterator = 1
        input.forEach {
            if (iterator > 4) {
                if (queue.toList().distinct().size > 3) {
                    return iterator - 1
                }
                queue.removeFirst()
            }
            queue.addLast(it)
            iterator++
        }
        return 1
    }

    fun problemTwo(input: String) : Int {
        val queue = ArrayDeque<Char>()
        var iterator = 1
        input.forEach {
            if (iterator > 14) {
                if (queue.toList().distinct().size > 13) {
                    return iterator - 1
                }
                queue.removeFirst()
            }
            queue.addLast(it)
            iterator++
        }
        return 1
    }
}


fun main() {
    val input = FileInput().get("src/main/kotlin/twentytwentytwo/inputs/day6.txt")
    val solver = Day6()
    println("Problem one: ${solver.problemOne(input[0])}")
    println("Problem two: ${solver.problemTwo(input[0])}")
}

package twentytwentytwo

import common.FileInput


class Day10 {
    class CRT {
        var items = mutableListOf<String>()

        fun print(): String {
            return items.chunked(40).joinToString("\n") { it.joinToString("") }
        }
    }

    class CPU {
        var x = 1
        private var cycle = 0
        private val intervalCollection = mutableListOf<Int>()
        private var currentRow = 0
        val crt = CRT()

        fun processInput(input: List<String>) {
            input.forEach {
                val split = it.split(" ")
                if (split[0] == "noop") {
                    processMove(1, 0)
                } else {
                    processMove(2, Integer.parseInt(split[1]))
                }
            }
        }

        private fun processMove(cycles: Int, addX: Int) {
            (0 until cycles).forEach { _ ->
                val rowPosition = cycle % 40

                if ((cycle % 40) in (IntRange(x - 1, x + 1))) {
                    crt.items.add("#")
                } else {
                    crt.items.add(".")
                }

                cycle++
                if ((cycle - 20) % 40 == 0) {
                    intervalCollection.add(x * cycle)
                }

                if (rowPosition == 39) currentRow += 1
            }
            this.x += addX
        }

        fun getScore(): Int {
            return this.intervalCollection.sum()
        }

    }


    fun problemOne(input: List<String>): Int {
        val cpu = CPU()
        cpu.processInput(input)
        return cpu.getScore()
    }


    fun problemTwo(input: List<String>) {
        val cpu = CPU()
        cpu.processInput(input)
        print(cpu.crt.print())
    }
}


fun main() {
    val input = FileInput().get("src/main/kotlin/twentytwentytwo/inputs/day10.txt")
    val solver = Day10()
    println("Problem one: ${solver.problemOne(input)}")
    println("Problem two: ")
    solver.problemTwo(input)
}

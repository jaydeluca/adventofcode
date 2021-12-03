package twentytwentyone

import common.FileInput


class Day03 {

    fun problemOne(input: List<String>): Int {

        val bitMap: MutableMap<Int, List<Int>> = hashMapOf()

        input.forEach {
            val bitArray = it.map{ c -> c.digitToInt() }
            for ((index, value) in bitArray.withIndex()) {
                bitMap[index] = bitMap.getOrDefault(index, listOf()).plus(value)
            }
        }

        val gammaRate = bitMap.map{
            it.value
                .groupBy{ t -> t }
                .map { i -> mapOf( i.key to i.value.count()) }
//                .map{ k ->
//                    val highest = k.entries.maxOf{ x -> x.value}
//                    val x = k.entries.filter { it.value == highest }
//                    println("highest $x")
//                    x
//                }
        }

        println(gammaRate)
        return 1

    }

    fun problemTwo(input: List<String>) {
    }
}


fun main() {
    val input = FileInput().get("src/main/kotlin/twentytwentyone/inputs/day03.txt")
    val solver = Day03()
    println("Problem one: ${solver.problemOne(input)}")
//    println("Problem two: ${solver.problemTwo(input)}")
}


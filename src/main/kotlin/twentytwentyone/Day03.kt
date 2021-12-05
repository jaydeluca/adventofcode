package twentytwentyone

import common.FileInput
import java.util.function.BiFunction


class Day03 {
    class OxygenBiFunction : BiFunction<Int, Int, Int> {
        override fun apply(zero: Int, one: Int): Int {
            return if (one == zero) {
                1
            } else if (zero > one) {
                0
            } else {
                1
            }
        }
    }

    class Co2BiFunction : BiFunction<Int, Int, Int> {
        override fun apply(zero: Int, one: Int): Int {
            return if (one == zero) {
                0
            } else if (zero < one) {
                0
            } else {
                1
            }
        }
    }

    private fun maxEntry(entries: List<Map<Int, Int>>): Int? {
        val maxValue = entries.maxOf { it.entries.maxOf { x -> x.value } }
        val entry = entries.filter { it.containsValue(maxValue) }
        return entry.first().entries.first().key
    }

    private fun createBitMap(input: List<String>): MutableMap<Int, List<Int>> {
        val bitMap: MutableMap<Int, List<Int>> = hashMapOf()

        input.forEach {
            val bitArray = it.map { c -> c.digitToInt() }
            for ((index, value) in bitArray.withIndex()) {
                bitMap[index] = bitMap.getOrDefault(index, listOf()).plus(value)
            }
        }
        return bitMap
    }

    private fun calculateRating(
        input: List<String>,
        index: Int,
        winnerFunction: BiFunction<Int, Int, Int>
    ): String {
        if (input.size == 1) return input.first().toString()
        val bitCounts = parseBitCounts(input, index)

        val one = bitCounts.first { it.key == 1 }
        val zero = bitCounts.first { it.key == 0 }

        val survivors = input.filter {
            it[index].toString() == winnerFunction.apply(zero.value, one.value).toString()
        }

        return calculateRating(survivors, index + 1, winnerFunction)
    }

    private fun parseBitCounts(
        input: List<String>, index: Int
    ): List<Map.Entry<Int, Int>> {
        val bitMap = createBitMap(input)
        return bitMap[index]?.let {
            it.groupBy { i -> i }
                .map { i -> mapOf(i.key to i.value.count()) }
                .flatMap { i -> i.entries }
        } ?: listOf()
    }

    fun problemOne(input: List<String>): Int {
        val bitMap = createBitMap(input)

        val data = bitMap.map { it.value }
            .map { t ->
                t.groupBy { t -> t }
                    .map { i -> mapOf(i.key to i.value.count()) }
            }.map { i ->
                val flattened = i.flatMap { x -> x.entries }
                    .map { x -> mapOf(x.key to x.value) }
                if (maxEntry(flattened) == 0) Pair(0, 1) else Pair(1, 0)
            }

        val gammaBinary = data.map { it.first }.joinToString(separator = "")
        val epsilonBinary = data.map { it.second }.joinToString(separator = "")

        val gamma = Integer.parseInt(gammaBinary, 2)
        val epsilon = Integer.parseInt(epsilonBinary, 2)
        return gamma * epsilon
    }

    fun problemTwo(input: List<String>): Int {
        val oxygenRating = calculateRating(input, 0, OxygenBiFunction())
        val oxygenDecimal = Integer.parseInt(oxygenRating, 2)
        val co2Rating = calculateRating(input, 0, Co2BiFunction())
        val co2Decimal = Integer.parseInt(co2Rating, 2)
        return oxygenDecimal * co2Decimal
    }
}


fun main() {
    val input = FileInput().get("src/main/kotlin/twentytwentyone/inputs/day03.txt")
    val solver = Day03()
    println("Problem one: ${solver.problemOne(input)}")
    println("Problem two: ${solver.problemTwo(input)}")
}


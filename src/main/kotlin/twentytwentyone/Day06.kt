package twentytwentyone

import common.FileInput
import java.math.BigInteger


class Day06 {

    data class Puzzle(val lanternFish: MutableMap<Int, BigInteger>) {
        companion object Factory {
            fun parse(input: List<String>): Puzzle {
                val fishList: MutableMap<Int, BigInteger> = mutableMapOf()

                for (i in 0..8) {
                    fishList[i] = BigInteger.ZERO
                }

                input[0].split(",")
                    .groupBy(String::toInt)
                    .forEach {
                        fishList[it.key] = BigInteger.valueOf(it.value.size.toLong())
                    }
                return Puzzle(lanternFish = fishList)
            }
        }

        fun totalFish(): BigInteger = lanternFish.map { it.value }.fold(BigInteger.ZERO, BigInteger::add)

        fun numDaysProceed(days: Int) {
            for (i in 0 until days) {
                val startingZeros = lanternFish[0]

                for (x in 0 until 8) {
                    lanternFish[x] = lanternFish[x + 1]!!
                }
                lanternFish[8] = startingZeros!!
                lanternFish[6] = lanternFish[6]!!.plus(startingZeros)
            }
        }
    }


    fun problemOne(input: List<String>): BigInteger {
        val puzzle = Puzzle.parse(input)
        puzzle.numDaysProceed(80)
        return puzzle.totalFish()
    }

    fun problemTwo(input: List<String>): BigInteger {
        val puzzle = Puzzle.parse(input)
        puzzle.numDaysProceed(256)
        return puzzle.totalFish()
    }
}


fun main() {
    val input = FileInput().get("src/main/kotlin/twentytwentyone/inputs/day06.txt")
    val solver = Day06()
    println("Problem one: ${solver.problemOne(input)}")
    println("Problem two: ${solver.problemTwo(input)}")
}


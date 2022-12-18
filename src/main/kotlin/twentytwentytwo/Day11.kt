package twentytwentytwo

import common.FileInput
import java.util.*

typealias Operation = (x: ULong) -> ULong

class Day11 {

    private fun parseInput(input: List<String>, algoEnabled: Boolean) {
        var currentMonkey = 0
        var currentMonkeyItems = LinkedList<ULong>()
        var currentIfTrue = 0
        var currentIfFalse = 0
        var currentDivisibleBy = 0.toULong()
        var currentOperation: Operation = fun(x: ULong): ULong = x

        for (item in input) {
            if (item == "") {
                addMonkey(
                    currentMonkey = currentMonkey,
                    currentMonkeyItems = currentMonkeyItems,
                    currentOperation = currentOperation,
                    currentDivisibleBy = currentDivisibleBy,
                    currentIfTrue = currentIfTrue,
                    currentIfFalse = currentIfFalse,
                    algoEnabled = algoEnabled
                )
                currentMonkeyItems = LinkedList<ULong>()
                continue
            }

            if (item.trim().startsWith("Monkey")) {
                val split = item.split(" ")
                currentMonkey = Integer.parseInt(split[1].replace(":", ""))
                continue
            }

            if (item.trim().startsWith("Starting")) {
                item
                    .split("Starting items: ")[1]
                    .replace(",", "")
                    .split(" ")
                    .map { Integer.parseInt(it).toULong()}
                    .forEach { currentMonkeyItems.add(it) }
                continue
            }

            if (item.trim().startsWith("Operation:")) {
                val (operation, b) = item
                    .split("Operation: new = old ")[1]
                    .split(" ")

                val isNum = b.all { it.isDigit() }

                currentOperation = if (isNum) {
                    val y = b.toULong()
                    when (operation) {
                        "*" -> fun(x: ULong): ULong = x * y
                        "+" -> fun(x: ULong): ULong = x + y
                        else -> throw RuntimeException()
                    }
                } else {
                    fun(x: ULong): ULong = x * x
                }
                continue
            }

            if (item.trim().startsWith("Test:")) {
                currentDivisibleBy = item
                    .split("Test: divisible by ")[1].toULong()
                continue
            }

            if (item.trim().startsWith("If true:")) {
                currentIfTrue = Integer.parseInt(item
                    .split("If true: throw to monkey ")[1])
                continue
            }

            if (item.trim().startsWith("If false:")) {
                currentIfFalse = Integer.parseInt(item
                    .split("If false: throw to monkey ")[1])
                continue
            }
        }

        addMonkey(
            currentMonkey = currentMonkey,
            currentMonkeyItems = currentMonkeyItems,
            currentOperation = currentOperation,
            currentDivisibleBy = currentDivisibleBy,
            currentIfTrue = currentIfTrue,
            currentIfFalse = currentIfFalse,
            algoEnabled = algoEnabled
        )
    }

    data class MonkeyTest(val divisibleBy: ULong, val ifTrue: Int, val ifFalse: Int)
    private var monkeys = mutableListOf<Monkey>()

    data class Monkey(
        val index: Int,
        val items: Queue<ULong>,
        val operationItems: Operation = fun(x: ULong): ULong = x,
        val test: MonkeyTest,
        var algoEnabled: Boolean = false
    ) {
        var counter = 0

        fun performOperation(): Pair<ULong, Int> {
            val thisItem = items.remove()
            var newItem = operationItems(thisItem)

            if (this.algoEnabled) {
                newItem = kotlin.math.floor((newItem / 3.toULong()).toDouble()).toULong()
            }

            counter++
            return if ((newItem % test.divisibleBy).toInt() == 0) {
                Pair(newItem, test.ifTrue)
            } else {
                Pair(newItem, test.ifFalse)
            }
        }
    }

    private fun addMonkey(
        currentMonkey: Int,
        currentMonkeyItems: Queue<ULong>,
        currentOperation: Operation,
        currentDivisibleBy: ULong,
        currentIfTrue: Int,
        currentIfFalse: Int,
        algoEnabled: Boolean
        ) {
        monkeys.add(Monkey(
            index = currentMonkey,
            items = currentMonkeyItems,
            operationItems = currentOperation,
            test = MonkeyTest(
                divisibleBy = currentDivisibleBy,
                ifTrue = currentIfTrue,
                ifFalse = currentIfFalse
            ),
            algoEnabled = algoEnabled
        ))
    }


    fun problemOne(input: List<String>): Int {
        parseInput(input, true)

        (0 until 20).forEach { _ ->
            this.monkeys.forEach {
                while (it.items.isNotEmpty()) {
                    val result = it.performOperation()
                    this.monkeys[result.second].items.add(result.first)
                }
            }
        }
        return this.monkeys.map { it.counter }.sortedDescending().take(2).reduce{a, b -> a * b}
    }

    fun problemTwo(input: List<String>): ULong {
        parseInput(input, false)

        (0 until 10000).forEach { ctr ->
            this.monkeys.forEach {
                while (it.items.isNotEmpty()) {
                    val result = it.performOperation()
                    this.monkeys[result.second].items.add(result.first)
                }
            }
        }
        val test = this.monkeys.map { it.counter.toULong() }.sortedDescending().take(2)
        val test2: ULong = test.reduce(ULong::times)
        return test2
    }
}


fun main() {
    val input = FileInput().get("src/main/kotlin/twentytwentytwo/inputs/day11.txt")
    val solver = Day11()
    println("Problem one: ${solver.problemOne(input)}")
    println("Problem two: ${solver.problemTwo(input)}")
}

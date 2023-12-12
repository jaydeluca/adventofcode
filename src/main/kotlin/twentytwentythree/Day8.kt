package twentytwentythree

import common.FileInput


class Day8 {

    data class Node(
        val left: String?,
        val right: String?,
        val value: String
    )

    data class Paths(
        val tree: Map<String, Node>,
        val starters: List<String>
    )

    fun parseTree(input: List<String>): Paths {
        val tree = mutableMapOf<String, Node>()
        val starters = mutableListOf<String>()

        input.takeLast(input.size-2).forEach {
            val nodeValue = it.split(" = ")[0]

            if (nodeValue.takeLast(1) == "A") {
                starters.add(nodeValue)
            }

            val leftValue = it.split(" = ")[1].split(", ")[0].replace("(", "")
            val rightValue = it.split(" = ")[1].split(", ")[1].replace(")", "")
            tree[nodeValue] = Node(value = nodeValue, left = leftValue, right = rightValue)
        }
        return Paths(tree=tree, starters=starters)
    }

    fun processMove(move: String, cursor: String, tree: Map<String, Node>): String {
        var newCursor: String? = null
        if (move == "L") {
            tree.get(cursor)!!.left?.let {value ->
                newCursor = value
            }
        }
        else {
            tree.get(cursor)!!.right?.let {value ->
                newCursor = value
            }
        }
        return newCursor!!
    }


    fun problemOne(input: List<String>) : Int {
        val sequence = input[0].toList()
        val tree = parseTree(input).tree

        var steps = 0
        var cursor = "AAA"
        while (cursor != "ZZZ") {
            sequence.forEach {
                steps++
                cursor = processMove(it.toString(), cursor, tree)
            }
        }

        return steps
    }

    fun problemTwo(input: List<String>) : Int {
        val sequence = input[0].toList()
        val paths = parseTree(input)
        val tree = paths.tree
        var steps = 0
        var cursors = paths.starters

        while (true) {
            sequence.forEach {move ->
                cursors = cursors.map { cur ->
                    processMove(move.toString(), cur, tree)
                }
                steps++
                if (cursors.filter { it.endsWith("Z") }.size == cursors.size-1) return steps
            }
        }
    }
}


fun main() {
    val input = FileInput().get("src/main/kotlin/twentytwentythree/inputs/day8.txt")
    val solver = Day8()
    println("Problem one: ${solver.problemOne(input)}")
    println("Problem two: ${solver.problemTwo(input)}")
}

package twentytwentytwo

import common.FileInput


class Day8 {

    private var grid: MutableList<MutableList<Int>> = mutableListOf()

    private fun parseInput(input: List<String>) {
        input.map { row ->
            row.map { column ->
                Integer.parseInt(column.toString())
            }.toMutableList()
        }.toMutableList().also { this.grid = it }
    }

    fun problemOne(input: List<String>): Int {
        parseInput(input)
        var treeCount = (grid.size + grid[0].size) * 2 - 4

        // traverse, skip 0 and last
        (1 until grid.size - 1).map { r ->
            (1 until grid[r].size - 1).forEach { c ->
                val value = grid[r][c]

                val visibleFromTop = (0 until r).map { cur -> grid[cur][c] }.none { it >= value }

                val visibleFromBottom =
                    (grid.size - 1 downTo r + 1).map { cur -> grid[cur][c] }.none { it >= value }

                val visibleFromLeft = (0 until c).map { grid[r][it] }.none { it >= value }

                val visibleFromRight =
                    (grid[r].size - 1 downTo c + 1).map { cur -> grid[r][cur] }.none { it >= value }

                val isVisible = visibleFromTop || visibleFromBottom || visibleFromLeft || visibleFromRight
                if (isVisible) treeCount++
            }
        }
        return treeCount
    }

    fun problemTwo(input: List<String>): Int {
        parseInput(input)
        var highest = 0

        // traverse, skip 0 and last
        (1 until grid.size - 1).map { r ->
            (1 until grid[r].size - 1).forEach { c ->
                val value = grid[r][c]

                var topTrees = 0
                var bottomTrees = 0
                var leftTrees = 0
                var rightTrees = 0

                // top
                run breaking@ {
                    (r - 1 downTo 0).forEach { cur ->
                        topTrees++
                        if (grid[cur][c] >= value) {
                            return@breaking
                        }
                    }
                }

                // check bottom
                run breaking@ {
                    (r+1 until grid.size).forEach { cur ->
                        bottomTrees++
                        if (grid[cur][c] >= value) {
                            return@breaking
                        }
                    }
                }

                // left
                run breaking@ {
                    (c - 1 downTo 0).forEach { cur ->
                        leftTrees++
                        if (grid[r][cur] >= value) {
                            return@breaking
                        }
                    }
                }

                // right
                run breaking@ {
                    (c+1 until grid[0].size).forEach { cur ->
                        rightTrees++
                        if (grid[r][cur] >= value) {
                            return@breaking
                        }
                    }
                }
                val height = listOf(
                    topTrees,
                    bottomTrees,
                    leftTrees,
                    rightTrees
                ).filter { it > 0 }.reduce{acc, item -> acc * item}

                if (height > highest) highest = height
            }
        }
        return highest
    }
}


fun main() {
    val input = FileInput().get("src/main/kotlin/twentytwentytwo/inputs/day8.txt")
    val solver = Day8()
    println("Problem one: ${solver.problemOne(input)}")
    println("Problem two: ${solver.problemTwo(input)}")
}

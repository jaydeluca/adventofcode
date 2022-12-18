package twentytwentytwo

import common.FileInput


class Day12 {

    class TerrainMap {

        var theMap: MutableList<List<Int>> = mutableListOf()

        companion object {

            fun convertCharToNum(char: Char): Int {
                return if (char.isUpperCase()) char.code - 38 else char.code - 96
            }

            fun build(input: List<String>): TerrainMap {
                val terrainMap = TerrainMap()
                input.forEach{
                    terrainMap.theMap.add(it.map { c -> convertCharToNum(c)}.toList())
                }
                return terrainMap
            }
        }
    }


    fun problemOne(input: List<String>) : Int {
        val terrainMap = TerrainMap.build(input)
        print(terrainMap)
        return 1
    }

    fun problemTwo(input: List<String>) : Int {
        return 1
    }
}


fun main() {
    val input = FileInput().get("src/main/kotlin/twentytwentytwo/inputs/day12.txt")
    val solver = Day12()
    println("Problem one: ${solver.problemOne(input)}")
    println("Problem two: ${solver.problemTwo(input)}")
}

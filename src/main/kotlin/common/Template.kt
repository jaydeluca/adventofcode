package common

import common.FileInput


class Template {
    fun problemOne(input: List<String>) : Int {
        return 1
    }

    fun problemTwo(input: List<String>) : Int {
        return 1
    }
}


fun main() {
    val input = FileInput().get("src/main/kotlin/twentytwentytwo/inputs/template.txt")
    val solver = Template()
    println("Problem one: ${solver.problemOne(input)}")
    println("Problem two: ${solver.problemTwo(input)}")
}

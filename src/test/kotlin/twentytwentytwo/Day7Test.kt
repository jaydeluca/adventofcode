package twentytwentytwo

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class Day7Test {

    private val exampleInput = listOf(
        "$ cd /",
        "$ ls",
        "dir a",
        "14848514 b.txt",
        "8504156 c.dat",
        "dir d",
        "$ cd a",
        "$ ls",
        "dir e",
        "29116 f",
        "2557 g",
        "62596 h.lst",
        "$ cd e",
        "$ ls",
        "584 i",
        "$ cd ..",
        "$ cd ..",
        "$ cd d",
        "$ ls",
        "4060174 j",
        "8033020 d.log",
        "5626152 d.ext",
        "7214296 k",
    )

    @Test
    fun testPartOneWithExampleInput() {
        val solver = Day7()
        val result = solver.problemOne(exampleInput)
        assertEquals(95437, result)
    }

    @Test
    fun testPartTwoExampleInput() {
        val solver = Day7()
        val result = solver.problemTwo(exampleInput)
        assertEquals(24933642, result)
    }
}
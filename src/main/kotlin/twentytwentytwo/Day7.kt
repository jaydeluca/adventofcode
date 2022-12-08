package twentytwentytwo

import common.FileInput


class Day7 {
    private var directories: List<Directory> = listOf()
    private var root: Directory = Directory(name = "/")

    data class File(val name: String, val size: Int)

    data class Directory(
        val name: String,
        val files: MutableList<File> = mutableListOf(),
        val directories: MutableMap<String, Directory> = mutableMapOf(),
        val parent: Directory? = null
    ) {
        fun totalSize(): Int {
            val fileSizes = this.files.sumOf { it.size }
            return fileSizes + directories.values.sumOf { it.totalSize() }
        }
    }

    private fun isNumber(s: String): Boolean {
        return when (s.toIntOrNull()) {
            null -> false
            else -> true
        }
    }

    private fun parseInput(input: List<String>) {
        this.root = Directory(name = "/")
        var currentDirectory = this.root

        input.forEach {
            val split = it.split(" ")
            if (split[0] == "$") {
                if (split.size > 2) {
                    if (split[2] == "/") {
                        currentDirectory = this.root
                    }

                    if (split[1] == "cd" && split[2] == "..") {
                        currentDirectory.parent?.let { dir ->
                            currentDirectory = dir
                        }
                    }

                    if (split[1] == "cd" && split[2] !== "..") {
                        currentDirectory.directories[split[2]]?.let { dir ->
                            currentDirectory = dir
                        }
                    }
                }

            }

            if (split[0] == "dir") {
                val newDir = Directory(parent = currentDirectory, name = split[1])
                currentDirectory.directories[split[1]] = newDir
            }
            if (isNumber(split[0])) {
                currentDirectory.files
                    .add(
                        File(name = split[1], size = Integer.parseInt(split[0]))
                    )
            }
        }

        this.directories = traverseDirectories(this.root)
    }

    private fun traverseDirectories(directory: Directory): MutableList<Directory> {
        val newDirs: MutableList<Directory> = mutableListOf(directory)
        if (directory.directories.isEmpty()) {
            return newDirs
        }

        directory.directories.values.forEach {
            newDirs.addAll(traverseDirectories(it))
        }

        return newDirs
    }

    fun problemOne(input: List<String>): Int {
        parseInput(input)
        return this.directories.filter { it.totalSize() <= 100000 }.sumOf { it.totalSize() }
    }


    fun problemTwo(input: List<String>): Int? {
        parseInput(input)
        val availableSpace = 70000000 - this.root.totalSize()
        val neededSpace = 30000000 - availableSpace
        return this.directories.map { it.totalSize() }.filter { it >= neededSpace }.minOrNull()
    }
}


fun main() {
    val input = FileInput().get("src/main/kotlin/twentytwentytwo/inputs/day7.txt")
    val solver = Day7()
    println("Problem one: ${solver.problemOne(input)}")
    println("Problem two: ${solver.problemTwo(input)}")
}

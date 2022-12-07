package twentytwentytwo

import common.FileInput


class Day7 {

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


    fun problemOne(input: List<String>): Int {
        val rootDirectory = Directory(name = "/")
        var currentDirectory = rootDirectory

        input.forEach {
            val split = it.split(" ")
            if (split[0] == "$") {
                if (split.size > 2) {
                    if (split[2] == "/") {
                        currentDirectory = rootDirectory
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

        val dirs = traverseDirectories(rootDirectory, mutableMapOf())
        return dirs.values.sumOf { it.totalSize() }
    }

    private fun traverseDirectories(directory: Directory, directories: MutableMap<String, Directory>): MutableMap<String, Directory> {
        if (directory.totalSize() <= 100000) {
            directories[directory.name] = directory
        }
        if (directory.directories.isEmpty()) {
            return directories
        }

        directory.directories.values.forEach {
            directories += traverseDirectories(it, directories)
        }

        return directories
    }

    fun problemTwo(input: List<String>): Int {
        return 1
    }
}


fun main() {
    val input = FileInput().get("src/main/kotlin/twentytwentytwo/inputs/day7.txt")
    val solver = Day7()
    // not 645408
    // not 1821350
    println("Problem one: ${solver.problemOne(input)}")
    println("Problem two: ${solver.problemTwo(input)}")
}

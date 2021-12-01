package common

import java.io.File

class FileInput {
    fun get(location: String): List<String> {
        val file = File(location)
        return when {
            file.exists() -> {
                file.read()
            }
            else -> {
                throw Exception("File not found at location: $location")
            }
        }
    }

    private fun File.read(): List<String> = useLines { it.toList() }
}


package twentytwentytwo

import common.FileInput


class Day2 {

    enum class Plays {
        ROCK, PAPER, SCISSORS
    }

    interface PlayOption {
        val beats: Plays
        val losesTo: Plays
        val points: Int
        val type: Plays
        fun didWin(opponentPlay: PlayOption): Boolean {
            return this.beats == opponentPlay.type
        }

        fun didDraw(opponentPlay: PlayOption): Boolean {
            return this.type == opponentPlay.type
        }

        fun didLose(opponentPlay: PlayOption): Boolean {
            return this.type == opponentPlay.beats
        }
    }

    class Rock : PlayOption {
        override val type = Plays.ROCK
        override val beats = Plays.SCISSORS
        override val losesTo = Plays.PAPER
        override val points = 1
    }

    class Scissors : PlayOption {
        override val type = Plays.SCISSORS
        override val beats = Plays.PAPER
        override val losesTo = Plays.ROCK
        override val points = 3
    }

    class Paper : PlayOption {
        override val type = Plays.PAPER
        override val beats = Plays.ROCK
        override val losesTo = Plays.SCISSORS
        override val points = 2
    }

    data class Turn(
        val opponentPlay: PlayOption,
        val play: PlayOption,
    ) {
        fun score(): Int {
            val score = play.points
            return when {
                play.didLose(opponentPlay) -> score + 0
                play.didDraw(opponentPlay) -> score + 3
                play.didWin(opponentPlay) -> score + 6
                else -> throw RuntimeException()
            }
        }
    }

    class TurnFactory {
        companion object {
            private val opponentTurnMap = hashMapOf(
                "A" to Rock(),
                "B" to Paper(),
                "C" to Scissors(),
            )

            private val problemOnePlayMap = hashMapOf(
                "X" to Rock(),
                "Y" to Paper(),
                "Z" to Scissors(),
            )

            fun buildOpponentTurn(value: String): PlayOption {
                opponentTurnMap[value]?.let {
                    return it
                }
                throw RuntimeException()
            }

            fun buildPlayerTurnPartOne(value: String): PlayOption {
                problemOnePlayMap[value]?.let {
                    return it
                }
                throw RuntimeException()
            }

            private fun buildByType(type: Plays): PlayOption {
                return when (type) {
                    Plays.ROCK -> Rock()
                    Plays.SCISSORS -> Scissors()
                    Plays.PAPER -> Paper()
                }
            }

            fun buildPlayerTurnPartTwo(value: String, opponentPlay: PlayOption): PlayOption {
                return when (value) {
                    "X" -> buildByType(opponentPlay.beats)
                    "Y" -> buildByType(opponentPlay.type)
                    "Z" -> buildByType(opponentPlay.losesTo)
                    else -> throw RuntimeException(value)
                }
            }
        }
    }

    fun problemOne(input: List<String>): Int {
        return input.map {
            val turns = it.split(" ")
            val opponentPlay = TurnFactory.buildOpponentTurn(turns[0])
            val play = TurnFactory.buildPlayerTurnPartOne(turns[1])
            Turn(opponentPlay, play)
        }.sumOf(Turn::score)
    }

    fun problemTwo(input: List<String>): Int {
        return input.map {
            val turns = it.split(" ")
            val opponentPlay = TurnFactory.buildOpponentTurn(turns[0])
            val play = TurnFactory.buildPlayerTurnPartTwo(turns[1], opponentPlay)
            Turn(opponentPlay, play)
        }.sumOf(Turn::score)
    }
}


fun main() {
    val input = FileInput().get("src/main/kotlin/twentytwentytwo/inputs/day2.txt")
    val solver = Day2()
    println("Problem one: ${solver.problemOne(input)}")
    println("Problem two: ${solver.problemTwo(input)}")
}

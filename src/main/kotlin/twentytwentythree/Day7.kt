package twentytwentythree

import common.FileInput


class Day7 {

    enum class HandType(val value: Int) {
        FIVE_OF_A_KIND(7),
        FOUR_OF_A_KIND(6),
        FULL_HOUSE(5),
        THREE_OF_A_KIND(4),
        TWO_PAIR(3),
        ONE_PAIR(2),
        HIGH_CARD(1)
    }

    data class Hand(
        val cards: String,
        val bid: Long
    ) {

        fun isFiveOfAKind(): Boolean = cards.groupBy { it }.size == 1
        fun isFourOfAKind(): Boolean = cards.groupBy { it }.maxBy { it.value.size }.value.size == 4
        fun isFullHouse(): Boolean =
            cards.groupBy { it }.size == 2 && cards.groupBy { it }.maxBy { it.value.size }.value.size == 3

        fun isThreeOfAKind(): Boolean =
            cards.groupBy { it }.size == 3 && cards.groupBy { it }.maxBy { it.value.size }.value.size == 3

        fun isTwoPair(): Boolean =
            cards.groupBy { it }.size == 3 && cards.groupBy { it }.maxBy { it.value.size }.value.size == 2

        fun isOnePair(): Boolean =
            cards.groupBy { it }.size == 4 && cards.groupBy { it }.maxBy { it.value.size }.value.size == 2

        fun getType(): HandType {
            return when {
                isFiveOfAKind() -> HandType.FIVE_OF_A_KIND
                isFourOfAKind() -> HandType.FOUR_OF_A_KIND
                isFullHouse() -> HandType.FULL_HOUSE
                isThreeOfAKind() -> HandType.THREE_OF_A_KIND
                isTwoPair() -> HandType.TWO_PAIR
                isOnePair() -> HandType.ONE_PAIR
                else -> HandType.HIGH_CARD
            }
        }

        fun getConvertedJokerType(): HandType {
            val jCards = cards.toList().filter { it.toString() == "J" }.size
            if (jCards == 0) return getType()
            if (jCards == 5) return HandType.FIVE_OF_A_KIND

            val nonJ = cards.toList().map(Char::toString).filter { it != "J" }.groupBy { it }

            if (nonJ.map { it.value.size }.any { it + jCards == 5 }) {
                return HandType.FIVE_OF_A_KIND
            }

            if (nonJ.map { it.value.size }.any { it + jCards == 4 }) {
                return HandType.FOUR_OF_A_KIND
            }

            if (nonJ.size == 2) {
                return HandType.FULL_HOUSE
            }

            if (nonJ.map { it.value.size }.any { it == 2 }) {
                return HandType.THREE_OF_A_KIND
            }

            if (nonJ.map { it.value.size }.contains(2)) {
                return HandType.TWO_PAIR
            }

            return HandType.ONE_PAIR
        }

    }


    class HandComparator(private val cardValue: List<String>) : Comparator<Hand> {
        override fun compare(h1: Hand, h2: Hand): Int {
            if (h1.getType() == h2.getType()) {
                h1.cards.toList().forEachIndexed { index, c ->
                    if (cardValue.indexOf(c.toString()) != cardValue.indexOf(h2.cards[index].toString())) {
                        return if (cardValue.indexOf(c.toString()) > cardValue.indexOf(h2.cards[index].toString())) {
                            1
                        } else {
                            -1
                        }
                    }
                }
                return 0
            }
            return h1.getType().value - h2.getType().value
        }
    }

    class HandComparatorJoker(private val cardValue: List<String>) : Comparator<Hand> {
        override fun compare(h1: Hand, h2: Hand): Int {
            if (h1.getConvertedJokerType() == h2.getConvertedJokerType()) {
                h1.cards.toList().forEachIndexed { index, c ->
                    if (cardValue.indexOf(c.toString()) != cardValue.indexOf(h2.cards[index].toString())) {
                        return if (cardValue.indexOf(c.toString()) > cardValue.indexOf(h2.cards[index].toString())) {
                            1
                        } else {
                            -1
                        }
                    }
                }
                return 0
            }
            return h1.getConvertedJokerType().value - h2.getConvertedJokerType().value
        }
    }


    fun problemOne(input: List<String>): Long {
        val cardValue = listOf(
            "A", "K", "Q", "J", "T", "9", "8", "7", "6", "5", "4", "3", "2"
        ).reversed()

        val sortedHands = input
            .map { Hand(cards = it.split(" ")[0], bid = it.split(" ")[1].toLong()) }
            .sortedWith(HandComparator(cardValue))

        var total = 0L
        sortedHands.forEachIndexed { index, hand ->
            total += (hand.bid * (index+1))
        }

        return total
    }

    fun problemTwo(input: List<String>): Long {
        val cardValue = listOf(
            "A", "K", "Q", "T", "9", "8", "7", "6", "5", "4", "3", "2", "J"
        ).reversed()

        val sortedHands = input
            .map { Hand(cards = it.split(" ")[0], bid = it.split(" ")[1].toLong()) }
            .sortedWith(HandComparatorJoker(cardValue))

        var total = 0L
        sortedHands.forEachIndexed { index, hand ->
            total += (hand.bid * (index+1))
        }

        return total
    }
}


fun main() {
    val input = FileInput().get("src/main/kotlin/twentytwentythree/inputs/day7.txt")
    val solver = Day7()
    println("Problem one: ${solver.problemOne(input)}")
    println("Problem two: ${solver.problemTwo(input)}")
}

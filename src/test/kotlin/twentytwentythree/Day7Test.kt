package twentytwentythree

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class Day7Test {

    private val exampleInput = listOf(
        "32T3K 765",
        "T55J5 684",
        "KK677 28",
        "KTJJT 220",
        "QQQJA 483",
    )

    @Test
    fun testIs5OfAKind() {
        val hand = Day7.Hand(cards = "AAAAA", bid = 1)
        assertTrue(hand.isFiveOfAKind())
        assertEquals(Day7.HandType.FIVE_OF_A_KIND, hand.getType())
    }

    @Test
    fun testIs4OfAKind() {
        val hand = Day7.Hand(cards = "AABAA", bid = 1)
        assertFalse(hand.isFiveOfAKind())
        assertTrue(hand.isFourOfAKind())
    }

    @Test
    fun testIsFullHouse() {
        val hand = Day7.Hand(cards = "23332", bid = 1)
        assertFalse(hand.isFourOfAKind())
        assertFalse(hand.isFiveOfAKind())
        assertTrue(hand.isFullHouse())
    }

    @Test
    fun testIsThreeOfAKind() {
        val hand = Day7.Hand(cards = "TTT98", bid = 1)
        assertFalse(hand.isFourOfAKind())
        assertFalse(hand.isFiveOfAKind())
        assertFalse(hand.isFullHouse())
        assertTrue(hand.isThreeOfAKind())
    }

    @Test
    fun testIsTwoPair() {
        val hand = Day7.Hand(cards = "23432", bid = 1)
        assertFalse(hand.isFourOfAKind())
        assertFalse(hand.isFiveOfAKind())
        assertFalse(hand.isFullHouse())
        assertFalse(hand.isThreeOfAKind())
        assertTrue(hand.isTwoPair())
    }

    @Test
    fun testIsOnePair() {
        val hand = Day7.Hand(cards = "A23A4", bid = 1)
        assertFalse(hand.isFourOfAKind())
        assertFalse(hand.isFiveOfAKind())
        assertFalse(hand.isFullHouse())
        assertFalse(hand.isThreeOfAKind())
        assertFalse(hand.isTwoPair())
        assertTrue(hand.isOnePair())
    }

    @Test
    fun testIsHighCard() {
        val hand = Day7.Hand(cards = "23456", bid = 1)
        assertFalse(hand.isFourOfAKind())
        assertFalse(hand.isFiveOfAKind())
        assertFalse(hand.isFullHouse())
        assertFalse(hand.isThreeOfAKind())
        assertFalse(hand.isTwoPair())
        assertFalse(hand.isOnePair())
        assertEquals(hand.getType(), Day7.HandType.HIGH_CARD)
    }

    @Test
    fun testConvertJokersToFiveOfAKind() {
        val result1 = Day7.Hand(cards = "KKKKJ", bid = 1)
        assertEquals(Day7.HandType.FIVE_OF_A_KIND, result1.getConvertedJokerType())

        val result2 = Day7.Hand(cards = "KKKJJ", bid = 1)
        assertEquals(Day7.HandType.FIVE_OF_A_KIND, result2.getConvertedJokerType())

        val result3 = Day7.Hand(cards = "KKJJJ", bid = 1)
        assertEquals(Day7.HandType.FIVE_OF_A_KIND, result3.getConvertedJokerType())

        val result4 = Day7.Hand(cards = "KJJJJ", bid = 1)
        assertEquals(Day7.HandType.FIVE_OF_A_KIND, result4.getConvertedJokerType())

        val result5 = Day7.Hand(cards = "JJJJJ", bid = 1)
        assertEquals(Day7.HandType.FIVE_OF_A_KIND, result5.getConvertedJokerType())
    }

    @Test
    fun testConvertJokersToFourOfAKind() {
        val result = Day7.Hand(cards = "KKKQJ", bid = 1)
        assertEquals(Day7.HandType.FOUR_OF_A_KIND, result.getConvertedJokerType())

        val result2 = Day7.Hand(cards = "KKQJJ", bid = 1)
        assertEquals(Day7.HandType.FOUR_OF_A_KIND, result2.getConvertedJokerType())
    }

    @Test
    fun testConvertJokersToFullHouse() {
        val result = Day7.Hand(cards = "8QQJ8", bid = 1)
        assertEquals(Day7.HandType.FULL_HOUSE, result.getConvertedJokerType())
    }

    @Test
    fun testConvertJokersToThreeOfAKind() {
        val result = Day7.Hand(cards = "8JQQ2", bid = 1)
        assertEquals(Day7.HandType.THREE_OF_A_KIND, result.getConvertedJokerType())
    }

    @Test
    fun testConvertJokersToTwoPair() {
        val result = Day7.Hand(cards = "8JQQ2", bid = 1)
        assertEquals(Day7.HandType.THREE_OF_A_KIND, result.getConvertedJokerType())
    }

    @Test
    fun testPartOneWithExampleInput() {
        val solver = Day7()
        val result = solver.problemOne(exampleInput)
        assertEquals(6440, result)
    }

    @Test
    fun testPartTwoExampleInput() {
        val solver = Day7()
        val result = solver.problemTwo(exampleInput)
        assertEquals(5905, result)
    }
}
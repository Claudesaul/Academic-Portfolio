package poker;

import static org.junit.Assert.*;
import org.junit.Test;

public class StudentTests {
	
	Card[] pairTrue1 = { new Card(1, 0), new Card(3, 0), new Card(3, 1), new Card(4, 0), new Card(5, 0) };
	Card[] pairTrue2 = { new Card(1, 0), new Card(3, 0), new Card(4, 1), new Card(4, 0), new Card(5, 0) };
	Card[] pairFalse1 = { new Card(1, 0), new Card(2, 0), new Card(3, 0), new Card(4, 0), new Card(5, 0) };
	Card[] pairFalse2 = { new Card(2, 0), new Card(8, 0), new Card(9, 0), new Card(6, 0), new Card(5, 0) };

	Card[] threeOfKindTrue1 = { new Card(3, 0), new Card(2, 0), new Card(3, 1), new Card(2, 1), new Card(3, 2) };
	Card[] threeOfKindTrue2 = { new Card(5, 0), new Card(2, 0), new Card(5, 1), new Card(2, 1), new Card(5, 2) };
	Card[] threeOfKindFalse1 = { new Card(1, 0), new Card(1, 1), new Card(2, 0), new Card(2, 1), new Card(3, 0) };
	Card[] threeOfKindFalse2 = { new Card(1, 0), new Card(2, 1), new Card(3, 0), new Card(2, 1), new Card(3, 0) };

	Card[] fourOfKindTrue1 = { new Card(3, 0), new Card(2, 0), new Card(2, 1), new Card(2, 2), new Card(2, 3) };
	Card[] fourOfKindTrue2 = { new Card(9, 0), new Card(9, 2), new Card(2, 1), new Card(9,3), new Card(9, 1) };
	Card[] fourOfKindFalse1 = { new Card(1, 0), new Card(1, 1), new Card(2, 0), new Card(2, 1), new Card(3, 0) };
	Card[] fourOfKindFalse2 = { new Card(1, 0), new Card(1, 1), new Card(1, 3), new Card(2, 1), new Card(3, 0) };

	Card[] twoPairTrue1 = { new Card(3, 0), new Card(2, 0), new Card(2, 1), new Card(3, 2), new Card(2, 3) };
	Card[] twoPairTrue2 = { new Card(1, 0), new Card(2, 0), new Card(2, 1), new Card(3, 2), new Card(1, 3) };
	Card[] twoPairFalse1 = { new Card(1, 0), new Card(1, 1), new Card(2, 0), new Card(3, 0), new Card(4, 0) };
	Card[] twoPairFalse2 = { new Card(1, 0), new Card(2, 0), new Card(2, 1), new Card(3, 2), new Card(2, 3) };

	Card[] straightTrue = { new Card(3, 0), new Card(1, 0), new Card(4, 1), new Card(2, 2), new Card(5, 3) };
	Card[] straightTrue2 = { new Card(11, 0), new Card(1, 0), new Card(13, 1), new Card(12, 2), new Card(10, 3) };
	Card[] straightFalse1 = { new Card(1, 0), new Card(13, 1), new Card(2, 0), new Card(3, 0), new Card(4, 0) };
	Card[] straightFalse2 = { new Card(1, 0), new Card(13, 1), new Card(13, 0), new Card(1, 0), new Card(4, 0) };

	Card[] flushTrue1 = { new Card(1, 0), new Card(2, 0), new Card(3, 0), new Card(4, 0), new Card(5, 0) };
	Card[] flushTrue2 = { new Card(9, 0), new Card(7, 0), new Card(6, 0), new Card(8, 0), new Card(5, 0) };
	Card[] flushFalse1 = { new Card(1, 0), new Card(2, 0), new Card(3, 0), new Card(4, 0), new Card(4, 1) };
	Card[] flushFalse2 = { new Card(1, 1), new Card(1, 2), new Card(1, 3), new Card(1, 0), new Card(4, 1) };

	Card[] fullTrue1 = { new Card(1, 0), new Card(1, 1), new Card(1, 2), new Card(4, 0), new Card(4, 1) };
	Card[] fullTrue2 = { new Card(3, 0), new Card(1, 1), new Card(1, 2), new Card(3, 1), new Card(1, 3) };
	Card[] fullFalse1 = { new Card(1, 0), new Card(1, 1), new Card(1, 2), new Card(4, 0), new Card(5, 0) };
	Card[] fullFalse2 = { new Card(1, 0), new Card(1, 1), new Card(1, 2), new Card(1, 3), new Card(5, 0) };

	Card[] jackPotTrue1 = { new Card(2, 0), new Card(6, 0), new Card(3, 0), new Card(4, 0), new Card(5, 0) };
	Card[] jackPotTrue2 = { new Card(1, 0), new Card(13, 0), new Card(11, 0), new Card(10, 0), new Card(12, 0) };
	Card[] jackPotFalse1 = { new Card(2, 0), new Card(6, 0), new Card(3, 1), new Card(4, 0), new Card(5, 0) };
	Card[] jackPotFalse2 = { new Card(13, 0), new Card(1, 0), new Card(2, 1), new Card(3, 0), new Card(12, 0) };

	@Test
	public void PairTest() {

		assertTrue(PokerHandEvaluator.hasPair(pairTrue1));
		assertTrue(PokerHandEvaluator.hasPair(pairTrue2));
		assertFalse(PokerHandEvaluator.hasPair(pairFalse1));
		assertFalse(PokerHandEvaluator.hasPair(pairFalse2));
	}

	@Test
	public void ThreeOfAKindTest() {

		assertTrue(PokerHandEvaluator.hasThreeOfAKind(threeOfKindTrue1));
		assertTrue(PokerHandEvaluator.hasThreeOfAKind(threeOfKindTrue2));
		assertFalse(PokerHandEvaluator.hasThreeOfAKind(threeOfKindFalse1));
		assertFalse(PokerHandEvaluator.hasThreeOfAKind(threeOfKindFalse2));

	}

	@Test
	public void FourOfAKindTest() {

		assertTrue(PokerHandEvaluator.hasFourOfAKind(fourOfKindTrue1));
		assertTrue(PokerHandEvaluator.hasFourOfAKind(fourOfKindTrue2));
		assertFalse(PokerHandEvaluator.hasFourOfAKind(fourOfKindFalse1));
		assertFalse(PokerHandEvaluator.hasFourOfAKind(fourOfKindFalse2));

	}

	@Test
	public void TwoPairTest() {

		assertTrue(PokerHandEvaluator.hasTwoPair(twoPairTrue1));
		assertTrue(PokerHandEvaluator.hasTwoPair(twoPairTrue2));
		assertFalse(PokerHandEvaluator.hasTwoPair(twoPairFalse1));
		assertFalse(PokerHandEvaluator.hasTwoPair(twoPairFalse2));

	}

	@Test
	public void StraightTest() {

		assertTrue(PokerHandEvaluator.hasStraight(straightTrue));
		assertTrue(PokerHandEvaluator.hasStraight(straightTrue2));
		assertFalse(PokerHandEvaluator.hasStraight(straightFalse1));
		assertFalse(PokerHandEvaluator.hasStraight(straightFalse2));

	}

	@Test
	public void FlushTest() {

		assertTrue(PokerHandEvaluator.hasFlush(flushTrue1));
		assertTrue(PokerHandEvaluator.hasFlush(flushTrue2));
		assertFalse(PokerHandEvaluator.hasFlush(flushFalse1));
		assertFalse(PokerHandEvaluator.hasFlush(flushFalse2));

	}

	@Test
	public void FullHouseTest() {

		assertTrue(PokerHandEvaluator.hasFullHouse(fullTrue1));
		assertTrue(PokerHandEvaluator.hasFullHouse(fullTrue2));
		assertFalse(PokerHandEvaluator.hasFullHouse(fullFalse1));
		assertFalse(PokerHandEvaluator.hasFullHouse(fullFalse2));

	}

	@Test
	public void StraightFlushTest() {

		assertTrue(PokerHandEvaluator.hasStraightFlush(jackPotTrue1));
		assertTrue(PokerHandEvaluator.hasStraightFlush(jackPotTrue2));
		assertFalse(PokerHandEvaluator.hasStraightFlush(jackPotFalse1));
		assertFalse(PokerHandEvaluator.hasStraightFlush(jackPotFalse2));

	}

}
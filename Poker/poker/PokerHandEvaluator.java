package poker;

public class PokerHandEvaluator {

	public static boolean hasPair(Card[] cards) {
		
		return pairsFinder(cards, 1);
	}

	public static boolean hasTwoPair(Card[] cards) {
		
		return pairsFinder(cards, 2);
	}

	public static boolean hasThreeOfAKind(Card[] cards) {
		
		return matchesFinder(cards, 2, true);
	}

	public static boolean hasStraight(Card[] cards) {
		
		return preRecursive(cards);
	}

	public static boolean hasFlush(Card[] cards) {
		
		return matchesFinder(cards, 4, false);
	}

	public static boolean hasFullHouse(Card[] cards) {
		
		return matchesFinder(cards,2,true) && pairsFinder(cards,2);
	}

	public static boolean hasFourOfAKind(Card[] cards) {
		
		return matchesFinder(cards, 3, true);
	}

	public static boolean hasStraightFlush(Card[] cards) {
		
		return hasFlush(cards) && hasStraight(cards);
	}

	/*
	 * Private method to check duplicates while excluding one already found
	 */
	private static boolean pairsFinder(Card[] cards, int amountOfPairsNeeded) {

		// Initialize a variable that will keep track of the first found pair
		int firstPair = 0, amountOfPairs = 0;

		// Run an outer loop to iterate over each card once
		for (int idx = 0; idx < cards.length; idx++) {

			// Run another loop that checks the value of every other card
			for (int check = 0; check < cards.length; check++) {

				// Do not count the same card being worked on
				if (check != idx && cards[check].getValue() != firstPair) {

					// Check that the inner index == the same as outer index
					if (cards[idx].getValue() == cards[check].getValue()) {
						amountOfPairs++;

						// return when a second pair has been found;
						if (amountOfPairs == amountOfPairsNeeded) {
							return true;
						}

						// Exclude the first pair from the next test
						firstPair = cards[check].getValue();
					}
				}

			}
		}
		return false;
	}

	/*
	 * This private method finds the specified amount of matches required
	 */
	private static boolean matchesFinder(Card[] cards, int amountOfMatchesNeeded, boolean cardValue) {

		// Initialize a variable that will keep track of the first found pair
		int sameValueCount = 0;

		// Run an outer loop to iterate over each card once
		for (int idx = 0; idx < cards.length; idx++) {

			// Reset the counter for every outer iteration
			sameValueCount = 0;

			// Run another loop that checks the value of every other card
			for (int check = 0; check < cards.length; check++) {

				// Do not count the same card being worked on
				if (check != idx) {

					// Check that the inner index == the same as the outer index
					if (cardValue) {

						if (cards[idx].getValue() == cards[check].getValue()) {
							sameValueCount++;
						}
					} else {

						if (cards[idx].getSuit() == cards[check].getSuit()) {
							sameValueCount++;
						}
					}

					if (sameValueCount == amountOfMatchesNeeded) {
						return true;
					}
				}
			}

		}
		return false;
	}
	
	/*
	 * This private method begins the call to the recursiveStraight method
	 */
	private static boolean preRecursive(Card[] cards) {
		
		//Catch the Aces exceptions
		for (int i = 0; i < cards.length; i++) {
			if (cards[i].getValue() == 1 && kingsAndTwos(cards)) {
				return false;
			}
		}
		
		for (int idx = 0; idx < cards.length; idx++) {

			if (recursiveStraight(cards, cards[idx].getValue() + 1, 4)) {
				return true;
			}
		}

		return false;
	}
	
	/*
	 * This private method makes sure that a hand does not contain a king and a two simultaneously
	 * This would automatically disqualify the cards from being a straight
	 */
	private static boolean kingsAndTwos(Card[] cards) {
		
		boolean king = false,two = false;
		
		for (int idx = 0; idx < cards.length; idx++) {
			
			if (cards[idx].getValue() == 2) {
				two =  true;
			}
			if (cards[idx].getValue() == 13) {
				king =  true;
			}
		}
		return king && two;
	}
	
	/*
	 * This private recursive method calls itself to find a straight in the given cards
	 */
	private static boolean recursiveStraight(Card[] cards, int nextValue, int count) {
		
		if (nextValue == 14) {
			nextValue = 1;
		}
		
		// Run outer loop to compare all values
		for (int idx = 0; idx < cards.length; idx++) {
			
			if (cards[idx].getValue() == nextValue) {
				count--;
				
				if (count == 0) {
					return true;
				}
				return recursiveStraight(cards, nextValue + 1, count);
			}
			
		}
		return false;
		
	}
}
	
package poker;

public class Deck {

	private Card[] cards;

	// Default Constructor
	public Deck() {

		cards = new Card[52];

		int[] suitNames = { 0, 1, 2, 3 };
		int[] valueNames = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13 };

		// Initialize all the cards
		int count = 0;

		for (int suit : suitNames) {

			for (int value : valueNames) {

				cards[count] = new Card(value, suit);
				count++;
			}
		}
	}

	/*
	 * Deck Copy Constructor
	 */
	public Deck(Deck other) {

		// New card array with the same content as the one being passed in
		cards = new Card[other.getNumCards()];

		for (int idx = 0; idx < cards.length; idx++) {
			cards[idx] = other.cards[idx];
		}

	}

	/*
	 * getCardAt
	 */
	public Card getCardAt(int position) {

		return cards[position];
	}

	/*
	 * getNumCards
	 */
	public int getNumCards() {

		return cards.length;
	}

	/*
	 * shuffle
	 */
	public void shuffle() {

		// Create dummy copy deck
		Deck originalDeck = new Deck(this);

		// Shuffle even cards
		if (originalDeck.getNumCards() % 2 == 0) {
			
			cards = oneShuffler(originalDeck, 1, this.getNumCards() / 2);
		}
		// Shuffle odd cards
		else {
			
			cards = oneShuffler(originalDeck, 1, this.getNumCards() / 2 + 1);
		}
		// Shift the values back in place
		cards = oneShuffler(originalDeck, 0, 0);
	}

	/*
	 * cut
	 */
	public void cut(int position) {

		Card temp;

		// Perform the rotations for the given amount of positions
		for (int i = 0; i < position; i++) {

			// Shift to the left
			for (int idx = 0; idx < cards.length - 1; idx++) {

				temp = cards[idx];

				cards[idx] = cards[idx + 1];

				cards[idx + 1] = temp;
			}
		}
	}

	/*
	 * deal
	 */
	public Card[] deal(int numCards) {

		// Create the cards to return
		Card[] returnCards = new Card[numCards];

		for (int idx = 0; idx < numCards; idx++) {
			returnCards[idx] = cards[idx];
		}

		// Update the current cards
		Card[] newCards = new Card[cards.length - numCards];

		for (int idx = 0; idx < newCards.length; idx++) {
			newCards[idx] = cards[numCards++];
		}

		cards = newCards;

		return returnCards;
	}

	/*
	 * toString
	 */
	public String toString() {

		StringBuffer deck = new StringBuffer();
		for (int idx = 0; idx < cards.length; idx++) {
			deck.append(cards[idx].toString()).append("\n");
		}

		return deck.toString().trim();
	}

	/*
	 * Private method that shuffled at specified starting point and at given
	 * position
	 */
	private Card[] oneShuffler(Deck originalDeck, int start, int position) {

		// Make a copy of the current deck
		Deck shuffled = new Deck(this);

		// Loop the new card array and shift the positions
		for (int idx = start; idx < originalDeck.getNumCards(); idx += 2) {

			shuffled.cards[idx] = originalDeck.cards[position];

			position++;
		}
		return shuffled.cards;
	}
}

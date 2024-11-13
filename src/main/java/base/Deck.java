package base;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class Deck<T extends Card> {
	protected List<T> cards;

	public Deck() {
		cards = new ArrayList<>();
		initializeDeck();
	}

	// Each game will define how the deck is initialized
	protected abstract void initializeDeck();

	public void shuffle() {
		Collections.shuffle(cards);
	}

	public List<T> deal(int numCards) {
		List<T> hand = new ArrayList<>(cards.subList(0, numCards));
		cards.subList(0, numCards).clear();
		return hand;
	}

	public int getDeckSize() {
		return cards.size();
	}
}

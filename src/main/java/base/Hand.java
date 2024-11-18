package base;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Hand<T extends Card> {
    private List<T> cards;

    public Hand() {
        this.cards = new ArrayList<>();
    }

    // Adds a collection of cards to the hand
    public void addAll(List<T> cards) {
        this.cards.addAll(cards);
    }

    // Adds a single card to the hand
    public boolean add(T card) {
        return this.cards.add(card);  // Return boolean to match List behavior
    }

    // Removes a specific card from the hand
    public T remove(int index) {
		return cards.remove(index);
	}

    // Custom method to remove a specific card by rank and suit
    public T removeCard(Rank rank, Suit suit) {
        for (int c = 0; c < cards.size(); c++) {
            if (cards.get(c).equals(rank, suit)) {
                return cards.remove(c);
            }
        }
        return null; // Return null if the card is not found
    }

    // Retrieves a card at a specific index
    public T get(int index) {
        return this.cards.get(index);
    }

    // Gets all cards in the hand as a list
    public List<T> getCards() {
        return this.cards;
    }

    // Clears the hand
    public void clear() {
        this.cards.clear();
    }

    // Returns the number of cards in the hand
    public int size() {
        return this.cards.size();
    }

	public boolean isEmpty() {
		return size() == 0;
	}

	/** Sorts the hand using the provided comparator.
     *  @param comparator the comparator to define the sorting order */
    public void sort(Comparator<T> comparator) {
        Collections.sort(cards, comparator);
    }

	public String display() {
		String text = "[";
		for (T t : cards) {
			text += t.display() + " ";
		}
		return text += "]";
	}

	/* ----------------------------- toString ------------------------------ */
    @Override
    public String toString() {
        return cards.toString();
    }
}

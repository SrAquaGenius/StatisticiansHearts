package base;

import java.util.ArrayList;
import java.util.List;

public class Hand<T extends Card> extends ArrayList<T> {
	private List<T> cards;

    public Hand() {
        this.cards = new ArrayList<>();
    }

    // Adds a collection of cards to the hand
    public void addAll(List<T> cards) {
        this.cards.addAll(cards);
    }

    // Adds a single card to the hand
    public void add(T card) {
        this.cards.add(card);
    }

    // Removes a specific card from the hand
    public boolean remove(T card) {
        return this.cards.remove(card);
    }

    // Retrieves a card at a specific index
    public T get(int index) {
        return this.cards.get(index);
    }

    // Gets all cards in the hand
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

    @Override
    public String toString() {
        return cards.toString();
    }
}

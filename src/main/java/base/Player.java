package base;

import java.util.Comparator;

public class Player<T extends Card> {
	private Hand<T> hand;
	private String _name;
	private int points;

	public Player(String name) {
		hand = new Hand<>();
		_name = name;
		points = 0;
	}

	public Hand<T> getHand() {
		return hand;
	}

	public String getName() {
		return _name;
	}

	public int getPoints() {
		return points;
	}

	public void addPoints(int points) {
		points += points;
	}

	public void receiveCard(T card) {
		hand.add(card);
	}

	public T playCard(int index) {
		return hand.remove(index);
	}

	public T playCard(Rank rank, Suit suit) {
		return hand.removeCard(rank, suit);
	}

	/** Sorts the player's hand.
	 *  @param comparator the comparator to define the sorting order */
	public void sortHand(Comparator<T> comparator) {
		hand.sort(comparator);
	}

	public String display() {
		return "Player " + _name;
	}
}

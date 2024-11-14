package base;

public class Player<T extends Card> {
	private Hand<T> hand;
	private int points;

	public Player() {
		hand = new Hand<>();
		points = 0;
	}

	public Hand<T> getHand() {
		return hand;
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
}

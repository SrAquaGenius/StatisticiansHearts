package base;

public class Player<T extends Card> {
	private Hand<T> hand;
	private int score;

	public Player() {
		hand = new Hand<>();
		score = 0;
	}

	public Hand<T> getHand() {
		return hand;
	}

	public int getScore() {
		return score;
	}

	public void addScore(int points) {
		score += points;
	}

	public void receiveCard(T card) {
		hand.add(card);
	}

	public T playCard(int index) {
		return hand.remove(index);
	}
}

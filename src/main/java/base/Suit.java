package base;

public enum Suit {
	CLUBS, DIAMONDS, SPADES, HEARTS;

	public String display() {
		switch (this) {
			case CLUBS:
				return "♣";
			case DIAMONDS:
				return "♦";
			case SPADES:
				return "♠";
			case HEARTS:
				return "♥";
			default:
				return name();
		}
	}
}

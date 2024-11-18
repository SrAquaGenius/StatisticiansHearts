package base;

public enum Rank {
	ACE,
	TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN,
	JACK, QUEEN, KING;

	public String display() {
		switch (this) {
			case ACE:
				return "A";
			case JACK:
				return "J";
			case QUEEN:
				return "Q";
			case KING:
				return "K";
			default:
				return "" + (ordinal() + 1);
		}
	}
}

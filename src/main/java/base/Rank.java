package base;

public enum Rank {
	ACE,
	TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN,
	JACK, QUEEN, KING;

	public String display() {
		int out;

		switch (this) {
			case ACE:
				return " A";
			case JACK:
				return " J";
			case QUEEN:
				return " Q";
			case KING:
				return " K";
			case TEN:
				out = ordinal() + 1;
				return "" + out;
			default:
				out = ordinal() + 1;
				return " " + out;
		}
	}
}

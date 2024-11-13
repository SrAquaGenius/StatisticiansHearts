package base;

public abstract class Card {

	private Suit _suit;
	private Rank _rank;

	/* ---------------------------- Constructor ---------------------------- */
	public Card(Suit suit, Rank rank) {
		this._suit = suit;
		this._rank = rank;
	}

	/* ----------- Getters, Setters and useful general functions ----------- */
	public Suit getSuit() {
		return _suit;
	}

	public Rank getRank() {
		return _rank;
	}

	public abstract int getValue();

	/* ----------------------------- toString ------------------------------ */
	@Override
	public String toString() {
		return _rank + " of " + _suit;
	}
}

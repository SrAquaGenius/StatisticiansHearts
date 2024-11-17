package base;

public class Card {

	private Suit _suit;
	private Rank _rank;

	/* ---------------------------- Constructor ---------------------------- */
	public Card(Suit suit, Rank rank) {
		_suit = suit;
		_rank = rank;
	}

	/* ----------- Getters, Setters and useful general functions ----------- */
	public Suit getSuit() {
		return _suit;
	}

	public Rank getRank() {
		return _rank;
	}

	public int getOrder(RankOrder rankOrder) {
        return rankOrder.getValue(_rank);
    }

	public boolean equals(Rank rank, Suit suit) {
		return _rank == rank && _suit == suit;  
	}


	public String display() {
		return _rank.display() + _suit.display();
	}

	/* ----------------------------- toString ------------------------------ */
	@Override
	public String toString() {
		return display();
		//return _rank + " of " + _suit;
	}
}

package hearts;

import base.Card;
import base.Suit;
import base.Rank;

public class HeartsCard extends Card {

	private final int deckOrder;
	private final int heartsValue;

	/* ---------------------------- Constructor ---------------------------- */
	public HeartsCard(Suit suit, Rank rank) {
		super(suit, rank);
		this.deckOrder = calculateDeckOrder(rank, suit);
		this.heartsValue = calculateHeartsValue(rank, suit);
	}

	/* ----------- Getters, Setters and useful general functions ----------- */
	public int getDeckOrder() {
		return deckOrder;
	}

	public int getHeartsValue() {
		return heartsValue;
	}

	/* ------------------- Calculate Deck Order function ------------------- */
	/** Calculate the card's order in the deck (0-51) */
	private int calculateDeckOrder(Rank rank, Suit suit) {
		HeartsRankOrder rankOrder = new HeartsRankOrder();
		return suit.ordinal() * 13 + rankOrder.getValue(rank);
	}

	/* ------------------ Calculate Hearts Value function ------------------ */
	/** Calculate the Hearts value for scoring */
	private int calculateHeartsValue(Rank rank, Suit suit) {
		if (suit == Suit.HEARTS) {
			return 1; // All hearts are worth 1 point
		}
		else if (suit == Suit.SPADES && rank == Rank.QUEEN) {
			return 13; // Queen of Spades is worth 13 points
		}
		else return 0; // Other cards have no point value
	}

	/* ----------------------------- toString ------------------------------ */

	public String display() {
		return super.display();
	}

	@Override
	public String toString() {
		return super.toString() + " (Deck Order: " + deckOrder + ", Hearts Value: " + heartsValue + ")";
	}
}

package hearts;

import base.Card;
import base.Suit;
import base.Rank;

public class HeartsCard extends Card {
    public HeartsCard(Suit suit, Rank rank) {
        super(suit, rank);
    }

    @Override
    public int getValue() {
        if (getSuit() == Suit.HEARTS) return 1;
        if (getSuit() == Suit.SPADES && getRank() == Rank.QUEEN) return 13;
        return 0;
    }
}

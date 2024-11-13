package hearts;

import base.Deck;
import base.Suit;
import base.Rank;

public class HeartsDeck extends Deck<HeartsCard> {
	@Override
    protected void initializeDeck() {
        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) {
                cards.add(new HeartsCard(suit, rank));
            }
        }
    }
}

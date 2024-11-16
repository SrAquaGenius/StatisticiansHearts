package hearts;

import java.util.List;

import base.Hand;
import base.Player;

public class HeartsPlayer extends Player<HeartsCard> {
	private Hand<HeartsCard> collectedCards;

	public HeartsPlayer() {
		super();
		collectedCards = new Hand<HeartsCard>();
	}

	public void addCollectedCard(HeartsCard card) {
		collectedCards.add(card);
	}

	public void addCollectedCards(List<HeartsCard> cards) {
		collectedCards.addAll(cards);
	}

	public void clearCollectedCards() {
		collectedCards.clear();
	}

	public Hand<HeartsCard> getCollectedCards() {
		return collectedCards;
	}
}

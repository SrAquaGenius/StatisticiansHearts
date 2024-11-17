package hearts;

import base.RankOrder;
import java.util.Comparator;

public class HeartsCardComparator implements Comparator<HeartsCard> {
	private final RankOrder rankOrder;

	public HeartsCardComparator(RankOrder rankOrder) {
		this.rankOrder = rankOrder;
	}

	@Override
	public int compare(HeartsCard card1, HeartsCard card2) {
		int order1 = rankOrder.getValue(card1.getRank());
		int order2 = rankOrder.getValue(card2.getRank());

		// Sort by suit first, then rank
		int suitComparison = card1.getSuit().compareTo(card2.getSuit());
		if (suitComparison != 0) {
			return suitComparison;
		}
		return Integer.compare(order1, order2);
	}
}

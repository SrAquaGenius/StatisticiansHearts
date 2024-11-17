package hearts;

import base.Rank;
import base.RankOrder;

public class HeartsRankOrder implements RankOrder {
    @Override
    public int getValue(Rank rank) {
		if (rank == Rank.ACE) {
			return 13;
		}
		else return rank.ordinal();
    }
}

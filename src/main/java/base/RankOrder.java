package base;

public interface RankOrder {

	/** Determines the value of a rank in a game-specific order.
	 *  @param rank the rank to evaluate
	 *  @return the value of the rank in this game's order */
	int getValue(Rank rank);
}

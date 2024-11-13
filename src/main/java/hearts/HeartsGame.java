package hearts;

import base.Player;

import java.util.ArrayList;
import java.util.List;

public class HeartsGame {
	private HeartsDeck deck;
	private List<Player<HeartsCard>> players;

	public HeartsGame(int numPlayers) {
		deck = new HeartsDeck();
		players = new ArrayList<>();
		for (int i = 0; i < numPlayers; i++) {
			players.add(new Player<HeartsCard>());
		}
	}

	public void startGame() {
		deck.shuffle();
		int cardsPerPlayer = deck.getDeckSize() / players.size();
		for (Player<HeartsCard> player : players) {
			player.getHand().addAll(deck.deal(cardsPerPlayer));
		}
	}

	public void playRound() {
		// Add logic for playing a round in Hearts
	}

	public void calculateScores() {
		// Calculate scores based on Hearts rules
	}
}

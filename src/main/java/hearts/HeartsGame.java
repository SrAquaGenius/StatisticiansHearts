package hearts;

import base.Player;
import base.Rank;
import base.Suit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner; 

public class HeartsGame {
	private HeartsDeck deck;
	private List<HeartsPlayer> players;
	private int numPlayers;

	private int roundNumber = 0;

	public int MAX_POINTS = 100;

	private Scanner scanner;

	public HeartsGame(int numPlayers) {
		this.numPlayers = numPlayers;
		players = new ArrayList<>();
		for (int i = 0; i < numPlayers; i++) {
			players.add(new HeartsPlayer());
		}
		scanner = new Scanner(System.in);
	}

	public void startGame() {
		while (true) {
			if (isGameFinished()) return;

			resetDeck();
			dealDeck();
			setStartingPlayer();

			while(deck.getDeckSize() > 0) {
				playRound();
			}
		}		
	}

	public void resetDeck() {
		deck = new HeartsDeck();
		deck.shuffle();
	}

	public void dealDeck() {
		int cardsPerPlayer = deck.getDeckSize() / players.size();
		for (Player<HeartsCard> player : players) {
			player.getHand().addAll(deck.deal(cardsPerPlayer));
		}
	}

	private void setStartingPlayer() {
		int startingIndex = -1;
		
		// Search for the player who has the "2 of Clubs"
		for (int i = 0; i < players.size(); i++) {
			Player<HeartsCard> player = players.get(i);
			for (HeartsCard card : player.getHand()) {
				if (card.equals(Rank.TWO, Suit.CLUBS)) {
					startingIndex = i;
					break;
				}
			}
			if (startingIndex != -1) break;  // Exit the outer loop if found
		}

		// Rotate the players list if we found the starting player
		if (startingIndex != -1) {
			Collections.rotate(players, -startingIndex);
			System.out.println("Starting player set: Player " + startingIndex);
		}
		else {
			System.out.println("2 of Clubs not found. Starting player not set.");
		}
	}

	public void playRound() {
		roundNumber++;
		System.out.println("Playing round " + roundNumber + "");
		
	}

	public boolean isGameFinished() {
		for (int p = 0; p < numPlayers; p++) {
			if (players.get(p).getPoints() >= MAX_POINTS) {
				calculateScores();
				return true;
			}
		}
		return false;
	}

	public void calculateScores() {
		// Calculate scores based on Hearts rules
	}
}

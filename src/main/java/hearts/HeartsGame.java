package hearts;

import base.Hand;
import base.Player;
import base.Rank;
import base.Suit;

import utils.Debug;

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
			String name = "" + ((char) (65 + i));
			players.add(new HeartsPlayer(name));
		}
		scanner = new Scanner(System.in);
	}

	public void startGame() {
		if (isGameFinished()) return;
		resetDeck();
		dealDeck();
		Debug.todoMsg("Give 3 cards to the next player");
		setStartingPlayer();
		while(players.get(0).getHand().size() > 0) {
			playRound();
		}
	}

	public void resetDeck() {
		Debug.place();
		deck = new HeartsDeck();
		deck.shuffle();
	}

	public void dealDeck() {
		Debug.place();
		int cardsPerPlayer = deck.getDeckSize() / players.size();
		for (int p = 0; p < players.size(); p++) {
			HeartsPlayer player = players.get(p);
			player.getHand().addAll(deck.deal(cardsPerPlayer));
			player.sortHand();
			Debug.print("Player " + player.getName() + ": " + player.getHand().display());
		}
	}

	/** Set who is the starting player */
	private void setStartingPlayer() {
		Debug.place();
		int startingIndex = searchStartingIndex();

		// Rotate the players list if we found the starting player
		if (startingIndex != -1) {
			Collections.rotate(players, -startingIndex);
			System.out.println("Starting player set: Player " + ((char) (startingIndex + 65)));
		}
		else {
			System.out.println("2 of Clubs not found. Starting player not set.");
		}
	}

	/** Search for the index of the player who has the "2 of Clubs" */
	private int searchStartingIndex() {
		Debug.place();
		for (int i = 0; i < players.size(); i++) {
			Player<HeartsCard> player = players.get(i);
			for (HeartsCard card : player.getHand().getCards()) {
				if (card.equals(Rank.TWO, Suit.CLUBS)) {
					return i;
				}
			}
		}
		return -1;
	}

	/* --------------------------------------------------------------------- */
	public void playRound() {
		Debug.print("Round number: " + roundNumber);
		for (int i = 0; i < players.size(); i++) {
			Player<HeartsCard> player = players.get(i);
			player.getHand().remove(0);
			Debug.print("Player " + player.getName() + " now has " + player.getHand().size() + " cards.");
		}
		roundNumber++;
	}

	/* --------------------- Is Game Finished Function --------------------- */
	public boolean isGameFinished() {
		for (int p = 0; p < numPlayers; p++) {
			if (players.get(p).getPoints() >= MAX_POINTS) {
				calculateScores();
				return true;
			}
		}
		return false;
	}

	/* --------------------- Calculate Score Function ---------------------- */
	public void calculateScores() {
		// Calculate scores based on Hearts rules
	}
}

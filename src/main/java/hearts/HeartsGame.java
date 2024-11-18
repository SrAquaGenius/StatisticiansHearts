package hearts;

import base.Player;
import base.Rank;
import base.Suit;

import utils.Debug;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HeartsGame {

	private HeartsDeck deck;
	private List<HeartsPlayer> players;

	private int roundNumber = 0;
	public int MAX_POINTS = 100;

	/* ---------------------------- Constructor ---------------------------- */
	public HeartsGame(int numPlayers) {
		players = new ArrayList<>(numPlayers);
		for (int i = 0; i < numPlayers; i++) {
			String name = "" + ((char) (65 + i));
			players.add(new HeartsPlayer(name));
		}
	}

	/* ------------------------ Start Game Function ------------------------ */
	public void startGame() {

		while (!isGameFinished()) {
			resetDeck();
			dealDeck();
			Debug.todoMsg("Give 3 cards to the next player");
			setStartingPlayer();
			while(players.get(0).getHand().size() > 0) {
				playRound();
			}
		}
		
		displayCollectedCards();
	}

	/* ------------------------ Reset Deck Function ------------------------ */
	public void resetDeck() {
		Debug.place();
		deck = new HeartsDeck();
		deck.shuffle();
	}

	/* ------------------------ Deal Deck Function ------------------------- */
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

	/* ------------------- Set Starting Player Function -------------------- */
	private void setStartingPlayer() {
		Debug.place();

		int startIndex = -1;

		for (int i = 0; i < players.size(); i++) {
			Player<HeartsCard> player = players.get(i);
			for (HeartsCard card : player.getHand().getCards()) {
				if (card.equals(Rank.TWO, Suit.CLUBS)) {
					startIndex = i;
					break;
				}
			}
			if (startIndex != -1) break;
		}

		rotatePlayerList(startIndex);
	}

	/* -------------------- Rotate Player List Function -------------------- */
	private void rotatePlayerList(int startIndex) {
		if (startIndex != -1) {
			System.out.println("Starting player set: Player "
				+ players.get(startIndex).getName());
			Collections.rotate(players, -startIndex);
		}
		else {
			System.out.println("2 of Clubs not found. Starting player not set.");
		}
	}

	/* ------------------------ Play Round Function ------------------------ */
	private void playRound() {
		HeartsRound round = new HeartsRound(players, roundNumber);
        int winnerIndex = round.play();
        rotatePlayerList(winnerIndex);
        roundNumber++;
	}

	/* ----------------- Display Collected Cards Function ------------------ */
	private void displayCollectedCards() {
		for (HeartsPlayer player : players) {
			Debug.print("Player " + player.getName() + " " + player.getCollectedCards().display());
		}
	}	

	/* --------------------- Is Game Finished Function --------------------- */
	public boolean isGameFinished() {
		for (int p = 0; p < players.size(); p++) {
			if (players.get(p).getPoints() >= MAX_POINTS) {
				calculateScores();
				return true;
			}
		}
		return false;
	}

	/* --------------------- Calculate Score Function ---------------------- */
	public void calculateScores() {
		// TODO
	}
}

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
			players.add(new HeartsPlayer());
		}
		scanner = new Scanner(System.in);
	}

	public void startGame() {
		if (isGameFinished()) return;
		resetDeck();
		dealDeck();
		// Give 3 cards to the next player
		setStartingPlayer();
		while(deck.getDeckSize() - numPlayers >= 0) {
			//playRound();
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
		for (Player<HeartsCard> player : players) {
			player.getHand().addAll(deck.deal(cardsPerPlayer));
		}
	}

	private void setStartingPlayer() {
		Debug.place();

		int startingIndex = -1;
		
		// Search for the player who has the "2 of Clubs"
		for (int i = 0; i < players.size(); i++) {
			Player<HeartsCard> player = players.get(i);
			for (HeartsCard card : player.getHand().getCards()) {
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
		Hand<HeartsCard> onTable = new Hand<HeartsCard>();
		Suit leadingSuit = Suit.CLUBS;
		boolean firstCard = true;
	
		// Then each player chooses a card to play (except the player who already played the 2 of Clubs)
		for (int p = 0; p < players.size(); p++) {
			HeartsPlayer player = players.get(p);

			// The first card is always the two of clubs
			if (p == 0 && firstCard) {
				onTable.add(player.playCard(Rank.TWO, Suit.CLUBS));
				firstCard = false;
				continue;
			}

			System.out.println("Player " + p + "'s hand: " + player.getHand());
			System.out.print("Choose a card to play (0 to " + (player.getHand().size() - 1) + "): ");
			int cardIndex = scanner.nextInt();
	
			HeartsCard selectedCard = player.getHand().get(cardIndex);
			//player.getHand().remove(selectedCard);
			onTable.add(selectedCard);
	
			// Set leading suit based on the first card played
			if (leadingSuit == null) {
				leadingSuit = onTable.get(0).getSuit();
			}
	
			System.out.println("Player " + p + " played: " + selectedCard);
		}
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

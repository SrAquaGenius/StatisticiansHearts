package hearts;

import java.util.List;
import java.util.Scanner;

import base.Hand;
import base.Player;
import utils.Debug;

public class HeartsRound {
	
	private List<HeartsPlayer> players;
	private Hand<HeartsCard> onTable;
	private int roundNumber;
	private Scanner scanner;

	/* ---------------------------- Constructor ---------------------------- */
	public HeartsRound(List<HeartsPlayer> players, int roundNumber) {
        this.players = players;
        this.roundNumber = roundNumber;
        scanner = new Scanner(System.in);
        onTable = new Hand<HeartsCard>();
    }

	/* --------------------------- Play Function --------------------------- */
	public int play() {
        Debug.print("Round number: " + roundNumber);

        playCards();
        Debug.print(onTable.display());

        int winnerIndex = findRoundWinner();
        Debug.print("Winning card: " + onTable.get(winnerIndex).display());

        collectCards(winnerIndex);
        return winnerIndex;
    }

	/* ------------------------ Play Cards Function ------------------------ */
	private void playCards() {
        for (HeartsPlayer player : players) {
            Hand<HeartsCard> hand = player.getHand();
            System.out.println(player.display() + ": " + hand.display());

            int selectedIndex = getPlayerCardChoice(hand);
            HeartsCard playedCard = player.playCard(selectedIndex);

            onTable.add(playedCard);
            Debug.print("Player " + player.getName() + " played " + playedCard.display());
        }
    }

	/* ------------------ Get Player Card Choice Function ------------------ */
	private int getPlayerCardChoice(Hand<HeartsCard> hand) {
        int selectedIndex;
        while (true) {
            System.out.print("Choose a card to play (index): ");
            try {
                selectedIndex = Integer.parseInt(scanner.nextLine());
                if (selectedIndex >= 0 && selectedIndex < hand.size()) {
                    return selectedIndex;
                }
                System.out.println("Invalid index. Try again.");
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            }
        }
    }

	/* -------------------- Find Round Winner Function --------------------- */
	private int findRoundWinner() {
        int winnerIndex = 0;
        HeartsCard highestCard = onTable.get(0);

        for (int i = 1; i < onTable.size(); i++) {
            HeartsCard currentCard = onTable.get(i);
            if (currentCard.getSuit() == highestCard.getSuit() &&
                currentCard.getDeckOrder() > highestCard.getDeckOrder()) {
                winnerIndex = i;
                highestCard = currentCard;
            }
        }
        return winnerIndex;
    }

	/* ---------------------- Collect Cards Function ----------------------- */
	private void collectCards(int winnerIndex) {
        HeartsPlayer winner = players.get(winnerIndex);
        while (!onTable.isEmpty()) {
            winner.addCollectedCard(onTable.remove(0));
        }
        Debug.print("Player " + winner.getName() + " collected all cards.");
    }
}

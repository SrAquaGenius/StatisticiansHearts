package game;

import model.Card;
import model.Rank;
import model.Suit;

public class Main {
	public static void main(String[] args) {
		System.out.println("Welcome to the Hearts Game!");
		Card card = new Card(Suit.HEARTS, Rank.QUEEN);
		System.out.println(card);  // Outputs "QUEEN of HEARTS"
	}
}
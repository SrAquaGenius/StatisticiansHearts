package game;

import hearts.HeartsGame;

public class Main {
	public static void main(String[] args) {
		System.out.println("Welcome to the Hearts Game!");

		HeartsGame game = new HeartsGame(4);
		game.startGame();
	}
}
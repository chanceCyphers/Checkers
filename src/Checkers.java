import gameLogic.GameState;
import gameLogic.GameStateManager;

import java.util.Scanner;


public class Checkers {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		
		System.out.println("Would you like to go first or second?");
		int moveFirstOrSecond = keyboard.nextInt();
		
		Game game = new Game(moveFirstOrSecond);
		game.startGame();
		
	}
}

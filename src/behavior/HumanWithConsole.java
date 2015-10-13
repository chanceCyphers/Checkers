package behavior;

import gameLogic.GameStateManager;
import gameLogic.Move;

import java.util.Scanner;

public class HumanWithConsole implements MoveStrategy{

	public void makeMove(GameStateManager gsm) {
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Enter a move (two numbers for column and row FROM and two for column and row TO)");
		int xFrom = keyboard.nextInt();
		int yFrom = keyboard.nextInt();
		int xTo = keyboard.nextInt();
		int yTo = keyboard.nextInt();
		
		Move move = new Move(xFrom, yFrom, xTo, yTo);
		boolean success = gsm.attemptMove(move);
		
		if (!success) System.out.println("made a bad move");
	}

	
	
}

package behavior;

import gameLogic.GameStateManager;
import gameLogic.Move;

import java.util.Scanner;

public class HumanWithConsole extends MoveStrategy{

	public void makeMove(GameStateManager gsm) {
		boolean success = false;
		Move move = null;
		while (success == false){
			Scanner keyboard = new Scanner(System.in);
			
			//get in the change they made
			System.out.println("Enter in the square number for the move you want to make (From then To)");
			
			int from = keyboard.nextInt();
			int to = keyboard.nextInt();
			
			//now get the actual notation
			
			int xFrom = gsm.getTheXPosition(from);
			int yFrom = gsm.getTheYPosition(from);
			int xTo = gsm.getTheXPosition(to);
			int yTo = gsm.getTheYPosition(to);
			
			move = new Move(xFrom, yFrom, xTo, yTo);
			success = gsm.attemptMove(move, color);
			if (success == true)
				gsm.executeMove(move);
			else
				System.out.println("Invalid Move");
		}
		
	}

	
	
}

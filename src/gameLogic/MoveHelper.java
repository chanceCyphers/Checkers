package gameLogic;

import java.util.ArrayList;

public class MoveHelper {

	public static ArrayList<Move> getAllLegalMoves_Red(GameState state, ArrayList<GamePiece> pieces) {
		ArrayList<Move> legalMoves = new ArrayList<Move>();
		
		legalMoves.addAll(findJumps_Red(state, pieces));
		
		return null;
	}

	private static ArrayList<Move> findJumps_Red(GameState state, ArrayList<GamePiece> pieces) {
		//jumps to the top-right
		for (int i = 0 ; i < 6 ; i++) {
			for (int j = 0 ; j < 6 ; j++) {
				//if there's an enemy to the top right
				if (state.getStateOfSquare(i+1, j+1) == GameState.BLACK || state.getStateOfSquare(i+1, j+1) == GameState.BLACK_KING) {
					//and no piece behind it
					
				}
			}
		}
		
		return null;
	}
	
}

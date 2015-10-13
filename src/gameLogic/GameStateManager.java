package gameLogic;

public class GameStateManager {

	private GameState gameState;
	
	public GameStateManager(GameState gameState) {
		this.gameState = gameState;
		setNewGame();
	}
	
	public GameState getGameState() {
		return gameState;
	}
	
	//returns true if valid move (doesn't check right now)
	public boolean attemptMove(Move move) {
		int squareState = gameState.getStateOfSquare(move.xFrom, move.yFrom);
		gameState.setStateOfSquare(GameState.EMPTY, move.xFrom, move.yFrom);
		gameState.setStateOfSquare(squareState, move.xTo, move.yTo);
		
		return true;
	}
	
	public boolean checkWin() {
		return false;
	}
	
	public void setNewGame() {
		gameState.setStateOfSquare(GameState.RED, 0, 0);
		gameState.setStateOfSquare(GameState.RED, 2, 0);
		gameState.setStateOfSquare(GameState.RED, 4, 0);
		gameState.setStateOfSquare(GameState.RED, 6, 0);
		gameState.setStateOfSquare(GameState.RED, 1, 1);
		gameState.setStateOfSquare(GameState.RED, 3, 1);
		gameState.setStateOfSquare(GameState.RED, 5, 1);
		gameState.setStateOfSquare(GameState.RED, 7, 1);
		gameState.setStateOfSquare(GameState.RED, 0, 2);
		gameState.setStateOfSquare(GameState.RED, 2, 2);
		gameState.setStateOfSquare(GameState.RED, 4, 2);
		gameState.setStateOfSquare(GameState.RED, 6, 2);
		
		gameState.setStateOfSquare(GameState.BLACK, 1, 7);
		gameState.setStateOfSquare(GameState.BLACK, 3, 7);
		gameState.setStateOfSquare(GameState.BLACK, 5, 7);
		gameState.setStateOfSquare(GameState.BLACK, 7, 7);
		gameState.setStateOfSquare(GameState.BLACK, 0, 6);
		gameState.setStateOfSquare(GameState.BLACK, 2, 6);
		gameState.setStateOfSquare(GameState.BLACK, 4, 6);
		gameState.setStateOfSquare(GameState.BLACK, 6, 6);
		gameState.setStateOfSquare(GameState.BLACK, 1, 5);
		gameState.setStateOfSquare(GameState.BLACK, 3, 5);
		gameState.setStateOfSquare(GameState.BLACK, 5, 5);
		gameState.setStateOfSquare(GameState.BLACK, 7, 5);	
	}
}

package gameLogic;

public class GameState {
	
	private int[][] board;
	
	public static final int EMPTY = 0;
	public static final int BLACK = 1;
	public static final int RED = 2;
	public static final int BLACK_KING = 3;
	public static final int RED_KING = 4;
	
	public GameState() {
		board = new int[8][8];
		
		//initialize board to empty
		for (int i = 0 ; i < 8 ; i++) {
			for (int j = 0 ; j < 0 ; j++) {
				board[i][j] = EMPTY;
			}
		}
	}
	
	public int getStateOfSquare(int column, int row) {
		return board[column][row];
	}
	
	void setStateOfSquare(int state, int column, int row) {
		board[column][row] = state;
	}
}

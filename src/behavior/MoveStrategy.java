package behavior;

import gameLogic.GameStateManager;
import gameLogic.Move;

public interface MoveStrategy {

	public void makeMove(GameStateManager gsm);
	
}

package behavior;

import gameLogic.GameStateManager;
import gameLogic.Move;

public abstract class MoveStrategy {
	int color;
	
	public int getColor(){
		return color;
		
	}
	
	public void setColor(int newColor){
		color = newColor;
		
	}

	public void makeMove(GameStateManager gsm){
		
	}
	
}

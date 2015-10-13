package gui;

import gameLogic.GameState;
import gameLogic.GameStateManager;

import javax.swing.JFrame;

public class GameGUI {

	private JFrame gameFrame;
	private BoardPanel drawPanel;
	
	public GameGUI() {
		drawPanel = new BoardPanel();
		
		gameFrame = new JFrame();		
		gameFrame.add(drawPanel);
		
		gameFrame.setTitle("Checkers");
		gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gameFrame.setSize(720,720);
		gameFrame.setResizable(false);
		gameFrame.setVisible(true);
		
		GameStateManager gsm = new GameStateManager(new GameState());
		
		drawPanel.updatePiecesToDraw(gsm.getGameState());
	}

	public void render(GameState state) {
		drawPanel.updatePiecesToDraw(state);
		drawPanel.repaint();
	}
}

package gui;

import gameLogic.GameState;
import gameLogic.Pair;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class BoardPanel extends JPanel {
	
	private ArrayList<Pair> blackPieces;
	private ArrayList<Pair> whitePieces;
	private ArrayList<Pair> blackKings;
	private ArrayList<Pair> whiteKings;
	
	private BufferedImage blackPieceImg;
	private BufferedImage whitePieceImg;
	private BufferedImage blackKingImg;
	private BufferedImage whiteKingImg;
	
	public BoardPanel() {
		super();
		blackPieces = new ArrayList<Pair>();
		whitePieces = new ArrayList<Pair>();
		blackKings = new ArrayList<Pair>();
		whiteKings = new ArrayList<Pair>();
		
		try {
			blackPieceImg = ImageIO.read(new File("res/B_man.png"));
			whitePieceImg = ImageIO.read(new File("res/R_man.png"));
			blackKingImg = ImageIO.read(new File("res/B_king.png"));
			whiteKingImg = ImageIO.read(new File("res/R_king.png"));
		} catch (Exception e) {
			System.out.println("image reading error of some sort");
		}
	}
	
	void updatePiecesToDraw(GameState state) {
		whitePieces.clear();
		blackPieces.clear();
		whiteKings.clear();
		blackKings.clear();
		
		for (int i = 0 ; i < 8 ; i++) {
			for (int j = 0 ; j < 8 ; j++) {
				int squareState = state.getStateOfSquare(i, j);
				switch (squareState) {
				case GameState.EMPTY:
					break;
				case GameState.BLACK:
					blackPieces.add(new Pair(i, j));
					break;
				case GameState.RED:
					whitePieces.add(new Pair(i, j));
					break;					
				case GameState.BLACK_KING:
					blackKings.add(new Pair(i, j));
					break;
				case GameState.RED_KING:
					whiteKings.add(new Pair(i, j));
					break;
				}
			}
		}
	}
	
	public void paint(Graphics g) {
		drawBoard(g);
		
		drawPieces(g);
	}
	
	private void drawBoard(Graphics g) {
		int squareHeight = getHeight() / 8;
		int squareWidth = getWidth() / 8;
		
		g.fillRect(0, 0, squareWidth, squareHeight);
		for (int i = 0 ; i < 8 ; i++) {
			for (int j = 0 ; j < 8 ; j++) {
				if (i % 2 == j % 2) g.setColor(Color.gray);
				else g.setColor(Color.black);
				
				g.fillRect(i * squareWidth, j * squareHeight, squareWidth, squareHeight);	
			}
		}
	}
	
	private void drawPieces(Graphics g) {
		int squareHeight = getHeight() / 8;
		int squareWidth = getWidth() / 8;
		int padding = (squareWidth - blackPieceImg.getWidth()) / 2;
		
		for (Pair piece : blackPieces) {
			g.drawImage(blackPieceImg, 
					(piece.x * squareWidth) + padding, 
					getHeight() - squareHeight - (piece.y * squareHeight) + padding, 
					null);  
		}
		for (Pair piece : whitePieces) {
			g.drawImage(whitePieceImg, 
					(piece.x * squareWidth) + padding, 
					getHeight() - squareHeight - (piece.y * squareHeight) + padding, 
					null);   
		}
		for (Pair piece : whiteKings) {
			g.drawImage(whiteKingImg, 
					(piece.x * squareWidth) + padding, 
					getHeight() - squareHeight - (piece.y * squareHeight) + padding, 
					null);   
		}
		for (Pair piece : blackKings) {
			g.drawImage(blackKingImg, 
					(piece.x * squareWidth) + padding, 
					getHeight() - squareHeight - (piece.y * squareHeight) + padding, 
					null);   
		}
	}
}
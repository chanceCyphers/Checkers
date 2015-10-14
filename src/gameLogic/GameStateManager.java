package gameLogic;

import java.util.ArrayList;

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
    public boolean attemptMove(Move move, int color) {
        boolean flag = true;
        ArrayList<Move> jumps = canJump(color);
        //make sure the to and from values don't go out of bounds
        if (move.xFrom > 7 || move.yFrom > 7 || move.xTo > 7 || move.yTo > 7 ||
        	move.xFrom < 0 || move.yFrom < 0 || move.xTo < 0 || move.yTo < 0 ){
            System.out.println("out of bounds");
            return false;
        }
        int stateOfFrom = gameState.getStateOfSquare(move.xFrom, move.yFrom);
        int stateOfTo = gameState.getStateOfSquare(move.xTo, move.yTo);
        

        //if there in no piece in the "from" location return false
        if (stateOfFrom == 0){
            System.out.println("no piece at 'from'");
            return false;
        }
        
        //if there is a piece in the "to" location return false
        if (!(stateOfTo == 0)){
            System.out.println("'to' is not empty");
            return false;
        }
        
        //if the "from" piece is not the correct color return false
        if (!(gameState.getStateOfSquare(move.xFrom, move.yFrom)%2 == color))
        {
            System.out.println("that is not your piece");
            return false;
        }
        
        //check if the "from" piece is moving in the right direction
        if (jumps.isEmpty() == false) //if there are jumps.
        {
            System.out.println("there are jumps");
            //for every possible jump
            for (int i=0; i<jumps.size(); i++){
            	//if this move matches a possible jump then it is valid
            	System.out.println("is this jump "+ i + "?");
            	if ((move.xFrom == jumps.get(i).xFrom)&&
            			(move.yFrom == jumps.get(i).yFrom)&&
            			(move.xTo == jumps.get(i).xTo)&&
            			(move.yTo == jumps.get(i).yTo)){
            		System.out.println("yes");
            		return true;
            	}
            	else{
            		System.out.println("there are possible jumps");
            	}
            		
            	
            }
            return false;
            
            //handle jumps
        }
        //moving diagonally
        else{
            if (move.xTo == move.xFrom + 1 || move.xTo == move.xFrom - 1){
                //if (stateOfFrom >= 3) 
                //if piece is king it can move both forward and back
                if (stateOfFrom >= 3 && (move.yTo == move.yFrom + 1 || move.yTo == move.yFrom - 1)){
                    
                }
                //red can only move up
                else if(color == 0 && (move.yTo == move.yFrom + 1)){
                    
                }
                //black can only move down
                else if(color == 1 && (move.yTo == move.yFrom - 1)){
                    
                }
                else{
                    System.out.println("wrong way");
                    return false;
                }
            }
            else{
                System.out.println("too far away");
                return false;
            }
            
        }
        
        return flag;
    }
    
    public ArrayList<Move> canJump(int color) {
        ArrayList<Move> jumps = new ArrayList<Move>();
        
        //search the board for jumps of your color
        System.out.println("looking for jumps");
        for (int i=0; i<8; i++){
        	for(int j=0; j<8; j++){
        		//if the piece is the right color
        		if ((gameState.getStateOfSquare(i, j) != 0)&&(gameState.getStateOfSquare(i, j)%2 == color)){
        			System.out.println("found a piece you own");
        			jumps.addAll(possibleJumps(color, i, j));
        		}
        	}
        }
        return jumps;
    }
    
    public ArrayList<Move> possibleJumps(int color, int i, int j) {
        ArrayList<Move> jumps = new ArrayList<Move>();
		
			//check if diagonal is out of bounds then
        
			//if any diagonal pieces are not empty and not your color
			//up left
        if(color == 0 || gameState.getStateOfSquare(i,j) >= 3){ // if player is red
			if (i-1 > 0 && j+1 < 7){
    			if (gameState.getStateOfSquare(i-1, j+1) != 0 && gameState.getStateOfSquare(i-1, j+1)%2 != color){
    				//if the space beyond is empty add the move to the list
    				if (gameState.getStateOfSquare(i-2, j+2) == 0){
    					System.out.println("added jump");
//    					ArrayList<Move> multiJump = possibleJumps(color, 0 ,0);
//    					if (jumps.isEmpty() == false){ // if there are more jumps
//    						jumps.addAll(multiJump);
//    					}
//    					else
    						jumps.add(new Move(i, j, i-2, j+2));
    				}
    			}
			}
			
			// up right
			if (i+1 < 7 && j+1 < 7){
    			if (gameState.getStateOfSquare(i+1, j+1) != 0 && gameState.getStateOfSquare(i+1, j+1)%2 != color){
    				//if the space beyond is empty add the move to the list
    				if (gameState.getStateOfSquare(i+2, j+2) == 0){
    					System.out.println("added jump");
    					jumps.add(new Move(i, j, i+2, j+2));
    				}
    			}
			}
        }
        if(color == 1 || gameState.getStateOfSquare(i,j) >= 3){ // if player is black
			// down left
			if (i-1 > 0 && j-1 > 0){
    			if (gameState.getStateOfSquare(i-1, j-1) != 0 && gameState.getStateOfSquare(i-1, j-1)%2 != color){
    				//if the space beyond is empty add the move to the list
    				if (gameState.getStateOfSquare(i-2, j-2) == 0){
    					System.out.println("added jump");
    					jumps.add(new Move(i, j, i-2, j-2));
    				}
    			}
			}
			
			//down left
			if (i+1 < 7 && j-1 > 0){
    			if (gameState.getStateOfSquare(i+1, j-1) != 0 && gameState.getStateOfSquare(i+1, j-1)%2 != color){
    				//if the space beyond is empty add the move to the list
    				if (gameState.getStateOfSquare(i+2, j-2) == 0){
    					System.out.println("added jump");
    					jumps.add(new Move(i, j, i+2, j-2));
    				}
    			}
			}
        }
			
		else;
		return jumps;
    }

    //executes a given move
    public void executeMove(Move move){
        //System.out.println(gameState.getStateOfSquare(move.xFrom, move.yFrom));
        //System.out.println(gameState.getStateOfSquare(move.xTo, move.yTo));
        int squareState = gameState.getStateOfSquare(move.xFrom, move.yFrom);
        gameState.setStateOfSquare(GameState.EMPTY, move.xFrom, move.yFrom);
        gameState.setStateOfSquare(squareState, move.xTo, move.yTo);
        //if red and moved to the top row and not a king, put red king in 'to'
        if (squareState == 2 && move.yTo == 7){
            gameState.setStateOfSquare(4, move.xTo, move.yTo);
        }
        //if black and moved to bottom row and not a king, put black king in 'to'
        if (squareState == 1 && move.yTo == 0){
            gameState.setStateOfSquare(5, move.xTo, move.yTo);
        }
        //if you move more than one space (jump)
        if (Math.abs(move.yFrom - move.yTo) > 1 || Math.abs(move.xFrom - move.xTo) > 1 ){
        	System.out.println("there was a jump made attempting to delete peice");
        	
        	int xRemove = 0;
        	int yRemove = 0;
        	
        	if(move.yFrom - move.yTo > 1){
        		yRemove = move.yFrom - 1;
        	}
        	else if(move.yFrom - move.yTo < 1){
        		yRemove = move.yFrom + 1;
        	}
        	
        	if(move.xFrom - move.xTo > 1){
        		xRemove = move.xFrom - 1;
        	}
        	else if(move.xFrom - move.xTo < 1){
        		xRemove = move.xFrom + 1;
        	}
        	
        	gameState.setStateOfSquare(0, xRemove, yRemove);
        }
    }
    
    public boolean checkWin() {
        int blacks=0;
        int reds=0;
        
        for(int i=0; i<8; i++){
            for(int j=0; j<8; j++){
                //any black pieces
                if(gameState.getStateOfSquare(j, i)==1 || gameState.getStateOfSquare(j, i)==3){
                    blacks += gameState.getStateOfSquare(j, i);
                }
                //any red pieces
                if (gameState.getStateOfSquare(j, i)==2 || gameState.getStateOfSquare(j, i)==4){
                    reds += gameState.getStateOfSquare(j, i);
                }
            }
        }
        
        //win condition here
        //if red wins
        if(blacks==0 && reds>0){
            System.out.println("Red Wins");
            return true;
        }
        //if black wins
        else if(blacks>0 && reds==0){
            System.out.println("Black Wins");
            return true;
        }
        //if none
        else{
            return false;
        }
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
	
	//from notation to our actual grid notation for y
	public int getTheYPosition(int y){
		if(y>=1 && y<=4){
			return 7;
		}
		else if(y>=5 && y<=8){
			return 6;
		}
		else if(y>=9 && y<=12){
			return 5;
		}
		else if(y>=13 && y<=16){
			return 4;
		}
		else if(y>=17 && y<=20){
			return 3;
		}
		else if(y>=21 && y<=24){
			return 2;
		}
		else if(y>=25 && y<=28){
			return 1;
		}
		else{
			return 0;
		}
	}
	
	//from notation to our actual grid notation for x now
	public int getTheXPosition(int x){
			if(x==5 || x==13 || x==21 || x==29){
				return 0;
			}
			else if(x==1 || x==9 || x==17 || x==25){
				return 1;
			}
			else if(x==6 || x==14 || x==22 || x==30){
				return 2;
			}
			else if(x==2 || x==10 || x==18 || x==26){
				return 3;
			}
			else if(x==7 || x==15 || x==23 || x==31){
				return 4;
			}
			else if(x==3 || x==11 || x==19 || x==27){
				return 5;
			}
			else if(x==8 || x==16 || x==24 || x==32){
				return 6;
			}
			else{
				return 7;
			}
	}
}

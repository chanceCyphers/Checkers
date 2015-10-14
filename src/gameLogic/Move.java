package gameLogic;

public class Move {

	public int xFrom, xTo, yFrom, yTo;
	
	public Move(int xFrom, int yFrom, int xTo, int yTo) {
		this.xFrom = xFrom;
		this.yFrom = yFrom;
		this.xTo = xTo;
		this.yTo = yTo;
	}
	
	//set methods
	public void setxFrom(int xFrom){
		this.xFrom=xFrom;
	}
	
	public void setyFrom(int yFrom){
		this.yFrom = yFrom;
	}
	
	public void setxTo(int xTo){
		this.xTo=xTo;
	}
	
	public void setyTo(int yTo){
		this.yTo=yTo;
	}
	
	//get methods
	public int getxFrom(){
		return xFrom;
	}
	
	public int getyFrom(){
		return yFrom;
	}
	
	public int getxTo(){
		return xTo;
	}
	
	public int getyTo(){
		return yTo;
	}
	
}

//written by Timothy Gedney

public class Move {

	//attributes for x & y-axis movements
	private int moveX;
	private int moveY;
	
	//constructor takes in a string
	public Move(String aMove) {
		this.setMove(aMove);
	}
	
	//takes in a string and compares the string to a direction, sets the x & y-axis values to their respective movement
	public void setMove(String aMove) {
		if (aMove.compareToIgnoreCase("right") == 0) {
			this.moveX = 1;
			this.moveY = 0;
		} else if (aMove.compareToIgnoreCase("left") == 0) {
			this.moveX = -1;
			this.moveY = 0;
		} else if (aMove.compareToIgnoreCase("up") == 0) {
			this.moveX = 0;
			this.moveY = -1;
		} else {
			this.moveX = 0;
			this.moveY = 1;
		}
	}
	
	//returns x-axis movement value
	public int getMoveX() {
		return this.moveX;
	}
	
	//returns y-axis movement value
	public int getMoveY() {
		return this.moveY;
	}
}

//written by Timothy Gedney

public class BasicPlayer implements Player {

	//attributes
	private int x;
	private int y;
	private int points;
	
	//constructor
	public BasicPlayer() {
		this.x = 0;
		this.y = 0;
		this.points = 0;
	}
	
	//mutators
	@Override
	public void setx(int xTurn) {
		if (xTurn < 0) {
			this.x = -1;
		} else if (xTurn > 2){
			this.x = 4;
		} else {
			this.x = xTurn;
		}
	}
	
	//checks the x-value as well so that the wrong value output is only output once instead of twice in a row
	@Override
	public void sety(int yTurn) {
		if (yTurn < 0 || getx() < 0) {
			System.out.println("You entered a negative number and quit.");
			this.y = -1;
		} else if (yTurn > 2 || getx() > 2) {
			System.out.println("Coordinates entered outside of bounds. Enter another number.");
			this.y = 4;
		} else {
			this.y = yTurn;
		}
	}
	
	@Override
	public void setPoints(int aPoints) {
		this.points = aPoints;
	}
	
	//accessors
	@Override
	public int getx() {
		return this.x;
	}
	
	@Override
	public int gety() {
		return this.y;
	}
	
	@Override
	public int getPoints() {
		return this.points;
	}

	@Override
	public void choosex() {
		this.x = -1;
	}
	
	@Override
	public void choosey() {
		this.y = -1;
	}

}

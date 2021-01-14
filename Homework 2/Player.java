//written by Timothy Gedney

public class Player {

	//attributes
	private String name;
	private int time;
	
	//default constructor
	public Player() {
		this.name = "Tim";
		this.time = 10;
	}
	
	//sets name value based on String input
	public void setName(String n) {
		this.name = n;
	}
	
	//sets time based on integer input, checks that time entered is between 1-10. sets value to 10 if not
	public void setTime(int t) {
		if (t < 1 || t > 10) {
			System.out.println("Must be between 1-10, set to 10");
			this.time = 10;
		} else {
			this.time = t;
		}
	}
	
	//returns string name
	public String getName() {
		return this.name;
	}
	
	//returns int time
	public int getTime() {
		return this.time;
	}

	//toString of the players name
	@Override
	public String toString() {
		return name;
	}
}

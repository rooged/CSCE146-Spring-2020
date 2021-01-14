//written by Timothy Gedney
import java.util.Random;

public class Potato {

	//attributes
	private Random rand;
	private int time;
	
	//default constructor
	public Potato() {
		rand = new Random();
		time = 0;
	}
	
	//sets time as random value between 180 and 1
	public void setTime() {
		this.time = rand.nextInt(180 - 1);
	}
	
	//returns int time
	public int getTime() {
		return this.time;
	}
}

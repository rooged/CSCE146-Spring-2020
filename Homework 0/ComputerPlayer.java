//written by Timothy Gedney
import java.util.Random;

public class ComputerPlayer extends BasicPlayer {

	//attribute
	private Random rand;
	
	//constructor
	public ComputerPlayer() {
		super();
		rand = new Random();
	}
	
	//chooses random x & y coords between 0 & 2 for computer
	@Override
	public void choosex() {
		int random = rand.nextInt((2 - 0) + 1);
		switch (random) {
		case 0:
			setx(0);
			break;
		case 1:
			setx(1);
			break;
		case 2:
			setx(2);
			break;
		}
	}
	
	@Override
	public void choosey() {
		int random = rand.nextInt((2 - 0) + 1);
		switch (random) {
		case 0:
			sety(0);
			break;
		case 1:
			sety(1);
			break;
		case 2:
			sety(2);
			break;
		}
	}
}

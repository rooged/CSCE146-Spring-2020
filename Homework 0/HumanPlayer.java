//written by Timothy Gedney
import java.util.Scanner;

public class HumanPlayer extends BasicPlayer {

	//attribute
	public Scanner input;
	
	//constructor
	public HumanPlayer() {
		super();
		input = new Scanner(System.in);
	}
	
	//sets the first coordinate from user input, if over 2 sets it to 4 & if below 0 it sets it to -1
	public void choosex() {
		int xCoord = input.nextInt();
		if (xCoord == 0) {
			setx(0);
		} else if (xCoord == 1) {
			setx(1);
		} else if (xCoord == 2) {
			setx(2);
		} else if (xCoord > 2) {
			setx(4);
		} else {
			setx(-1);
		}
	}
	
	//sets the second coordinate from user input, if over 2 sets it to 4 & if below 0 it sets it to -1
	public void choosey() {
		int yCoord = input.nextInt();
		if (yCoord == 0) {
			sety(0);
		} else if (yCoord == 1) {
			sety(1);
		} else if (yCoord == 2) {
			sety(2);
		} else if (yCoord > 2) {
			sety(4);
		} else {
			sety(-1);
		}
	}
	

}

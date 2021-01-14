//written by Timothy Gedney
import java.util.Scanner;

public class RobotCommandSimulator {

	public static void main(String[] args) {
		
		//initialilzes scanner and boolean value
		Scanner input = new Scanner(System.in);
		System.out.println("Welcome to the Robot Simulator.");
		boolean repeat = true;
		
		//while loop repeats until user exits
		while (repeat) {
			//querys user for a board file name and a robot command file name
			System.out.print("Enter a file for the board: ");
			String boardFile = input.nextLine();
			System.out.print("Enter a file for the robot commands: ");
			String moveFile = input.nextLine();
			
			//initializes robot object and begins simulation method
			System.out.println("Simulation start.");
			Robot robot = new Robot(boardFile, moveFile);
			robot.simulation();
			
			//asks user if they want to go again
			System.out.println("Simulation end.");
			System.out.print("Enter 'quit' to exit or anything else to go again: ");
			String answer = input.nextLine();
			if (answer.compareToIgnoreCase("quit") == 0) {
				repeat = false;
			}
			System.out.println();
		}
		//exit
		System.out.print("Goodbye");
		input.close();
	}

}

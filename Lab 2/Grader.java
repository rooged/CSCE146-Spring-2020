//written by Timothy Gedney
import java.util.Scanner;

public class Grader {

	public static void main(String[] args) {
		
		//initiates Scanner, boolean variable to repeat the grader program till exited
		Scanner input = new Scanner(System.in);
		boolean repeat = true;
		System.out.println("Welcome to the Grader Program");
		
		while (repeat) {
			//initializes Student class and querys user for file name
			Student grade = new Student();
			System.out.print("Enter a file name or 'quit' to exit: ");
			String file = input.next();
			//checks if the string entered was 'quit' to exit the program
			if (file.compareToIgnoreCase("quit") == 0) {
				repeat = false;
				break;
			}
			//initiates the reading file method, prints the toString to console
			grade.readGradeFile(file);
			System.out.println(grade.toString());
			System.out.println();
		}
		//exit program
		System.out.print("Goodbye.");
		input.close();
	}

}

//written by Timothy Gedney
import java.util.Scanner;

public class frontEnd {

	public static void main(String[] args) {

		//initiates MineCounter class, Scanner class, and boolean variable for repe
		System.out.println("Welcome to Mine Counter!");
		Scanner input = new Scanner(System.in);
		boolean replay = true;
		MineCounter game = new MineCounter();
		
		while (replay) {
			//sequence of methods are called to create board, add mines, and add counters, printing the board after each one
			System.out.println("Creating empty board.");
			game.createBoard();
			game.printBoard();
			System.out.println("Placing mines.");
			game.addMines();
			game.printBoard();
			System.out.println("Performing mine count.");
			game.countMines();
			game.printBoard();
			
			//asks user for input on whether to continue or not
			System.out.println();
			System.out.println("Enter 1 to go again, 0 to exit.");
			int choice = input.nextInt();
			if (choice == 0) {
				replay = false;
			}
		}
		
		System.out.print("Goodbye.");
		input.close();
	}

}

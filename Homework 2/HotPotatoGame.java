//written by Timothy Gedney
import java.util.Scanner;

public class HotPotatoGame {

	public static void main(String[] args) {
		
		//initializes scanner, boolean value to repeat while loop, potato class, and player class
		Scanner input = new Scanner(System.in);
		boolean repeat = true;
		Potato potato = new Potato();
		Player players = new Player();
		System.out.println("Welcome to the Hot Potato Game!");
		
		//while loop to repeat while someone wants to continue playing the game
		while (repeat) {
			//initializes circular linked list, boolean value for a win, total time value
			CircularLinkedList<Player> list = new CircularLinkedList<Player>();
			boolean win = false;
			int totalTime = 0;
			//sets potato time
			potato.setTime();
			
			//querys user for number of players
			System.out.print("Enter the number of players (2 or more): ");
			int number = input.nextInt();
			input.nextLine();
			//for loop that creates a new node for each player and adds their name
			for (int i = 0; i < number; i++) {
				players = new Player();
				System.out.print("Enter the name for player " + (i + 1) + ": ");
				String name = input.nextLine();
				players.setName(name);
				list.add(players);
			}
			list.resetCurrent();
			
			//while loop to repeat until someone wins
			while (!win) {
				//returns the current players name, asks for a time and adds that to the total time
				System.out.print(list.getName() + " enter a number between 1-10 (the number of seconds you hold the potato): ");
				int time = input.nextInt();
				totalTime += time;
				players.setTime(time);
				
				//if/else statement to check if the person went over the alloted time
				if (totalTime > potato.getTime()) {
					System.out.println("HOT POTATO! " + list.getName() + " has been eliminated.");
					totalTime = 0;
					potato.setTime();
					list.remove();
				} else {
					System.out.println(list.getName() + " is safe now.");
					list.next();
				}
				//checks if there's a winner
				if (list.last()) {
					System.out.println(list.getName() + " has won!");
					win = true;
				}
				System.out.println();
			}
			//asks the user if they want to play again
			System.out.print("Would you like to play again? (Yes/No): ");
			input.nextLine();
			String playAgain = input.nextLine();
			if (playAgain.compareToIgnoreCase("no") == 0) {
				repeat = false;
			}
		}
		//exits
		System.out.print("Goodbye.");
		input.close();
	}
}

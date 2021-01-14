//written by Timothy Gedney
import java.util.Scanner;

public class ShowcaseGame {

	public static void main(String[] args) {
		
		//initiates the scanner, Showcase class, and boolean variable to repeat the game
		Scanner input = new Scanner(System.in);
		Showcase game = new Showcase();
		boolean repeat = true;
		System.out.println("Welcome to the Showcase Showdown!");
		
		//while loop repeats till user quits
		while (repeat) {
			//calls choosePrizes() class to fill the showcase prizes
			System.out.println("Your prizes are: ");
			game.choosePrizes();
			//user guesses and if statement compares their guess to the .totalPrice() and .priceRange()
			System.out.print("You must guess the total cost of all without going over. Enter your guess: ");
			int guess = input.nextInt();
			System.out.println("You guessed " + guess + ", the actual price is " + game.totalPrice());
			if (guess <= game.totalPrice() && guess >= game.priceRange()) {
				System.out.println("Your guess was under! You win!");
			} else if (guess > game.totalPrice()) {
				System.out.println("Your guess was too high. You lose.");
			} else {
				System.out.println("Your guess was way too low. You lose.");
			}
			//asks if user wants to go again
			System.out.print("Would you like to play again? Yes or no to quit: ");
			String choice = input.next();
			System.out.println();
			if (choice.compareToIgnoreCase("no") == 0) {
				repeat = false;
			}
		}
		//exits
		System.out.print("Goodbye.");
		input.close();
	}

}

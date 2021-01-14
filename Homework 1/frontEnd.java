//written by Timothy Gedney
import java.util.Scanner;

public class frontEnd {

	public static void main(String[] args) {
		
		//initiates boolean values, human player, scanner, and board
		boolean repeat = true;
		boolean win = false;
		HumanPlayer user = new HumanPlayer();
		Board board = new Board();
		Scanner input = new Scanner(System.in);
		
		System.out.println("Welcome to Tic Tac Toe Tourney! How many games can you win in a row?");
		
		//while loop to repeat the game until the user exits, restarts at the end of each game
		while (repeat) {
			board.populateBoard();
			board.printBoard();
			//while loop to repeat until someone wins or user exits
			while (!win) {
				System.out.println("Enter the coordinates to place an 'X'. Row then column. Enter a negative number to exit.");
				user.choosex();
				user.choosey();
				//checks if values are below 0 and exits loop if so
				if (user.getx() < 0 || user.gety() < 0) {
					win = true;
					break;
				}
				//checks if the value is greater than 2 and if the space entered is empty, if either are true then it asks for a new input
				while (user.getx() > 2 || user.gety() > 2 || !board.checkEmpty(user.getx(), user.gety())) {
					if (!board.checkEmpty(user.getx(), user.gety())) {
						System.out.println("The space entered is already filled. Enter another number.");
					}
					user.choosex();
					user.choosey();
				}
				//adds users turn to the board array and reprints the board
				board.addTurn(user.getx(), user.gety());
				board.printBoard();
				//checks if this turn won or if the board is now full
				if (board.checkHumanWin() || board.checkFull()) {
					win = true;
					break;
				}
				//pc turn is done inside the board class, then checks if the pc won
				System.out.println("Computer's turn.");
				board.pcTurn();
				board.printBoard();
				if (board.checkPCWin()) {
					win = true;
					break;
				}
			}
			//if else statements to see who won, user, tie, or pc. if user won or a tie, the game automatically restarts. if the pc won, it asks the user if they want to go again
			if (board.checkHumanWin()) {
				user.setPoints(user.getPoints() + 1);
				System.out.println("You won! The computer demands a rematch.");
			} else if (board.checkFull()) {
				System.out.println("The game was a tie.");
			} else {
				System.out.println("You lost but you won " + user.getPoints() + " games in a row.");
				user.setPoints(0);
				System.out.println("Would you like to play again? Yes or no.");
				String answer = input.next();
				if (answer.compareToIgnoreCase("no") == 0) {
					repeat = false;
				}
			}
			win = false;
		}
		//exit statement when user quits & close out scanner
		System.out.println("Goodbye.");
		input.close();
	}

}

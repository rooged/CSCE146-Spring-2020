//written by Timothy Gedney
import java.util.Scanner;
import java.io.File;
import java.io.IOException;

public class Board {
	
	
	//attributes, initializes string 2-D array for board & int array for robots location
	private String[][] board;
	private int[] robot;
	//final attribute for board size
	private static final int SIZE = 10;
	
	//constructor takes in a string file name, initializes the robots starting location and reads the file
	public Board(String fileName) {
		this.robot = new int[] {0,0};
		board = readBoard(fileName);
	}
	
	//takes in two ints to move the robot to a new location on the board
	public void moveRobot(int x, int y) {
		board[robot[0]][robot[1]] = "_";
		this.robot[0] = x;
		this.robot[1] = y;
		board[x][y] = "O";
	}
	
	//checks that the space being moved into is empty
	public boolean checkEmpty(int x, int y) {
		if (board[x][y].compareToIgnoreCase("X") == 0) {
			System.out.println("Robot crashed.");
			return false;
		}
		return true;
	}

	//reads the file named, fills the array, and then returns the string[][] array
	public String[][] readBoard(String file) {
		try {
			//initiates a string[][] array and a fileScanner to read the file
			board = new String[SIZE][SIZE];
			Scanner fileScanner = new Scanner(new File(file));
			//for loop reads through each line of the file & fills the String 'line' with the Scanner output
			for (int i = 0; i < SIZE; i++) {
				String line = fileScanner.nextLine();
				for (int j = 0; j < SIZE; j++) {
					//line is then split into substrings to fill each space of the 10x10 array
					if (j != 10) {
						board[j][i] = line.substring(j, j + 1);
					} else {
						board[j][i] = line.substring(j);
					}
				}
			}
			board[0][0] = "O";
			print();
			fileScanner.close();
			return board;
		}
		//catch blocks for any exceptions
		catch(IOException e) {
			System.out.println(e);
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return null;
	}
	
	//for loop prints out the entire board
	public void print() {
		for (int i = 0; i < SIZE; i++) {
			for (int j = 0; j < SIZE; j++) {
				System.out.print(board[j][i]);
			}
			System.out.println();
		}
	}
}

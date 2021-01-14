//written by Timothy Gedney
import java.util.Scanner;
import java.io.File;
import java.io.IOException;

public class Robot {
	
	
	//attributes, initializes space array for the robots location, linked list, and board class
	private int[] space;
	private LinkedListQueue<Move> moves;
	private Board board;
	
	//constructor, takes in string for board file name and for movements file name, initializes space and board
	public Robot(String boardFile, String moveFile) {
		this.space = new int[]{0,0};
		board = new Board(boardFile);
		fileMove(moveFile);
	}
	
	//runs through the movement file to move the robot
	public void simulation() {
		//initializes count for command number
		int count = 0;
		//while loop checks if the space is empty beforehand, exits if not
		while (moves.empty()) {
			System.out.println("Command " + count);
			//removes move from queue, splits movement into space x & y-axis movements
			Move move = moves.Dequeue();
			this.space[0] += move.getMoveX();
			this.space[1] += move.getMoveY();
			//if/else statement checks if the robots crashed
			if (this.space[0] >= 10 || this.space[1] >= 10) {
				System.out.println("Robot crashed.");
				return;
			} else if (!board.checkEmpty(this.space[0], this.space[1])){
				return;
			//if robot doesn't crash then initiates robot movement and prints board
			} else {
				board.moveRobot(this.space[0], this.space[1]);
				board.print();
				count++;
			}
			System.out.println();
		}
	}
	
	//reads the file named, fills the array, and then returns the queue
	public LinkedListQueue<Move> fileMove(String file) {
		try {
			//initiates the first scanner to read the file, counts the number of lines in the file to get the array size
			Scanner fileCount = new Scanner(new File(file));
			int size = 0;
			while(fileCount.hasNextLine()) {
				fileCount.nextLine();
				size++;
			}
			if (size <= 0) {
				System.out.println("The file is empty.");
				fileCount.close();
				return null;
			}
			fileCount.close();
			//initializes queue and another scanner to reread the file
			Scanner fileScanner = new Scanner(new File(file));
			moves = new LinkedListQueue<Move>();
			//for loop reads through each line of the file and fills the String 'line' with the Scanner output
			for (int i = 0; i < size; i++) {
				if (!fileScanner.hasNextLine()) {
					break;
				}
				//the 'line' variable is created into new move & queued into the linked list queue
				String line = fileScanner.nextLine();
				Move newMove = new Move(line);
				moves.Enqueue(newMove);
			}
			fileScanner.close();
			return moves;
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
}

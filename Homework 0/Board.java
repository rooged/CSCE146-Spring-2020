//written by Timothy Gedney

public class Board {
	
	//attributes
	//creates the visual board array, the array of the 3x3 available spaces, and the pc class for use
	private String[][] board;
	private int[][] space;
	ComputerPlayer pc;
	
	//constructs each attribute
	public Board() {
		board = new String[21][8];
		space = new int[3][3];
		pc = new ComputerPlayer();
	}
	
	//fills the board array with the initial visual set up, and sets the space arrays to 0 (empty)
	public void populateBoard() {
		int countx = 0;
		int county = 0;
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 21; j++) {
				if (i % 2 != 0) {
					board[j][i] = "_";
				} else if (i == 0 && (j == 4 || j == 10 || j == 16)) {
					board[j][i] = Integer.toString(countx);
					countx++;
				} else if (i == 0 && j == 10) {
					board[j][i] = "1";
				} else if (i == 0 && j == 16) {
					board[j][i] = "2";
				} else if (i % 2 == 0 && j == 0 && i != 0) {
					board[j][i] = Integer.toString(county);
					county++;
				} else if (i % 2 == 0 && (j == 1 || j == 7 || j == 13 || j == 19)) {
					board[j][i] = "|";
				} else {
					board[j][i] = " ";
				}
			}
		}
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				space[j][i] = 0;
			}
		}
	}
	
	//converts the human entered coordinates (0-2) into the coordinates on the visual board to be added
	public void addTurn(int x, int y) {
		int i = 0;
		int j = 0;
		if (x == 4 || y == 4) {
			return;
		} else if (x < 0 || y < 0) {
			return;
		}
		if (x == 0) {
			j = 4;
		} else if (x == 1) {
			j = 10;
		} else {
			j = 16;
		}
		if (y == 0) {
			i = 2;
		} else if (y == 1) {
			i = 4;
		} else {
			i = 6;
		}
		//checks if the space is empty
		if (!checkEmpty(x, y)) {
			return;
		}
		//adds the "X" to the space and a "1" to the spaces array to count as filled
		board[j][i] = "X";
		space[y][x] = 1;
	}
	
	//calcs the pc's turn and a while loop to keep getting turns while the pc chooses a space already filled
	public void pcTurn() {
		pc.choosex();
		pc.choosey();
		while (!addPCTurn(pc.getx(), pc.gety())) {
			pc.choosex();
			pc.choosey();
		}
	}
	
	//converts the pc coordinates (0-2) into the coordinates on the visual board to be added
	public boolean addPCTurn(int x, int y) {
		//checks if the space is empty & returns false if so
		if (!checkEmpty(x, y)) {
			return false;
		}
		int i = 0;
		int j = 0;
		if (x == 0) {
			j = 4;
		} else if (x == 1) {
			j = 10;
		} else {
			j = 16;
		}
		if (y == 0) {
			i = 2;
		} else if (y == 1) {
			i = 4;
		} else {
			i = 6;
		}
		//adds the "O" to the space and a "2" to the spaces array to count as filled
		board[j][i] = "O";
		space[y][x] = 2;
		return true;
	}
	
	//nested for loop to print out the board each time
	public void printBoard() {
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 21; j++) {
				System.out.print(board[j][i]);
			}
			System.out.println();
		}
	}
	
	//uses the space array to check that a space is empty
	public boolean checkEmpty(int x, int y) {
		if (space[y][x] == 0) {
			return true;
		}
		return false;
	}
	
	//uses the space array to check if the board is full and can't be played any longer
	public boolean checkFull() {
		int count = 0;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (space[j][i] != 0) {
					count++;
				}
			}
		}
		if (count == 9) {
			return true;
		}
		return false;
	}
	
	//checks if there are 3 adjacent "X"s in the space array and returns true if so
	public boolean checkHumanWin() {
		if (space[0][0] == 1 && space[1][0] == 1 && space[2][0] == 1 ||
				space[0][1] == 1 && space[1][1] == 1 && space[2][1] == 1 ||
				space[0][2] == 1 && space[1][2] == 1 && space[2][2] == 1 ||
				space[0][0] == 1 && space[0][1] == 1 && space[0][2] == 1 ||
				space[1][0] == 1 && space[1][1] == 1 && space[1][2] == 1 ||
				space[2][0] == 1 && space[2][1] == 1 && space[2][2] == 1 ||
				space[0][0] == 1 && space[1][1] == 1 & space[2][2] == 1 ||
				space[2][0] == 1 && space[1][1] == 1 && space[0][2] == 1) {
			return true;
		}
		return false;
	}
	
	//checks if there are 3 adjacent "O"s in the space array and returns true if so
	public boolean checkPCWin() {
		if (space[0][0] == 2 && space[1][0] == 2 && space[2][0] == 2 ||
				space[0][1] == 2 && space[1][1] == 2 && space[2][1] == 2 ||
				space[0][2] == 2 && space[1][2] == 2 && space[2][2] == 2 ||
				space[0][0] == 2 && space[0][1] == 2 && space[0][2] == 2 ||
				space[1][0] == 2 && space[1][1] == 2 && space[1][2] == 2 ||
				space[2][0] == 2 && space[2][1] == 2 && space[2][2] == 2 ||
				space[0][0] == 2 && space[1][1] == 2 & space[2][2] == 2 ||
				space[2][0] == 2 && space[1][1] == 2 && space[0][2] == 2) {
			return true;
		}
		return false;
	}
}

//written by Timothy Gedney
import java.util.Random;

public class MineCounter {
	
	//attributes
	private String[][] board;
	private int[] mines;
	private Random random = new Random();
	
	//constructor
	public MineCounter() {
		this.board = new String[10][10];
		this.mines = new int[10];
	}

	//fills board array with '_'
	public void createBoard() {
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				this.board[j][i] = "_";
			}
		}
	}
	
	//fills 10 random spaces in board array with mines ('x')
	public void addMines() {
		//for loop randomly outputs 10 numbers within 0-99 without repeating and fills the mines array with them
		for (int i = 0; i < 10; i++) {
			this.mines[i] = random.nextInt(100);
			for (int j = 0; j < i; j++) {
				while (this.mines[i] == this.mines[j]) {
					this.mines[i] = random.nextInt(100);
				}
			}
		}
		//fills board with mines numbers, divides mines number by % 10 & / 10 to get the ones/tens which are used as the location in the board array
		for (int i = 0; i < this.mines.length; i++) {
			this.board[this.mines[i] % 10][this.mines[i] / 10] = "x";
		}
	}
	
	//uses for loop to print out board array in 10x10 set up
	public void printBoard() {
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				System.out.print(this.board[j][i]);
			}
			System.out.println();
		}
	}
	
	//counts each adjacent unit to a mine and fills back in the board array with the increased number
	public void countMines() {
		//initiates array of size 8 to hold each location of the square locations around each mine
		int[] counter = new int[8];
		int mine = 0, countj = 0, counti = 0;
		//for loop and if statement to place a '0' at every location that isn't a mine 'x'
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				if (this.board[j][i] != "x") {
					this.board[j][i] = "0";
				}
			}
		}
		//for loop that takes the mines location and finds the location of the 8 surrounding places and stores that into the counter array
		for (int i = 0; i < this.mines.length; i++) {
			mine = this.mines[i];
			counter[0] = mine - 11;
			counter[1] = mine - 10;
			counter[2] = mine - 9;
			counter[3] = mine - 1;
			counter[4] = mine + 1;
			counter[5] = mine + 9;
			counter[6] = mine + 10;
			counter[7] = mine + 11;
			//two if statements check if the mine is on the edge (0 or 9 in ones place) and negates the addition of the false adjacent pieces
			if (mine % 10 == 0) {
				counter[0] = -1;
				counter[3] = -1;
				counter[5] = -1;
			}
			if (mine % 10 == 9) {
				counter[2] = -1;
				counter[4] = -1;
				counter[7] = -1;
			}
			//for loop divides each counter value into ones/tens and then changes the board array value at that location
			for (int j = 0; j < counter.length; j++) {
				if (counter[j] >= 0 && counter[j] <= 99) {
					countj = counter[j] % 10;
					counti = counter[j] / 10;
					
					if (this.board[countj][counti] == "0") {
						this.board[countj][counti] = "1";
					} else if (this.board[countj][counti] == "1") {
						this.board[countj][counti] = "2";
					}  else if (this.board[countj][counti] == "2") {
						this.board[countj][counti] = "3";
					} else if (this.board[countj][counti] == "3") {
						this.board[countj][counti] = "4";
					} else if (this.board[countj][counti] == "4") {
						this.board[countj][counti] = "5";
					} else if (this.board[countj][counti] == "5") {
						this.board[countj][counti] = "6";
					} else if (this.board[countj][counti] == "6") {
						this.board[countj][counti] = "7";
					} else if (this.board[countj][counti] == "7") {
						this.board[countj][counti] = "8";
					}
				}	
			}
		}
	}	
}

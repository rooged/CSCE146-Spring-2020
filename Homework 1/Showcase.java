//written by Timothy Gedney
import java.util.Scanner;
import java.util.Random;
import java.io.File;
import java.io.IOException;

public class Showcase {

	//attributes, both arrays and the final variables for the file name and for the split variable tab
	private Prize[] prizeList;
	private Prize[] showcase;
	public static final String FILE_NAME = "./prizeList.txt";
	public static final String SPLIT = "\t";
	
	//constructor
	public Showcase() {
		prizeList = fillPrizeList(FILE_NAME);
		showcase = new Prize[5];
	}
	
	//chooses 5 random prizes from the prizeList to put into the showcase array and prints them to console
	public void choosePrizes() {
		Random rand = new Random();
		for (int i = 0; i < showcase.length; i++) {
			showcase[i] = prizeList[rand.nextInt(prizeList.length - 0)];
			System.out.println(showcase[i].getName());
		}
	}
	
	//sums the total price of the showcase array
	public int totalPrice() {
		int price = 0;
		for (int i = 0; i < showcase.length; i++) {
			price += showcase[i].getPrice();
		}
		return price;
	}
	
	//gets the lower bound range for the guess based on the total price - 2000
	public int priceRange() {
		int range = totalPrice() - 2000;
		if (range < 0) {
			return 0;
		}
		return range;
	}

	//reads the file named, fills the array, and then returns the Prize[] array
	public Prize[] fillPrizeList(String file) {
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
			//initiates a Prize[] array and another scanner to reread the file
			Prize[] list = new Prize[size];
			Scanner fileScanner = new Scanner(new File(file));
			//for loop reads through each line of the file and fills the String 'line' with the Scanner output
			for (int i = 0; i < list.length; i++) {
				if (!fileScanner.hasNextLine()) {
					break;
				}
				//the 'line' variable is split into the name & price by the /t and a new Prize object is created from it and then added to the array
				String line = fileScanner.nextLine();
				int index = line.indexOf(SPLIT);
				String name = line.substring(0, index);
				int price = Integer.parseInt(line.substring(index + 1));
				list[i] = new Prize(name, price);
			}
			fileScanner.close();
			return list;
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

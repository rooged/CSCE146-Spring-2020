//written by Timothy Gedney
import java.util.Scanner;
import java.io.*;

public class FruitTreeTester {

	public static void main(String[] args) {

		System.out.println("welcome to the fruit tree!\nPlease enter a Fruit File Name.");
		Scanner input = new Scanner(System.in);
		String fileName = input.nextLine();
		System.out.println("Populating tree file");
		
		BinarySearchTree<Fruit> fruitTree = new BinarySearchTree<Fruit>();
		try {
			Scanner fileScanner = new Scanner(new File(fileName));
			while (fileScanner.hasNextLine()) {
				String fileLine = fileScanner.nextLine();
				String[] splitLine = fileLine.split("\t");
				if (splitLine.length == 2) {
					String type = splitLine[0];
					double weight = Double.parseDouble(splitLine[1]);
					Fruit f = new Fruit(type, weight);
					fruitTree.add(f);
				}
			}
			fileScanner.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println("Printing the in-order traversal");
		fruitTree.printInOrder();
		System.out.println("\nPrinting the pre-order traversal");
		fruitTree.printPreOrder();
		System.out.println("\nPrinting the post-order traversal");
		fruitTree.printPostOrder();
		System.out.println("\nDeleting Apple	0.4859853412170728");
		fruitTree.remove(new Fruit("Apple", 0.4859853412170728));;
		System.out.println("Printing in-order traversal");
		fruitTree.printInOrder();
		input.close();
	}

}

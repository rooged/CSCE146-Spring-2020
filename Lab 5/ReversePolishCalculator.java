//written by Timothy Gedney
import java.util.Scanner;

public class ReversePolishCalculator {

	//attribute of new stack object
	private StackInterface<Integer> valueStack;
	
	//default constructor initializes stack object
	public ReversePolishCalculator() {
		valueStack = new GenStack<Integer>();
	}
	
	//separates the entered string into individual strings to be parsed/used as needed
	public int calculate(String s) {
		//initializes scanner object to read each object
		Scanner read = new Scanner(s);
		//while loop repeats while string has another piece to read
		while (read.hasNext()) {
			//.next() reads next piece in string up to a space
			String sub = read.next();
			//if/else statement to check that the value entered is either a number or an operator
			if (sub.compareTo("+") != 0 && sub.compareTo("-") != 0 && sub.compareTo("*") != 0 && sub.compareTo("/") != 0) {
				//try/catch block, if the value entered isn't an operator, then it tries to parse the value
				try {
					int numTemp = Integer.parseInt(sub);
					valueStack.push(numTemp);
				//if the parse fails, outputs an invalid value statement and exits
				} catch (Exception e) {
					System.out.println("Not a valid value.");
					clear();
					read.close();
					return 0;
				}
			//any value here must be an operator
			} else {
				//if/else statement checks if the size of the stack is greater than 1 to do an operation
				if (size() > 1) {
					//pops off first two numbers of stack
					int num2 = valueStack.pop();
					int num1 = valueStack.pop();
					//if/else checks while operator is entered and calcs the respective operation
					if (sub.compareTo("+") == 0) {
						valueStack.push(num1 + num2);
					} else if (sub.compareTo("-") == 0) {
						valueStack.push(num1 - num2);
					} else if (sub.compareTo("*") == 0) {
						valueStack.push(num1 * num2);
					//checks if can't devide by 0
					} else if (sub.compareTo("/") == 0 && num2 == 0) {
						System.out.println("Cannot divide by 0.");
						clear();
						read.close();
						return 0;
					} else {
						valueStack.push(num1 / num2);
					}
				//there weren't enough numbers in the stack to perform an operation
				} else {
					System.out.println("Incorrect format. There were too many operators and not enough numbers.");
					valueStack.pop();
					read.close();
					return 0;
				}
			}
		}
		read.close();
		//if the final stack size is 1 then it returns that number
		if (size() == 1) {
			return valueStack.pop();
		//if not, too many numbers statement
		} else {
			System.out.println("Incorrect format. There were too many numbers and not enough operators.");
			clear();
			return 0;
		}
	}
	
	//clear method, used to empty the stack when an error is encountered and the program exits
	public void clear() {
		while (size() > 0) {
			valueStack.pop();
		}
	}
	
	//returns size of the stack from the cast of valueStack
	public int size() {
		return ((GenStack<Integer>) valueStack).getSize();
	}
}

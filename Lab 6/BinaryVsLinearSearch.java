//written by Timothy Gedney
import java.util.Random;

public class BinaryVsLinearSearch {

	public static final int MAX_TESTS = 20;
	public static final int ARR_SIZE = 1000;
	public static int linCount = 0;
	public static int binCount = 0;
	public static int totalLin = 0;
	public static int totalBin = 0;
	
	public static void main(String[] args) {
		
		System.out.println("Welcome to the search teter. We are going to see which\n"
				+ "algorithm performs the best out of 20 tests");
		for (int i = 0; i < MAX_TESTS; i++) {
			System.out.println("----------------------------------");
			System.out.println("Test " + (i + 1));
			System.out.println("----------------------------------");
			test();
			System.out.println("Linear Checks: " + totalLin);
			System.out.println("Binary Checks: " + totalBin);
		}
		System.out.println("----------------------------------");
		System.out.println("Results");
		System.out.println("----------------------------------");
		System.out.println("Average Linear Checks: " + totalLin / MAX_TESTS);
		System.out.println("Average Binary Checks: " + totalBin / MAX_TESTS);
	}
	
	public static void test() {
		linCount = binCount = 0;
		int[] sortedArray = genRandomSortedArray();
		Random r = new Random();
		int targetVal = r.nextInt(ARR_SIZE);
		System.out.println(linSearch(sortedArray, targetVal));
		System.out.println(binSearch(sortedArray, targetVal, 0, sortedArray.length - 1));
		totalLin += linCount;
		totalBin += binCount;
	}
	
	public static int[] genRandomSortedArray() {
		int[] ret = new int[ARR_SIZE];
		Random r = new Random();
		for (int i = 0; i < ret.length; i++)
			ret[i] = r.nextInt(ARR_SIZE);
		quickSort(ret, 0, ret.length - 1);
		return ret;
	}
	
	public static void quickSort(int[] a, int start, int end) {
		int part = partition(a, start, end);
		if (start < part - 1)
			quickSort(a, start, part - 1);
		if (part < end)
			quickSort(a, part, end);
	}
	
	public static int partition(int[] a, int start, int end) {
		int i = start;
		int j = end;
		int piv = a[(end + start) / 2];
		while (i <= j) {
			while (a[i] < piv)
				i++;
			while (a[j] > piv)
				j--;
			if (i <= j) {
				int temp = a[i];
				a[i] = a[j];
				a[j] = temp;
				i++;
				j--;
			}
		}
		return i;
	}
	
	public static boolean linSearch(int[] a, int target) {
		System.out.print("Searching using linear search. Found? ");
		for (int i = 0; i < a.length; i++) {
			linCount++;
			if (a[i] == target)
				return true;
		}
		return false;
	}
	
	public static boolean binSearch(int[] a, int target, int start, int end) {
		if (start > end) {
			System.out.print("Searching using binary search. Found? ");
			return false;
		}
		int mid = (start + end) / 2;
		binCount++;
		if (a[mid] == target) {
			System.out.print("Searching using binary search. Found? ");
			return true;
		}
		else if (target < a[mid])
			return binSearch(a, target, start, mid - 1);
		else
			return binSearch(a, target, mid + 1, end);
	}
}

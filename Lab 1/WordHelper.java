//written by Timothy Gedney
import java.util.Random;

public class WordHelper {
	
	//fills a second array and then sorts that array using the countVowel method in class word
	public static String[] sortByVowels(String[] file) {
		String[] file1 = new String[file.length];
		for (int i = 0; i < file.length; i++) {
			if (file[i] != null) {
				file1[i] = file[i];
			}
		}
		Word word = new Word();
		//nested loop compares the vowel count of two adjacent words and swaps them if one is higher (bubble sort)
		for (int i = 1; i < file1.length; i++) {
			for (int j = 0; j < file1.length - 1; j++) {
				if (word.countVowel(file1[i]) < word.countVowel(file1[j])) {
					String temp = file1[i];
					file1[i] = file1[j];
					file1[j] = temp;
				//if two words have the same vowel count, a word is randomly chosen to go first
				} else if (word.countVowel(file1[i]) == word.countVowel(file1[j])) {
					Random rand = new Random();
					int r1 = rand.nextInt((1 - 0) + 1);
					int r2 = rand.nextInt((1 - 0) + 1);
					if (r1 > r2) {
						String temp = file1[i];
						file1[i] = file1[j];
						file1[j] = temp;
					}
				}
			}
		}
		return file1;
	}
	
	//fills a second array and then sorts that array using the countCon method in class word
	public static String[] sortByConsonants(String[] file) {
		String[] file1 = new String[file.length];
		for (int i = 0; i < file.length; i++) {
			if (file[i] != null) {
				file1[i] = file[i];
			}
		}
		Word word = new Word();
		//nested loop compares the consonant count of two adjacent words and swaps them if one is higher (bubble sort)
		for (int i = 1; i < file1.length; i++) {
			for (int j = 0; j < file1.length - 1; j++) {
				if (word.countCon(file1[i]) < word.countCon(file1[j])) {
					String temp = file1[i];
					file1[i] = file1[j];
					file1[j] = temp;
				//if two words have the same consonant count, a word is randomly chosen to go first
				} else if (word.countCon(file1[i]) == word.countCon(file1[j])) {
					Random rand = new Random();
					int r1 = rand.nextInt((1 - 0) + 1);
					int r2 = rand.nextInt((1 - 0) + 1);
					if (r1 > r2) {
						String temp = file1[i];
						file1[i] = file1[j];
						file1[j] = temp;
					}
				}
			}
		}
		return file1;
	}
	
	//fills a second array and then sorts that array using .length of each word
	public static String[] sortByLength(String[] file) {
		String[] file1 = new String[file.length];
		for (int i = 0; i < file.length; i++) {
			if (file[i] != null) {
				file1[i] = file[i];
			}
		}
		//nested loop compares the length of two adjacent words and swaps them if one is higher (bubble sort)
		for (int i = 1; i < file1.length; i++) {
			for (int j = 0; j < file1.length - 1; j++) {
				if (file1[i].length() < file1[j].length()) {
					String temp = file1[i];
					file1[i] = file1[j];
					file1[j] = temp;
				//if two words have the same length count, a word is randomly chosen to go first
				} else if (file1[i].length() == file1[j].length()) {
					Random rand = new Random();
					int r1 = rand.nextInt((1 - 0) + 1);
					int r2 = rand.nextInt((1 - 0) + 1);
					if (r1 > r2) {
						String temp = file1[i];
						file1[i] = file1[j];
						file1[j] = temp;
					}
				}
			}
		}
		return file1;
	}
}

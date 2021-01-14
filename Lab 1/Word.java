//written by Timothy Gedney

public class Word {
	
	//returns the number of vowels in a word
	public int countVowel(String word) {
		int count = 0;
		for (int k = 0; k < word.length(); k++) {
			if (word.toUpperCase().charAt(k) == 'A' || word.toUpperCase().charAt(k) == 'E'|| word.toUpperCase().charAt(k) == 'I'|| word.toUpperCase().charAt(k) == 'O'|| word.toUpperCase().charAt(k) == 'U'|| word.toUpperCase().charAt(k) == 'Y') {
				count++;
			}
		}
		return count;
	}
	
	//returns the number of consonants in a word
	public int countCon(String word) {
		int count = 0;
		for (int k = 0; k < word.length(); k++) {
			if (word.toUpperCase().charAt(k) != 'A' && word.toUpperCase().charAt(k) != 'E' && word.toUpperCase().charAt(k) != 'I' && word.toUpperCase().charAt(k) != 'O' && word.toUpperCase().charAt(k) != 'U' && word.toUpperCase().charAt(k) != 'Y') {
				count++;
			}
		}
		return count;
	}
}

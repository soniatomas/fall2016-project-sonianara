import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Random;

public class RandomLetters {
	private int numLetters;
	private ArrayList<Letter> letters;
	private HashMap<Character, Integer> numLettersMap;
	public static HashMap<Character, Integer> letterValueMap;
	
	
	public RandomLetters() {
		numLettersMap = new HashMap<Character, Integer>();
		letterValueMap = new HashMap<Character, Integer>();
		letters = new ArrayList<Letter>();
		numLetters = 0;
		
		for (char tempLetter = 'a'; tempLetter <= 'z'; tempLetter++) {
			switch (tempLetter) {
				case 'a': 
					numLettersMap.put(tempLetter, 9);
					letterValueMap.put(tempLetter, 1);
					break;
				case 'b': 
					numLettersMap.put(tempLetter, 2);
					letterValueMap.put(tempLetter, 3);
					break;
				case 'c': 
					numLettersMap.put(tempLetter, 2);
					letterValueMap.put(tempLetter, 3);
					break;
				case 'd': 
					numLettersMap.put(tempLetter, 4);
					letterValueMap.put(tempLetter, 2);
					break;
				case 'e': 
					numLettersMap.put(tempLetter, 12);
					letterValueMap.put(tempLetter, 1);
					break;
				case 'f': 
					numLettersMap.put(tempLetter, 2);
					letterValueMap.put(tempLetter, 4);
					break;
				case 'g': 
					numLettersMap.put(tempLetter, 3);
					letterValueMap.put(tempLetter, 2);
					break;
				case 'h': 
					numLettersMap.put(tempLetter, 2);
					letterValueMap.put(tempLetter, 4);
					break;
				case 'i': 
					numLettersMap.put(tempLetter, 9);
					letterValueMap.put(tempLetter, 1);
					break;
				case 'j': 
					numLettersMap.put(tempLetter, 1);
					letterValueMap.put(tempLetter, 8);
					break;
				case 'k': 
					numLettersMap.put(tempLetter, 1);
					letterValueMap.put(tempLetter, 5);
					break;
				case 'l': 
					numLettersMap.put(tempLetter, 4);
					letterValueMap.put(tempLetter, 1);
					break;
				case 'm': 
					numLettersMap.put(tempLetter, 2);
					letterValueMap.put(tempLetter, 3);
					break;
				case 'n': 
					numLettersMap.put(tempLetter, 6);
					letterValueMap.put(tempLetter, 1);
					break;
				case 'o': 
					numLettersMap.put(tempLetter, 8);
					letterValueMap.put(tempLetter, 1);
					break;
				case 'p': 
					numLettersMap.put(tempLetter, 2);
					letterValueMap.put(tempLetter, 3);
					break;
				case 'q': 
					numLettersMap.put(tempLetter, 1);
					letterValueMap.put(tempLetter, 10);
					break;
				case 'r': 
					numLettersMap.put(tempLetter, 6);
					letterValueMap.put(tempLetter, 1);
					break;
				case 's': 
					numLettersMap.put(tempLetter, 4);
					letterValueMap.put(tempLetter, 1);
					break;
				case 't': 
					numLettersMap.put(tempLetter, 6);
					letterValueMap.put(tempLetter, 1);
					break;
				case 'u': 
					numLettersMap.put(tempLetter, 4);
					letterValueMap.put(tempLetter, 1);
					break;
				case 'v': 
					numLettersMap.put(tempLetter, 2);
					letterValueMap.put(tempLetter, 4);
					break;
				case 'w': 
					numLettersMap.put(tempLetter, 2);
					letterValueMap.put(tempLetter, 4);
					break;
				case 'x': 
					numLettersMap.put(tempLetter, 1);
					letterValueMap.put(tempLetter, 8);
					break;
				case 'y': 
					numLettersMap.put(tempLetter, 2);
					letterValueMap.put(tempLetter, 4);
					break;
				case 'z': 
					numLettersMap.put(tempLetter, 1);
					letterValueMap.put(tempLetter, 10);
					break;
			}
		}
		//Add the two blank tiles
		numLettersMap.put(' ', 2);
		letterValueMap.put(' ', 0);
		letters.add(new Letter(' '));
		letters.add(new Letter(' '));
		numLetters = 2;
		
		//Adding all the tiles
		char tempLetter = 'a';
		while (tempLetter <= 'z') {
			int count = numLettersMap.get(tempLetter);
			System.out.println(count);
			while (count-- > 0) {
				letters.add(new Letter(tempLetter));
				numLetters++;
			}
			tempLetter++;
		}
		
		//Randomize the letters
		long seed = System.nanoTime();
		Collections.shuffle(letters, new Random(seed));
		
		//Prints all randomized letters for debugging
//		for (Letter l : letters) {
//			System.out.print(l.getLetter());
//		}
	}
	
	public static int getLetterValue(char letter) {
		return letterValueMap.get(letter);
	}
	
	public Letter getRandomLetter() {
		if (numLetters <= 0) return null;
		
		numLetters--;
		return letters.remove(0);
	}
	public ArrayList<Letter> getFullSet() {
		if (numLetters < 7) return null;
		ArrayList<Letter> newLetters = new ArrayList<Letter>();
		for (int i = 0; i < 7; i++) {
			newLetters.add(letters.remove(0));
			numLetters--;
		}
		return newLetters;
	}
}
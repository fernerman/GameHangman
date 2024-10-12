import java.util.Arrays;

public class Word {
	private String word;
	private char[] remainingWord;
	private char[] guessedLetters;

	public Word(String secretWord) {
		word = secretWord;
		this.remainingWord= secretWord.toCharArray();
		this.guessedLetters = new char[secretWord.length()];
		Arrays.fill(this.guessedLetters, '_');
	}
	public void show() {
		System.out.println("Слово: "+ new String(guessedLetters));
	}
	public int updateGuessedLetters(String letter){
		letter=letter.toLowerCase();
		int count=0;
		for (int i = 0; i < remainingWord.length; i++) {
			if (remainingWord[i] == letter.charAt(0)) {
				guessedLetters[i] = letter.charAt(0);
				remainingWord[i] = '_';
				count++;
			}
		}
		return count;
	}
	public  int getWordSize(){
		return word.length();
	}

}

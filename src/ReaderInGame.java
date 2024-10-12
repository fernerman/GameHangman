import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class ReaderInGame {

	protected String pathToStates="src/HangmanStates.txt";
	protected String pathToWords="src/Words.txt";

	ReaderInGame() {}

	public String getRandomWord(){
		StringBuilder result = new StringBuilder();

		try (BufferedReader br = new BufferedReader(new FileReader(pathToWords))) {
			String line;

			while((line = br.readLine()) != null) {
				result.append(line);
				result.append('\n');
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		List<String> listWords = Arrays.asList(result.toString().split("\n"));
		int index = (int)(Math.random() * listWords.size());

		return listWords.get(index);
	}
	public String getLetterFromUser(){
		Scanner scanner = new Scanner(System.in);
		String input;
		do{
			System.out.print("Введите букву: ");
			input = scanner.next();
			if(input.length() !=1||!Character.UnicodeBlock.of(input.charAt(0)).equals(Character.UnicodeBlock.CYRILLIC)){
				System.out.println("Введите корректную кириллическую букву!");
			}

		}while (input.length() != 1 || !Character.UnicodeBlock.of(input.charAt(0)).equals(Character.UnicodeBlock.CYRILLIC));


		return String.valueOf(Character.toLowerCase(input.charAt(0)));
	}
	public List<String> getStates() {
		StringBuilder allStatesOfHangmanPictures = new StringBuilder();

		int c;
		try (FileReader reader = new FileReader(pathToStates)) {

			while ((c = reader.read()) != -1) {
				allStatesOfHangmanPictures.append((char) c);

			}

		} catch (IOException e) {
			System.err.println("Ошибка при чтении файла: " + e.getMessage());
			return List.of();
		}
		String stringStates = allStatesOfHangmanPictures.toString();
		return stringStates.isEmpty() ? List.of() : Arrays.asList(stringStates.split("#"));

	}
}

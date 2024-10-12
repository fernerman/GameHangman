import java.util.List;
import java.util.Scanner;

public class Game {
	//загаданное слово
	private final Word guessWord;
	private final ReaderInGame reader;

	public Game(Word guessWord, ReaderInGame reader) {
		this.guessWord=guessWord;
		this.reader = reader;
	}

	public  void run() throws Exception {
		System.out.println("Игра Виселица");

		List<String> statesGame = reader.getStates();
		int countGuessLetters=0;
		int iterationState=0;

		while (iterationState < statesGame.size() && countGuessLetters < guessWord.getWordSize()) {

			System.out.println("1. Начать играть в игру\n2. Выйти из игры");
			String choice =getChoice();
			switch (choice) {
				case "1":
					System.out.println("Добро пожаловать в игру в Виселицу");

					while (iterationState<statesGame.size() && countGuessLetters<guessWord.getWordSize()) {
						System.out.println("Текущее состояие:\n"+ statesGame.get(iterationState));
						guessWord.show();
						if(iterationState==statesGame.size()-1) {
							System.out.println("Вы проиграли...");
							return;
						}

						String letter =reader.getLetterFromUser();
						if (letter!=null){
							int currentGuessLetter=guessWord.updateGuessedLetters(letter);

							if (currentGuessLetter>0){
								System.out.println("Вы угадали букву!");
								countGuessLetters+=currentGuessLetter;
								if(countGuessLetters==guessWord.getWordSize()) {
									guessWord.show();
									System.out.println("Вы выиграли!");
									System.out.println();
									return;
								}
							}
							else {
								System.out.println("Вы не угадали букву...");
								iterationState++;

							}
						}

					}
					break;
				case "2":
					return;

				default:
					System.out.println("Такого значения нет!: " + choice);
					break;
			}
		}
	}
	public  String getChoice() {
		Scanner scanner = new Scanner(System.in);
		String choice;
		do {
			choice = scanner.next();
			if (!choice.equals("1") && !choice.equals("2")) {
				System.out.println("Пожалуйста, введите 1 или 2.");
			}
		} while (!choice.equals("1") && !choice.equals("2"));
		return choice;
	}
}

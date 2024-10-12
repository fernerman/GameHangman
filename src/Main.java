import java.io.IOException;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
	public static void main(String[] args) {
		String errorMessage = null;
		try {
			startGame();
		}

		catch (Exception e) {
			System.out.println("Произошла ошибка: " + e.getMessage());
		}
		finally {
			System.out.println("Программа завершена");
		}
	}

	private static void startGame() throws Exception {

		ReaderInGame reader = new ReaderInGame();
		String wordForGame =reader.getRandomWord();

		Word guessWord = new Word(wordForGame);
		Game game = new Game(guessWord,reader);
		game.run();
	}
}
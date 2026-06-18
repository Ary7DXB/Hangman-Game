package hangman;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileLoader extends ArrayList<String> {

	public FileLoader() {
		try {
			File file = new File("Words.txt");
			Scanner scanFile = new Scanner(file);

			while (scanFile.hasNextLine()) {
				String word = scanFile.nextLine();
				this.add(word);
			}
		}

		catch(FileNotFoundException e) {
			System.out.println("File Does Not Exist");
			System.out.println();
		}
	}

	public String WordSelector() {
		String randomWord = this.get((int)(Math.random()*this.size()));
		return randomWord;
	}
}

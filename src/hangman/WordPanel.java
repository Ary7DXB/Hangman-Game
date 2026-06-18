package hangman;

import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

public class WordPanel extends JPanel {
	
	// The 'WordPanel' GUI component displays the word to be guessed with an '_' and updates after a correct guess is made.
	
	private String word;
	private String[] wordCharacters;
	private ArrayList<JLabel> wordCharacterElements = new ArrayList<JLabel>();
	
	// The 'WordPanel' constructor creates a GUI component which displays a loaded random word masked by '_'.
	
	public WordPanel(String randomWord) {
		setWord(randomWord);
		wordCharacters = randomWord.split("");
		
		Font font = new Font("Arial",Font.BOLD,40);
		
		this.setLayout(new FlowLayout());
		this.setBackground(Color.DARK_GRAY);
		for (int i=0; i<randomWord.length(); i++) {
			JLabel character = new JLabel("_");
			character.setPreferredSize(new Dimension(50,50));
			character.setFont(font);
			character.setBackground(Color.DARK_GRAY);
			character.setForeground(Color.WHITE);
			character.setOpaque(true);
			this.add(character);
			wordCharacterElements.add(character);
		}
	}
	
	// The following getter retrieves a values for a randomly loaded word.
	
	public String getWord() {
		return word;
	}
	
	// The following getter returns the length of the array 'wordCharacters'.
	
	public int getWordCharactersLength() {
		return wordCharacters.length;
	}
	
	// The following method sets a randomly loaded word (used only when the reset method is called).
	
	public void setWord(String word) {
		this.word = word;
	}
	
	// The following method is called when a user selects a letter. it checks if the letter selected exists in the random word, and returns a boolean value.
	
	public boolean guess(String character) {
		
		boolean successFlag = false;
		
		for (int i=0; i<wordCharacters.length; i++) {
			if (wordCharacters[i].equalsIgnoreCase(character)) {
				wordCharacterElements.get(i).setText(character);
				successFlag = true;
			}
		}
		
		return successFlag;
		
	}
	
	// The following method verifies if the word has been completely guessed and returns a boolean value to where the method was called.
	
	public boolean completelyGuessed() {
		
		boolean guessedFlag = false;
		
		for (int i=0; i<wordCharacters.length; i++) {
			if(wordCharacters[i].equalsIgnoreCase(wordCharacterElements.get(i).getText())) {
				guessedFlag = true;
			}
			
			else {
				guessedFlag = false;
				return guessedFlag;
			}
		}
		
		return guessedFlag;
		
	}
	
	// The following method reveals the word on the 'WordPanel' in red coloured text if the game is lost by altering the JLabels.
	
	public void revealWord() {
		for (int i=0; i<wordCharacters.length; i++) {
			wordCharacterElements.get(i).setText(wordCharacters[i]);
			wordCharacterElements.get(i).setForeground(Color.RED);
		}
	}
	
	// The following method highlights the correctly guessed word in green coloured text and is used as a victory effect, by altering JLabels.
	
	public void victoryEffect() {
		for (int i=0; i<wordCharacters.length; i++) {
			wordCharacterElements.get(i).setForeground(Color.GREEN);
		}
	}
	
	// The following method when called resets the 'WordPanel' to it's default state and sets an another random word to be guessed.
	
	public void resetWordPanel(String randomWord) {
		setWord(randomWord);
		wordCharacters = randomWord.split("");
		
		Font font = new Font("Arial",Font.BOLD,40);
		
		for (JLabel wordCharacterElement : wordCharacterElements) {
			this.remove(wordCharacterElement);
		}
		
		wordCharacterElements.clear();

		for (int i=0; i<randomWord.length(); i++) {
			JLabel character = new JLabel("_");
			character.setPreferredSize(new Dimension(50,50));
			character.setFont(font);
			character.setBackground(Color.DARK_GRAY);
			character.setForeground(Color.WHITE);
			character.setOpaque(true);
			this.add(character);
			wordCharacterElements.add(character);
		}
		
		this.revalidate();
		this.repaint();
		
	}
}

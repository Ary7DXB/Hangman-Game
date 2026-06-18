package hangman;

import java.awt.*;
import javax.swing.*;

public class EndGame extends JPanel {
	
	// The 'EndGame' class is used for wrapping up the game after a win or a loss, and houses dedicated tasks to increase cohesion.
	
	private ButtonPanel buttonPanel;
	private WordPanel wordPanel;
	private HealthPanel healthPanel;
	private FileLoader fileLoader;
	
	// The 'EndGame' constructor sets all fields with the references to the objects used throughout the program, created in the 'MainWindow'.
	
	public EndGame(WordPanel wordPanel,HealthPanel healthPanel,FileLoader fileLoader,ButtonPanel buttonPanel) {
		this.wordPanel = wordPanel;
		this.healthPanel = healthPanel;
		this.fileLoader = fileLoader;
		this.buttonPanel = buttonPanel;
	}
	
	// The method below is used if the user wins a game displaying, a victory effect and offering a dialogue box to either play again or exit.
	
	public void victory() {
		wordPanel.victoryEffect();
		int choice = JOptionPane.showConfirmDialog(healthPanel,"Congratulations!, You Have Won The Game By Guessing The Word, Play Again?","Victory",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
		JOptionPane.setDefaultLocale(getLocale());
		if (choice==JOptionPane.YES_OPTION) {
			resetObjects();
		}
		
		else {
			System.exit(choice);
		}
	}
	
	// The method below is used if the user loses a game displaying, a reveal word effect and offering a dialogue box to either play again or exit.
	
	public void defeat() {
		wordPanel.revealWord();
		int choice = JOptionPane.showConfirmDialog(healthPanel,"Oh No!, You Have Failed To Guess The Word: " + wordPanel.getWord().toLowerCase() + ", Play Again?","Defeat",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
		if (choice==JOptionPane.YES_OPTION) {
			resetObjects();
		}
		
		else {
			System.exit(choice);
		}
	}
	
	// The method below when invoked resets all objects by invoking them with their respective reset methods.
	
	public void resetObjects() {
		healthPanel.resetHeatlhPanel();
		wordPanel.resetWordPanel(fileLoader.WordSelector());
		buttonPanel.resetButtonPanel();
	}
}

package hangman;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class ButtonPanel extends JPanel implements ActionListener {
	
	// The 'ButtonPanel' class is used for displaying a panel of alphabet buttons and listen for button presses from the user,
	// and implement further game logic.
	
	private JButton[] alphabetButtons;
	private WordPanel wordPanel;
	private HealthPanel healthPanel;
	private FileLoader fileLoader;
	
	// The 'ButtonPanel' constructor creates a panel of button with all letters of the alphabet and adds them to an array
	
	public ButtonPanel(WordPanel wordPanel,HealthPanel healthPanel,FileLoader fileLoader) {
		
		// The class fields are set with the passed GUI objects to implement game logic and reference the same objects in the 'MainWindow'.
		
		this.wordPanel = wordPanel;
		this.healthPanel = healthPanel;
		this.fileLoader = fileLoader;
		
		alphabetButtons = new JButton[26];
		this.setLayout(new GridLayout(4,7));
		this.setBackground(Color.DARK_GRAY);
		
		for (int i=0; i<alphabetButtons.length; i++) {
			char alphabet = (char)('A' + i);
			alphabetButtons[i] = new JButton(String.valueOf(alphabet));
			alphabetButtons[i].setBackground(Color.DARK_GRAY);
			alphabetButtons[i].setForeground(Color.DARK_GRAY);
			alphabetButtons[i].setOpaque(true);
			this.add(alphabetButtons[i]);
			alphabetButtons[i].addActionListener(this);
		}
	}
	
	// actionPerformed is an implemented method to listen for button presses and execute further game logic by invoking the passed objects
	// with their methods.

	@Override
	public void actionPerformed(ActionEvent e) {
		EndGame endGame = new EndGame(wordPanel,healthPanel,fileLoader,this);
		
		for (int i=0; i<alphabetButtons.length; i++) {
			if (e.getSource()==alphabetButtons[i]) {
				boolean guessFlag = wordPanel.guess(alphabetButtons[i].getText());
				
				// The below if-else statements implement and set the game logic by using the guessFlag's boolean value set by using the guess method.
				
				// The if statement below checks whether button presses exists in the word and that the word is not entirely guessed.
				
				if (guessFlag==true && wordPanel.completelyGuessed()==false) {
					alphabetButtons[i].setVisible(false);
				}
				
				// The else-if statement below checks whether button presses exist in the work and if the word has been completely guessed.
				
				else if (guessFlag==true && wordPanel.completelyGuessed()==true) {
					alphabetButtons[i].setVisible(false);
					endGame.victory();
				}
				
				// The else statement is executed if the guess was incorrect and removes a life from the HealthPanel.
				
				else {
					alphabetButtons[i].setVisible(false);
					boolean gameOutcomeFlag = healthPanel.removeLife();
					
					// The if statement within checks if the game has been lost by retrieving a corresponding boolean flag.
					
					if (gameOutcomeFlag==false) {
						endGame.defeat();
					}
				}
			}
		}
	}
	
	// The following method when called resets the 'ButtonPanel' to its default state making the buttons visible again.
	
	public void resetButtonPanel() {
		for (int i=0; i<alphabetButtons.length; i++) {
			alphabetButtons[i].setVisible(true);
		}
	}
}

package hangman;

import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

public class HealthPanel extends JPanel {
	
	// The Health panel GUI component displays the number of guesses and the guesses remaining.
	
	private int guessesRemaining = 7;
	private ArrayList<JLabel> guesses = new ArrayList<JLabel>();
	
	// The following HealthPanel constructor creates a GUI component, which displays the number of guesses.
	
	public HealthPanel() {
		Font font = new Font("Arial",Font.BOLD,20);
		
		this.setLayout(new FlowLayout());
		this.setBackground(Color.DARK_GRAY);
		for (int i=0; i<7; i++) {
			JLabel guess = new JLabel(String.valueOf(i+1),JLabel.CENTER);
			guess.setPreferredSize(new Dimension(100,100));
			guess.setFont(font);
			guess.setBackground(Color.GREEN);
			guess.setForeground(Color.DARK_GRAY);
			guess.setOpaque(true);
			this.add(guess);
			guesses.add(guess);
		}
	}
	
	// The following getter retrieves the value for guesses remaining.
	
	public int getGuessesRemaining() {
		return guessesRemaining;
	}
	
	// The following setter sets the value for guesses remaining.
	
	public void setGuessesRemaining(int guessesRemaining) {
		this.guessesRemaining = guessesRemaining;
	}
	
	// The following method 'removeLife' is called to turn a GUI health segment red while also returning a boolean value for right or wrong guesses.
	
	public boolean removeLife() {
		
		boolean gameOutcome = false;
		
		if (getGuessesRemaining()>0) {
			guesses.get(guessesRemaining-1).setBackground(Color.RED);
			setGuessesRemaining(getGuessesRemaining() - 1);
			if (getGuessesRemaining()>0) {
				gameOutcome = true;
				return gameOutcome;
			}
			
			else {
				return gameOutcome;
			}
		}
		
		return gameOutcome;
		
	}
	
	// The following method resets the entire 'healthPanel' GUI component and all values associated.
	
	public void resetHeatlhPanel() {
		for (JLabel guess : guesses) {
			guess.setBackground(Color.GREEN);
		}
		
		setGuessesRemaining(7);
		
	}
}
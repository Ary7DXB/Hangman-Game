package hangman;

import java.awt.*;
import javax.swing.*;

public class MainWindow extends JFrame {

	public MainWindow() {
		getContentPane().setLayout(new GridLayout(3,1));

		HealthPanel healthPanel = new HealthPanel();
		getContentPane().add(healthPanel);

		FileLoader fileLoader = new FileLoader();
		WordPanel wordPanel = new WordPanel(fileLoader.WordSelector());
		getContentPane().add(wordPanel);

		ButtonPanel buttonPanel = new ButtonPanel(wordPanel,healthPanel,fileLoader);
		getContentPane().add(buttonPanel);
	}
}

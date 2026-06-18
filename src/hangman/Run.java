package hangman;

import java.awt.Color;

public class Run {

	public static void main(String[] args) {
		MainWindow mainWindow = new MainWindow();
		mainWindow.setSize(746,655);
		mainWindow.setLocation(342,100);
		mainWindow.setBackground(Color.DARK_GRAY);
		mainWindow.setTitle("Hang-Man");
		mainWindow.setResizable(true);
		mainWindow.setVisible(true);
		mainWindow.setDefaultCloseOperation(3);
	}
}

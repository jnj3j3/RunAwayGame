package UserInterface;

import javax.swing.JFrame;

import UserInterface.Screen;
import UserInterface.Window;

public class Window extends JFrame {
	
	public static final int screenWidth = 700;
	private Screen screen;
	
	public Window() {
		super("Run Away game");
		setSize(screenWidth, 180);
		setLocation(400, 200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		
		screen = new Screen();
		addKeyListener(screen);
		add(screen);
	}
	
	public void startGame() {
		
		setVisible(true);
		screen.startGame();
	}
	
	public static void main(String args[]) {
		(new Window()).startGame();
	}
}

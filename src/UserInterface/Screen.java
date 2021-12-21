package UserInterface;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

import GameState.GameState;
import ObjectManagement.Clouds;
import ObjectManagement.EnemiesManager;
import ObjectManagement.Land;
import ObjectManagement.Character;
import Source.Resource;

public class Screen extends JPanel implements Runnable, KeyListener {


	private Land land;
	private Character character;
	private EnemiesManager enemiesManager;  
	private Clouds clouds;
	private Thread thread;
	private boolean isKeyPressed;
	
	private GameState gameState= new GameState();

	private BufferedImage gameOverImage;

	public Screen() {
		character = new Character();
		land = new Land(Window.screenWidth, character);
		character.setSpeedX(4);
		gameOverImage = Resource.getResouceImage("data/restartGame3.png");
		enemiesManager = new EnemiesManager(character);
		clouds = new Clouds(Window.screenWidth, character);
	}

	public void startGame() {
		thread = new Thread(this);
		thread.start();
	}

	public void gameUpdate() {
		gameState.update(land,character,enemiesManager,clouds);
	}

	public void paint(Graphics g) {
		g.setColor(Color.decode("#dcdcdc"));
		g.fillRect(0, 0, getWidth(), getHeight());

		gameState.paint(g,gameOverImage,land,character,enemiesManager,clouds);
	}

	@Override
	public void run() {

		int fps = 100;
		long msPerFrame = 1000 * 1000000 / fps;
		long lastTime = 0;
		long elapsed;
		
		int msSleep;
		int nanoSleep;

		long endProcessGame;
		long lag = 0;

		while (true) {
			gameUpdate();
			repaint();
			endProcessGame = System.nanoTime();
			elapsed = (lastTime + msPerFrame - System.nanoTime());
			msSleep = (int) (elapsed / 1000000);
			nanoSleep = (int) (elapsed % 1000000);
			if (msSleep <= 0) {
				lastTime = System.nanoTime();
				continue;
			}
			
			try {
				Thread.sleep(msSleep, nanoSleep);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			lastTime = System.nanoTime();
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (!isKeyPressed) {
			isKeyPressed = true;
			gameState.keyPress(e, character, enemiesManager, land);
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		isKeyPressed = false;
		gameState.keyRelease(e, character);
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	

}
package GameState;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

import ObjectManagement.Character;
import ObjectManagement.Clouds;
import ObjectManagement.EnemiesManager;
import ObjectManagement.Land;
import Source.Resource;


public class StartState implements State{
	GameState gameState;
	BufferedImage space = Resource.getResouceImage("data/pressSpace.png");
	BufferedImage start = Resource.getResouceImage("data/startScreen.png");
	public StartState(GameState state) {
		this.gameState = state;
	}
	@Override
	public void update(Land land,Character character,EnemiesManager enemiesManager,Clouds clouds) {
	}
	@Override
	public void paint(Graphics g,BufferedImage gameOverImage,Land land,Character character,EnemiesManager enemiesManager,Clouds clouds) {
		g.setColor(Color.decode("#000000"));
		g.drawImage(start,270,12, null);
		g.drawImage(space, 250, 110, null);
	}
	@Override
	public void keyPress(KeyEvent e,Character character,EnemiesManager enemiesManager,Land land) {
		if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			gameState.setState(gameState.getPlayingState());
			
		}
	}
	@Override
	public void keyRelease(KeyEvent e,Character character) {
		
	}
}

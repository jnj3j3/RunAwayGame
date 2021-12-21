package GameState;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

import ObjectManagement.Character;
import ObjectManagement.Clouds;
import ObjectManagement.EnemiesManager;
import ObjectManagement.Land;

public interface State {
	public abstract void update(Land land,Character character,EnemiesManager enemiesManager,Clouds clouds);
	public abstract void paint(Graphics g,BufferedImage gameOverImage,Land land,Character character,EnemiesManager enemiesManager,Clouds clouds);
	public abstract void keyPress(KeyEvent e,Character character,EnemiesManager enemiesManager,Land land);
	public abstract void keyRelease(KeyEvent e,Character character);
}

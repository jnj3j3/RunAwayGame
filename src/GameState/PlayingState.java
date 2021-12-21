package GameState;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

import ObjectManagement.Character;
import ObjectManagement.Clouds;
import ObjectManagement.EnemiesManager;
import ObjectManagement.Land;

public class PlayingState implements State{
	GameState gameState;
	public PlayingState(GameState state) {
		this.gameState = state;
	}
	@Override
	public void update(Land land,Character character,EnemiesManager enemiesManager,Clouds clouds) {
		clouds.update();
		land.update();
		character.update();
		enemiesManager.update();
		if (enemiesManager.isCollision()) {
			character.playDeadSound();
			gameState.setState(gameState.getGameOverState());
			character.dead(true);
		}
		
	}
	@Override
	public void paint(Graphics g,BufferedImage gameOverImage ,Land land, Character character, EnemiesManager enemiesManager, Clouds clouds) {
		clouds.draw(g);
		land.draw(g);
		enemiesManager.draw(g);
		character.draw(g);
		g.setColor(Color.BLACK);
		g.drawString("Score: " + character.score, 600, 30);
		g.drawString("HighestScore: " + character.highestScore, 561, 20);

	}
	@Override
	public void keyPress(KeyEvent e,Character character,EnemiesManager enemiesManager,Land land) {
		if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			character.jump();
		} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			character.down(true);
		}
	}
	@Override
	public void keyRelease(KeyEvent e,Character character) {
		if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			character.down(false);
		}
	}
	

}

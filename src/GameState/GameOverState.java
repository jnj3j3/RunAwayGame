package GameState;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

import ObjectManagement.Character;
import ObjectManagement.Clouds;
import ObjectManagement.EnemiesManager;
import ObjectManagement.Land;

public class GameOverState implements State{
	GameState gameState;
	public GameOverState(GameState state) {
		this.gameState = state;
	}
	@Override
	public void update(Land land,Character character,EnemiesManager enemiesManager,Clouds clouds) {
	}
	@Override
	public void paint(Graphics g,BufferedImage gameOverImage,Land land,Character character,EnemiesManager enemiesManager,Clouds clouds) {
		clouds.draw(g);
		land.draw(g);
		enemiesManager.draw(g);
		character.draw(g);
		g.setColor(Color.BLACK);
		g.drawString("Score: " + character.score, 600, 30);
		g.drawString("HighestScore: " + character.highestScore, 561, 20);
		g.drawImage(gameOverImage, 250, 0, null);
	}
	@Override
	public void keyPress(KeyEvent e,Character character,EnemiesManager enemiesManager,Land land) {
		if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			gameState.setState(gameState.getPlayingState());
			land.reset();
			enemiesManager.reset();
			if(character.score>character.highestScore) character.highestScore = character.score;
			character.score =0;
			character.dead(false);
			character.reset();
		}
	}
	@Override
	public void keyRelease(KeyEvent e,Character character) {
		
	}

	
	
}

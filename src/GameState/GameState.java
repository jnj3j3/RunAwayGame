package GameState;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

import ObjectManagement.Character;
import ObjectManagement.Clouds;
import ObjectManagement.EnemiesManager;
import ObjectManagement.Land;

public class GameState {
	
	State gameOverState = new GameOverState(this);
	State playingState = new PlayingState(this);
	State startState = new StartState(this);
	
	State state = startState;
	
	public GameState() {
		
	}
	public void update(Land land,Character character,EnemiesManager enemiesManager,Clouds clouds) {
		state.update(land,character,enemiesManager,clouds);
	}
	public void paint(Graphics g,BufferedImage gameOverImage,Land land,Character character,EnemiesManager enemiesManager,Clouds clouds) {
		state.paint(g, gameOverImage, land, character, enemiesManager, clouds);
	}
	public void keyPress(KeyEvent e,Character character,EnemiesManager enemiesManager,Land land) {
		state.keyPress(e, character, enemiesManager, land);
	}

	public void keyRelease(KeyEvent e,Character character) {
		state.keyRelease(e, character);
	}
	public void setState(State state) {
		this.state = state;
	}
	

	public State getGameOverState() {
		return gameOverState;
	}

	public State getPlayingState() {
		return playingState;
	}

	public State getStartState() {
		return startState;
	}
}

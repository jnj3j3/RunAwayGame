package ObjectManagement;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


import Source.Resource;

public class EnemiesManager {
	
	private BufferedImage police;
	private BufferedImage wire;
	private BufferedImage helicopter;
	private Random rand;
	
	private List<Enemy> enemies;
	private Character character;
	
	public EnemiesManager(Character character) {
		rand = new Random();
		police = Resource.getResouceImage("data/police.png");
		wire = Resource.getResouceImage("data/wire entanglement.png");
		helicopter  = Resource.getResouceImage("data/Helicopter.png"); 
		enemies = new ArrayList<Enemy>();
		this.character = character;
		enemies.add(createEnemy());
	}
	
	public void update() {
		for(Enemy e : enemies) {
			e.update();
		}
		Enemy enemy = enemies.get(0);
		if(enemy.outOfScreen()) {
			character.upScore();
			 character.setSpeedX(character.getSpeedX()+(float)0.5);
			enemies.clear();
			enemies.add(createEnemy());
		}
	}
	
	public void draw(Graphics g) {
		for(Enemy e : enemies) {
			e.draw(g);
		}
	}
	
	private Enemy createEnemy() {
		int selectEnemy = rand.nextInt(3);
		if(selectEnemy == 0) {
			return new LandEnemy(character, 800, police.getWidth() - 10, police.getHeight() - 10, police);
		} else if(selectEnemy==1){
			return new LandEnemy(character, 800, wire.getWidth() - 15, wire.getHeight() - 13, wire);
		}else {
			return new SkyEnemy(character, 800, helicopter.getWidth() - 10, helicopter.getHeight() - 10, helicopter );
		}
	}
	
	public boolean isCollision() {
		for(Enemy e : enemies) {
			if (character.getRange().intersects(e.getRange())) {
				return true;
			}
		}
		return false;
	}
	
	public void reset() {
		enemies.clear();
		enemies.add(createEnemy());
		character.setSpeedX(4);
	}
	
}
package ObjectManagement;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class LandEnemy extends Enemy {
	
	public static final int landY = 125;
	
	private int positionX;
	private int width;
	private int height;
	
	private BufferedImage image;
	private Character character;
	
	private Rectangle range;
	
	public LandEnemy(Character character, int posX, int width, int height, BufferedImage image) {
		this.positionX = posX;
		this.width = width;
		this.height = height;
		this.image = image;
		this.character = character;
		range = new Rectangle();
	}
	
	public void update() {
		positionX -= character.getSpeedX();
	}
	
	public void draw(Graphics g) {
		g.drawImage(image, positionX, landY - image.getHeight(), null);
		g.setColor(Color.red);
//		Rectangle bound = getBound();
//		g.drawRect(bound.x, bound.y, bound.width, bound.height);
	}
	
	public Rectangle getRange() {
		range = new Rectangle();
		range.x = (int) positionX + (image.getWidth() - width)/2;
		range.y = landY - image.getHeight() + (image.getHeight() - height)/2;
		range.width = width;
		range.height = height;
		return range;
	}

	@Override
	public boolean outOfScreen() {
		if(positionX < -image.getWidth()) {
			return true;
		}
		return false;
	}
	
}

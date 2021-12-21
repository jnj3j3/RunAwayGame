package ObjectManagement;


import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import Source.Resource;

public class Land {
	
	public static final int landPosition = 1;
	
	private List<ImageLand> listLand;
	private BufferedImage land1;
	private BufferedImage land2;
	private int SelectedLand;
	
	private Character character;
	
	public Land(int width, Character character) {
		this.character = character;
		land1 = Resource.getResouceImage("data/building3 (10).png");
		land2 = Resource.getResouceImage("data/building1 (3).png");
		
		int numberOfImageLand = width / land1.getWidth() + 2;
		listLand = new ArrayList<ImageLand>();
		this.SelectedLand = getTypeOfLand();
		for(int i = 0; i < numberOfImageLand; i++) {
			ImageLand imageLand = new ImageLand();
			imageLand.posX = i * land1.getWidth();
			setImageLand(imageLand,SelectedLand);
			listLand.add(imageLand);
		}
	}
	
	public void update(){
		Iterator<ImageLand> itr = listLand.iterator();
		ImageLand firstElement = itr.next();
		firstElement.posX -= character.getSpeedX();
		float previousPosX = firstElement.posX;
		while(itr.hasNext()) {
			ImageLand element = itr.next();
			element.posX = previousPosX + land1.getWidth();
			previousPosX = element.posX;
		}
		if(firstElement.posX < -land1.getWidth()) {
			listLand.remove(firstElement);
			firstElement.posX = previousPosX + land1.getWidth();
			setImageLand(firstElement,SelectedLand);
			listLand.add(firstElement);
		}
	}
	
	private void setImageLand(ImageLand imgLand,int typeLand) {
		if(typeLand == 1) {
			imgLand.image = land1;
		} else if(typeLand == 2) {
			imgLand.image = land2;
		} 
	}
	
	public void draw(Graphics g) {
		for(ImageLand imgLand : listLand) {
			g.drawImage(imgLand.image, (int) imgLand.posX, landPosition, null);
		}
	}
	
	private int getTypeOfLand() {
		Random rand = new Random();
		int type = rand.nextInt(2);
		if(type == 1) {
			return 1;
		} else {
			return 2;
		} 
	}
	
	private class ImageLand {
		float posX;
		BufferedImage image;
	}
	
	public void reset() {
		this.SelectedLand = getTypeOfLand();
	}
	
}
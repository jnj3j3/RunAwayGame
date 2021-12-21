package ObjectManagement;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import UserInterface.Window;
import Source.Resource;

public class Clouds {
	private List<ImgCloud> cloudsList;
	private BufferedImage cloud;
	
	private Character character;
	
	public Clouds(int width, Character character) {
		this.character = character;
		cloud = Resource.getResouceImage("data/cloud1.png");
		cloudsList = new ArrayList<ImgCloud>();
		
		ImgCloud imgCloud = new ImgCloud();
		imgCloud.posX = 0;
		imgCloud.posY = 20;
		cloudsList.add(imgCloud);
		
		imgCloud = new ImgCloud();
		imgCloud.posX = 150;
		imgCloud.posY = 30;
		cloudsList.add(imgCloud);
		
		imgCloud = new ImgCloud();
		imgCloud.posX = 300;
		imgCloud.posY = 45;
		cloudsList.add(imgCloud);
		
		imgCloud = new ImgCloud();
		imgCloud.posX = 450;
		imgCloud.posY = 10;
		cloudsList.add(imgCloud);
		
	
	}
	
	public void update(){
		Iterator<ImgCloud> itr = cloudsList.iterator();
		ImgCloud firstElement = itr.next();
		firstElement.posX -= character.getSpeedX()/8;
		while(itr.hasNext()) {
			ImgCloud element = itr.next();
			element.posX -= character.getSpeedX()/8;
		}
		if(firstElement.posX < -cloud.getWidth()) {
			cloudsList.remove(firstElement);
			firstElement.posX = Window.screenWidth;
			cloudsList.add(firstElement);
		}
	}
	
	public void draw(Graphics g) {
		for(ImgCloud imgLand : cloudsList) {
			g.drawImage(cloud, (int) imgLand.posX, imgLand.posY, null);
		}
	}
	
	private class ImgCloud{
		float posX;
		int posY;
	}
}

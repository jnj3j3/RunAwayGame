package CharacterState;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import GameState.GameState;

public class DeathState implements State{
	CharacterState characterState;
	public DeathState(CharacterState state) {
		this.characterState = state;
	}
	public void draw(Graphics g,ArrayList<BufferedImage> list,int posX,int posY) {
		g.drawImage(list.get(3), (int) posX, (int) posY, null);
		}
	public void range(Rectangle nowRange,ArrayList<BufferedImage> image, int posX,int posY) {
		nowRange.x = (int) posX + 5;
		nowRange.y = (int) posY;
		nowRange.width = image.get(0).getWidth() - 10;
		nowRange.height = image.get(0).getHeight();
	}
	public void setRun() {
		characterState.setState(characterState.getRunState());
		
	}
	public void down(boolean isDown) {
		if(isDown) {
			characterState.setState(characterState.getDownState());
			
		} else {
			characterState.setState(characterState.getRunState());
			
		}
		
	}

}

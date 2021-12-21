package CharacterState;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public interface State {
	public abstract void draw(Graphics g,ArrayList<BufferedImage> list,int posX,int posY) ;
	public abstract void range(Rectangle rectangle,ArrayList<BufferedImage> list, int posX,int posY);
	public abstract void setRun();
	public abstract void down(boolean isDown);
}

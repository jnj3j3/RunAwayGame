package CharacterState;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class CharacterState {
	State RunState = new RunState(this);
	State DeathState = new DeathState(this);
	State DownRunState = new DownRunState(this);
	State JumpingState = new JumpingState(this);
	State state = this.RunState;
	public CharacterState() {
		
	}
	public void draw(Graphics g,ArrayList<BufferedImage> list,int posX,int posY) {
		state.draw(g, list, posX, posY);
	}
	public void range(Rectangle nowRange,ArrayList<BufferedImage> image, int posX,int posY) {
		state.range(nowRange, image, posX, posY);
	}
	public void down(boolean isDown) {
		state.down(isDown);
		
	}
	public void setRun() {
		state.setRun();
	}
	public void setState(State state) {
		this.state = state;
	}

	public State getRunState() {
		return RunState;
	}

	public State getDeathState() {
		return DeathState;
	}

	public State getDownState() {
		return DownRunState;
	}
	public State getJumpingState() {
		return JumpingState;
	}
}

package Source;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public class Animation { //System.currentTimeMillis()을 이용하여 설정한 Nexttime에 따라 ArrayList속 이미지를 변경할 수 있게

	private List<BufferedImage> animationList;
	private long NextTime;
	private int presentFrame = 0;
	private long previousTime;
	
	public Animation(int Nexttime) {
		this.NextTime = Nexttime; //img가 바뀌는 시간
		animationList = new ArrayList<BufferedImage>();
		previousTime = 0;
	}
	public void updateFrame() {
		if (System.currentTimeMillis() - previousTime >= NextTime) {
			presentFrame++;
			if (presentFrame >= animationList.size()) {
				presentFrame = 0;
			} //설정한 시간이 지났을때 img를 바꾼다.
			previousTime = System.currentTimeMillis();
		}
	}

	public void addFrame(BufferedImage image) {
		animationList.add(image); 
	}
	public BufferedImage getFrame() {
		return animationList.get(presentFrame);
	}

}
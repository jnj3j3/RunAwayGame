package Source;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public class Animation { //System.currentTimeMillis()�� �̿��Ͽ� ������ Nexttime�� ���� ArrayList�� �̹����� ������ �� �ְ�

	private List<BufferedImage> animationList;
	private long NextTime;
	private int presentFrame = 0;
	private long previousTime;
	
	public Animation(int Nexttime) {
		this.NextTime = Nexttime; //img�� �ٲ�� �ð�
		animationList = new ArrayList<BufferedImage>();
		previousTime = 0;
	}
	public void updateFrame() {
		if (System.currentTimeMillis() - previousTime >= NextTime) {
			presentFrame++;
			if (presentFrame >= animationList.size()) {
				presentFrame = 0;
			} //������ �ð��� �������� img�� �ٲ۴�.
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
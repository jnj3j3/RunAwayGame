package Source;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Resource { 
	public static BufferedImage getResouceImage(String path) {
		BufferedImage img = null;
		try {
		    img = ImageIO.read(new File(path)); // img경로 설정
		} catch (IOException e) {
			e.printStackTrace();
		}
		return img;
	}
	
}

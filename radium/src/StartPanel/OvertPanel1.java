package StartPanel;

import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;

import modle.GObject;
import GameObject.Hero;

public class OvertPanel1 extends GObject {
	private static Image img1 = null;
	private static Image label1 =null;
	private static Image img2 = null;
	private static Image label2 =null;
	private static Image img3 = null;
	private static Image img4 = null;
	private static Image img5 = null;
	private static Image img6 = null;
	private static Image img7 = null;
	private static Image img8 = null;
	static {
		try {
			img1 = ImageIO.read(Hero.class.getClassLoader()
					.getResourceAsStream("退出.png"));
			img2 = ImageIO.read(Hero.class.getClassLoader()
					.getResourceAsStream("重新开始.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	@Override
	protected void draw(Graphics g) {
		g.drawImage(img1,170, 575, 114, 25, null);
		g.drawImage(img2,490, 570, 114, 30, null);
		

	}

}


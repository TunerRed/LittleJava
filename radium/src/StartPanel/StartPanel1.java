package StartPanel;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;

import modle.GObject;
import GameObject.Hero;

public class StartPanel1 extends GObject {
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
					.getResourceAsStream("¼ÌÐø.png"));
			label1 = ImageIO.read(Hero.class.getClassLoader()
					.getResourceAsStream("ÍË³ö°´Å¥.png"));
			img2 = ImageIO.read(Hero.class.getClassLoader()
					.getResourceAsStream("ÍË³ö.png"));
			label2 = ImageIO.read(Hero.class.getClassLoader()
					.getResourceAsStream("ÍË³ö°´Å¥.png"));
			img3 = ImageIO.read(Hero.class.getClassLoader()
					.getResourceAsStream("ÓÎÏ·Ãû.png"));
			img5 = ImageIO.read(Hero.class.getClassLoader()
					.getResourceAsStream("·É»ú°´Å¥.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	protected void draw(Graphics g) {
		g.setFont(new Font("·ÂËÎ",1,80));
		g.drawString("ÀÏÂèÄ¸Ç×½Ú¿ìÀÖ", 210,240 );
		g.drawImage(img1,200, 300, 60, 30, null);
		g.drawImage(img2,200, 400, 114, 30, null);
		g.drawImage(img3,200, 20, 431, 91, null);
		g.drawImage(label1,300 ,300 ,70,25 , null);
		g.drawImage(label2,350 ,400 ,75,28 , null);
		g.drawImage(img5,370, 500, 70, 70, null);

	}

}

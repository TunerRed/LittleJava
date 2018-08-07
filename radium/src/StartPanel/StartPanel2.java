package StartPanel;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;

import modle.GObject;
import modle.Game;
import modle.Status;
import GameObject.Hero;

public class StartPanel2 extends GObject {
	private static Image img1 = null;
	private static Image img2 = null;
	private static Image img3 = null;
	private static Image img4 = null;
	private static Image img5 = null;
	private static Image img6 = null;
	private static long mill = 0;
	private static int count = 1;
	private int time = 0;
	static {
		try {
			img1 = ImageIO.read(Hero.class.getClassLoader()
					.getResourceAsStream("背景.png"));
			img2 = ImageIO.read(Hero.class.getClassLoader()
					.getResourceAsStream("load1.png"));
			img3 = ImageIO.read(Hero.class.getClassLoader()
					.getResourceAsStream("load2.png"));
			img4 = ImageIO.read(Hero.class.getClassLoader()
					.getResourceAsStream("load3.png"));
			img5 = ImageIO.read(Hero.class.getClassLoader()
					.getResourceAsStream("按钮1.png"));
			img6 = ImageIO.read(Hero.class.getClassLoader()
					.getResourceAsStream("陈龙.png"));

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public  boolean checkTimeGap(int gap) {
		boolean timeGap = false;
		if (mill != 0) {
			if (Math.abs(mill - System.currentTimeMillis()) > gap) {
				mill = System.currentTimeMillis();
				this.time++;
				timeGap = true;
			}

			return timeGap;
		} else {
			mill = System.currentTimeMillis();
			this.time++;
			return true;
		}
	}

	@Override
	// ///////////////////////////count记录当前的图片是哪一张。loading图的切换的时间为1000ms
	protected void draw(Graphics g) {
		if (Game.game.status == Status.LOADING) {
			g.drawImage(img1, 130, 50, 600, 600, null);
			g.drawImage(img5, 245, 370, 220, 220, null);
			g.drawImage(img6, 390, 510, 70, 70, null);
			g.setFont(new Font("楷体", 2, 36));
			g.drawString("宋鑫涛", 249, 540);
			g.drawString("陈龙", 250, 580);
			if (checkTimeGap(1000)) {
				count++;
				if (count > 4)
					count = 1;
			}
			if (time == 8) {
				Game.game.status = Status.RUNNING;
				Game.game.changeStatus();
			}
			if (count == 1) {
				g.drawImage(img2, 250, 300, 48, 36, null);

			}
			if (count == 2) {
				g.drawImage(img3, 300, 300, 108, 37, null);

			}
			if (count == 3) {
				g.drawImage(img4, 400, 300, 176, 36, null);

			}
			if (count == 4) {
				g.drawImage(img5, 500, 300, 2, 4, null);

			}

		}
	}

}

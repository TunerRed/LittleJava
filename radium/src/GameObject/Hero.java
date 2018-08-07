package GameObject;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.io.IOException;
import java.util.Properties;

import javax.imageio.ImageIO;

import modle.Direction;
import modle.Firestrategy;
import modle.GObject;
import modle.Game;
import modle.Status;
import radium.GameMain;
import Fire_Strategy.FireOne;

public class Hero extends GObject {
	private static Properties proper;
	public static boolean lazy=false;
	public Firestrategy firestrategy = new FireOne();
	private int step = 0;
	private BloodValue bloodObject;
	private Image img = null, img1 = null;
	private boolean rank = true; // rank is stands for the style of hero
	public Direction dir2;
	public boolean d1 = false, d2 = false;
	public long mill = 0;

	public Hero() {
		super();
		speed = 8;
		width = 40;
		height = 50;
		x = (GameMain.CWIDTH - this.width) / 2;
		y = (GameMain.CHEIGHT - this.height);
		try {
			img = ImageIO.read(Hero.class.getClassLoader().getResourceAsStream(
					"hero2.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			img1 = ImageIO.read(Hero.class.getClassLoader()
					.getResourceAsStream("hero1.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		proper = new Properties();
		try {
			proper.load(Hero.class.getClassLoader().getResourceAsStream(
					"config\\fire_strategy.properties"));
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		bloodvalue = 2000;
		bloodObject = new BloodValue(this, 0, 0);
	}

	public void move() {

		if (dir == dir2 && d1 && d2)
			d1 = false;
		if (d1) {
			switch (dir) {
			case U:
				y -= speed;
				break;
			case D:
				y += speed;
				break;
			case L:
				x -= speed;
				break;
			case R:
				x += speed;
				break;

			}
		}
		if (d2) {
			switch (dir2) {
			case U:
				y -= speed;
				break;
			case D:
				y += speed;
				break;
			case L:
				x -= speed;
				break;
			case R:
				x += speed;
				break;

			}
		}
	}

	public void paint(Graphics g) {
		check();
		move();
		draw(g);

	}

	protected void draw(Graphics g) {
		if (Game.getGame().status == Status.RUNNING) {
			if (rank) {
				g.drawImage(img, x, y, width, height, null);
				rank = false;
			} else {
				g.drawImage(img1, x, y, width, height, null);
				rank = true;

			}
			System.out.println();
		}
	}

	protected void check() {
		if (x <= -10)
			x = -10;
		if (y <= 0)
			y = 0;
		if ((x + width) >= GameMain.CWIDTH + 10)
			x = GameMain.CWIDTH - width + 10;
		if ((y + height) >= GameMain.CHEIGHT)
			y = GameMain.CHEIGHT - height;

	}

	
	
	
	
	public boolean checkTimeGap(int gap) {
		boolean timeGap = false;
		if (mill != 0) {
			if (Math.abs(mill - System.currentTimeMillis()) > gap){
				mill = System.currentTimeMillis();
				timeGap = true;
			}

			return timeGap;
		} else {
			mill = System.currentTimeMillis();
			return true;
		}
	}

	
	
	
	
	
	public void AddBloodValue(int value) {

		super.AddBloodValue(value);
		if (bloodvalue < 0) {

			bloodvalue = 0;
			this.dead = true;
		}
		this.bloodObject.AddBloodValue(value);
	}

	public void changestep() {
		System.out.println("step is" + step);
		String classname = proper.getProperty("S" + step);
		step++;
		System.out.println(classname);
		try {
			firestrategy = (Firestrategy) Class.forName(classname)
					.newInstance();
		} catch (InstantiationException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}

	}

	public void hit() {
		if(checkTimeGap(150)||lazy)
		firestrategy.Fire(x, y, true);

	}

	public Rectangle Rect() {
		return new Rectangle(x, y, width, (int) ((93 / 123.0) * height));
	}

	public void move(Direction dir) {
		switch (dir) {
		case U:
			y -= speed;
			break;
		case D:
			y += speed;
			break;
		case L:
			x -= speed;
			break;
		case R:
			x += speed;
			break;
		case UL:
			x -= speed;
			y -= speed;
			break;
		case UR:
			x += speed;
			y -= speed;
			break;
		case DL:
			x -= speed;
			y += speed;
			break;
		case DR:
			x += speed;
			y += speed;
			break;

		}

	}

}

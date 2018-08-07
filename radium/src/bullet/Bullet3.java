package bullet;

import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;

import modle.Direction;
import GameObject.Hero;

public class Bullet3 extends Bullet {
	private static Image img;
	private static final int WIDTH = 9, HEIGHT = 21, SPEED = 20, ESPEED = 7;
	private int step = 1;
	static {
		try {
			img = ImageIO.read(Hero.class.getClassLoader().getResourceAsStream(
					"bullet2.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public Bullet3(int x, int y, Direction dir) {

		super(x, y, dir, true);
		width = WIDTH;
		if (!good) {
			speed = ESPEED;
			this.bloodvalue = -75;
		} else {
			speed = SPEED;
			this.bloodvalue = -100;
		}
		height = HEIGHT;
		speed = SPEED;
		good = false;
	}

	public Bullet3(int x, int y, Direction dir, boolean good) {

		super(x, y, dir, good);
		this.good = good;

		width = WIDTH;
		height = HEIGHT;
		if (!good) {
			speed = ESPEED;
			this.bloodvalue = -75;
		} else {
			speed = SPEED;
			this.bloodvalue = -100;
		}
	}

	@Override
	protected void draw(Graphics g) {
		g.drawImage(img, x, y, width, height, null);
	}

	@Override
	protected void move() {
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
			x -= speed / 3;
			y += speed;
			break;
		case DR:
			x += speed / 3;
			y += speed;
			break;

		}

	}

}

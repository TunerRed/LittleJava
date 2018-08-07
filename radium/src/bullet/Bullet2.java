package bullet;

import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;

import modle.Direction;
import GameObject.Hero;

public class Bullet2 extends Bullet {
	private static Image img;
	private static final int WIDTH = 12, HEIGHT = 15, SPEED = 20, ESPEED = 13;
	public int xspeed = 20;
	static {
		try {
			img = ImageIO.read(Hero.class.getClassLoader().getResourceAsStream(
					"bullet1.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public Bullet2(int x, int y, Direction dir) {
		super(x, y, dir, true);
		width = WIDTH;
		height = HEIGHT;
		speed = SPEED;
		if (!good) {
			this.bloodvalue = -100;
			speed = ESPEED;
		} else
			this.bloodvalue = -20;
		good = false;
	}

	public Bullet2(int x, int y, Direction dir, boolean good) {
		super(x, y, dir, good);
		this.good = good;
		width = WIDTH;
		height = HEIGHT;
		if (!good) {
			speed=ESPEED;
			this.bloodvalue = -100;
		} else
			this.bloodvalue = -20;
		speed = SPEED;
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
			x -= xspeed;
			break;
		case R:
			x += xspeed;
			break;
		case UL:
			x -= xspeed;
			y -= speed;
			break;
		case UR:
			x += xspeed;
			y -= speed;
			break;
		case DL:
			x -= xspeed;
			y += speed;
			break;
		case DR:
			x += xspeed;
			y += speed;
			break;

		}

	}

}

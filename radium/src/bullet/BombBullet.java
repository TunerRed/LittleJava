package bullet;

import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;

import modle.Direction;
import GameObject.Hero;

public class BombBullet extends Bullet {
	private static Image img;
	private static final int WIDTH = 50, HEIGHT = 65, SPEED = 16;
	static {
		try {
			img = ImageIO.read(Hero.class.getClassLoader().getResourceAsStream(
					"bomb1.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public BombBullet(int x, int y, Direction dir) {

		super(x, y, dir,true);
		width = WIDTH;
		height = HEIGHT;
		speed = SPEED;
		good=false;
	}

	public BombBullet(int x, int y, Direction dir, boolean good) {

		super(x, y, dir,good);
		this.good = good;
		width = WIDTH;
		speed=SPEED;
		height = HEIGHT;
	}

	@Override
	protected void draw(Graphics g) {
		g.drawImage(img, x-20, y-40, width, height, null);
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
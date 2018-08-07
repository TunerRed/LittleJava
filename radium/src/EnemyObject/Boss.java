package EnemyObject;

import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;

import modle.Direction;
import GameObject.Enemy;
import GameObject.Hero;
import bullet.Bullet1;
import bullet.Bullet3;
import bullet.Lightbullet1;

public class Boss extends Enemy {
	private static Image img = null;
	private static Hero hero;
	private static long count = 0;
	static {
		try {
			img = ImageIO.read(Boss.class.getClassLoader().getResourceAsStream(
					"boss.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public Boss() {
		this.x = 300;
		this.y = 20;
		this.bloodvalue = 3500;
		this.height = 967 / 4;
		this.width = 831 / 3;
		this.speed = 5;
		this.dir = Direction.L;
		this.good = false;

	}

	protected void draw(Graphics g) {
		if ((int) (Math.random() * 6) == 5) {
			Direction m = null;
			if ((int) (Math.random() * 3) == 2) {
				dir = Direction.L;
			} else
				dir = Direction.R;
		}
		move(dir);
		fire();
		g.drawImage(img, x, y, width, height, null);
		count++;

	}

	@Override
	protected void fire() {
		if (count % 30 == 0) {
			new Bullet3(x + width / 2, y + 100, Direction.D, false);
			new Bullet3(x + width / 2 - 10, y + 100, Direction.D, false);
			new Bullet3(x + width / 2 - 20, y + 100, Direction.DL, false);
			new Bullet3(x + width / 2 + 10, y + 100, Direction.D, false);
			new Bullet3(x + width / 2 + 20, y + 100, Direction.DR, false);

		}
		if (count % 90 == 0 || count % 91 == 0 || count % 92 == 0
				|| count % 93 == 0 || count % 94 == 0 || count % 95 == 0
				|| count % 96 == 0 || count % 97 == 0) {
			new Lightbullet1(x + width / 2, y, Direction.D, false);
		}
		if (count % 12 == 0)
			new Bullet1(x + width / 2, y + 100, Direction.D, false);
	}

	protected void move(Direction dir) {
		switch (dir) {
		case L:
			x -= speed;
			break;
		case R:
			x += speed;
			break;
		}
	}

}

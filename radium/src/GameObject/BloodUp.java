package GameObject;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

import modle.Direction;
import radium.GameMain;

public class BloodUp extends AwardObject {
	public static Image img = null;
	static {
		try {
			img = ImageIO.read(Hero.class.getClassLoader().getResourceAsStream(
					"blood.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public BloodUp() {
		dir = Direction.D;
		this.width = 38;
		this.height = 38;
		Random random = new Random();
		x = random.nextInt(GameMain.CWIDTH - width);
		y = random.nextInt(GameMain.CHEIGHT - height);
		bloodvalue =((int) (Math.random() * 1000) + 400);
		speed = 1;
	}

	@Override
	protected void draw(Graphics g) {
		if ((int) (Math.random() * 10) == 5) {
			Direction[] ds = Direction.values();
			Direction tempdir = ds[(int) (Math.random() * ds.length)];
			if (tempdir == Direction.D || tempdir == Direction.DL
					|| tempdir == Direction.DR){
				dir = tempdir;}

		}
		move(dir);
		g.drawImage(img, x, y, width, height, null);

	}

	@Override
	protected void move(Direction dir) {
		switch (dir) {
		case D:
			y += speed/2;
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

	@Override
	protected void check() {
		super.check();
		if(y+height>=GameMain.CHEIGHT)
		this.dead=true;
	}

	@Override
	public Rectangle Rect() {
		return new Rectangle(x, y + (int) ((2 / 3.0) * height), width,
				(int) ((1 / 3.0) * height));
	}

}
package GameObject;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

import modle.Direction;
import modle.GObject;

public abstract class Enemy extends GObject {
	public static Image img = null;

	protected abstract void draw(Graphics g);

	public Enemy() {
		good = false;
	}

	protected void move(Direction dir) {
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

	protected abstract void fire();

	protected void check() {
		super.check();
		// if (y + height >= GameMain.CHEIGHT)
		// this.dead = true;
	}
	public void AddBloodValue(int value) {
		bloodvalue += value;
		if(bloodvalue<=0)
			dead=true;

	}
	@Override
	public Rectangle Rect() {
		return new Rectangle(x, y, width, height);
	}

}

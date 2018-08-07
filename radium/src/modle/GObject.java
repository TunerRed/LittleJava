package modle;

import java.awt.Graphics;
import java.awt.Rectangle;

import radium.GameMain;

public abstract class GObject {
	public boolean good=true;
	public int x;
	public int y;
	protected int width;
	protected int height;
	public int speed;
	public boolean dead = false;
	protected Direction dir;
	public int bloodvalue;

	public void paint(Graphics g) {
		check();
		move();
		draw(g);
		
	}

	protected void move() {
	}

	public GObject() {
		/**
		 * 
		 * 
		 * */
		Game.getGame().objects[Game.getGame().m].add(this);
	}

	protected abstract void draw(Graphics g);

	protected boolean dead() {
		return dead;
	}

	protected void check() {
		if (x <= 0)
			x = 0;
		if (y <= 0)
			y = 0;
		if ((x + width) >= GameMain.CWIDTH)
			x = GameMain.CWIDTH - width;
		if ((y + height) >= GameMain.CHEIGHT)
			y = GameMain.CHEIGHT - height;

	}

	protected void move(Direction dir) {

	}

	public Rectangle Rect() {

		return new Rectangle(this.x,this. y, width, height);

	}

	public void AddBloodValue(int value) {
		bloodvalue += value;

	}
}
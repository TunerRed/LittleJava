package EnemyObject;

import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;

import modle.Direction;
import modle.Game;
import radium.GameMain;
import GameObject.Enemy;
import GameObject.Hero;
import bullet.Bullet1;

public class Enemy1 extends Enemy {
	private static Image img = null;
	private Hero hero;
	private long mill = 0;
	static {
		try {
			img = ImageIO.read(Enemy1.class.getClassLoader()
					.getResourceAsStream("enemy0.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public Enemy1() {
		this.x = (int) (Math.random() * GameMain.CWIDTH) + 10;
		this.y = (int) (Math.random() * 200) + 20;
		this.bloodvalue = 110;
		this.dir = Direction.D;
		this.height = 27;
		this.width = 36;
		this.speed = 4;
		hero = Game.getGame().hero;
		this.good = false;

	}

	protected void draw(Graphics g) {
		if ((int) (Math.random() * 6) == 5) {
			Direction[] ds = Direction.values();
			dir = ds[(int) (Math.random() * ds.length)];
		}
		move(dir);
		fire();
		g.drawImage(img, x, y, width, height, null);
	}

	public boolean checkTimeGap(int gap) {
		boolean timeGap = false;
		if (mill != 0) {
			if (Math.abs(mill - System.currentTimeMillis()) > gap) {
				mill = System.currentTimeMillis();
				timeGap = true;
			}

			return timeGap;
		} else {
			mill = System.currentTimeMillis();
			return true;
		}
	}

	protected void fire() {
		if (checkTimeGap(200))
			if ((int) (Math.random() * 6) == 5) {
				Direction m = null;
				if (this.x - hero.x >= 0 && this.y - hero.y >= 0) 
					m = Direction.UL;
				
				if (this.x - hero.x >= 0 && this.y - hero.y <= 0)
					m = Direction.DL;
				if (this.x - hero.x <= 0 && this.y - hero.y >= 0)
					m = Direction.UR;
				if (this.x - hero.x <= 0 && this.y - hero.y <= 0)
					m = Direction.DR;
				new Bullet1(x + width / 2, y, m, false);

			}

	}

}

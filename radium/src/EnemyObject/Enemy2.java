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
import bullet.Bullet4;

public class Enemy2 extends Enemy {
	private static Image img = null;
	private Hero hero;
	static {
		try {
			img = ImageIO.read(Enemy1.class.getClassLoader().getResourceAsStream(
					"enemy1.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public Enemy2() {
		this.x = (int) (Math.random() * GameMain.CWIDTH) + 10;
		this.y = (int) (Math.random() * 200) + 20;
		this.bloodvalue = 300;
		this.dir = Direction.D;
		this.height = 70;
		this.width = 56;
		this.speed = 2;
		hero=Game.getGame().hero;
		this.good=false;

	}

	protected void draw(Graphics g) {
		if ((int) (Math.random() * 10) == 5) {
			Direction[] ds = Direction.values();
			 dir = ds[(int) (Math.random() * ds.length)];
		}
		move(dir);
		fire();
		g.drawImage(img, x, y, width, height, null);
	}

	@Override
	protected void fire() {
		if ((int) (Math.random() * 24) == 5) {
			Direction m = null;
			if (this.x - hero.x >= 0 && this.y - hero.y >= 0)
				m = Direction.UL;
			if (this.x - hero.x >= 0 && this.y - hero.y <= 0)
				m = Direction.DL;
			if (this.x - hero.x <= 0 && this.y - hero.y >= 0)
				m = Direction.UR;
			if (this.x - hero.x <= 0 && this.y - hero.y <= 0)
				m = Direction.DR;
			new Bullet4(x + width / 2-2, y+height, m,false);
			new Bullet4(x + width / 2+14, y+height, Direction.D,false);
			
		}

	}

}

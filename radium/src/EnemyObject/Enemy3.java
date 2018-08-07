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
import bullet.Bullet4;

public class Enemy3 extends Enemy {
	private static Image img = null;
	private Hero hero;
	static {
		try {
			img = ImageIO.read(Enemy1.class.getClassLoader().getResourceAsStream(
					"enemy2.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public Enemy3() {
		this.x = (int) (Math.random() * GameMain.CWIDTH) + 10;
		this.y = (int) (Math.random() * 200) + 20;
		this.bloodvalue = 430;
		this.dir = Direction.D;
		this.height = 80;
		this.width = 60;
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
		if ((int) (Math.random() * 30) == 5) {
			new Bullet4(x + width / 2, y+height, Direction.DL,false);
			new Bullet4(x + width / 2+10, y+height, Direction.DR,false);
			
		}
		if((int) (Math.random() * 10) == 5)
			new Bullet1(x + width / 2+10, y+height, Direction.DR,false);

	}

}

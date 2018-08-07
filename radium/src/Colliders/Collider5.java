package Colliders;

import modle.Collide;
import modle.Direction;
import modle.GObject;
import musicThread.Music;
import EnemyObject.Enemy1;
import EnemyObject.Enemy2;
import EnemyObject.Enemy3;
import Exploders.Exploder1;
import Exploders.Exploder2;
import Exploders.Exploder3;
import bullet.BombBullet;
import bullet.Bullet2;

public class Collider5 implements Collide {
	public static Collider6 next = null;

	public void DowithCollide(GObject go1, GObject go2) {
		DowithCollide1(go1, go2);
		DowithCollide2(go1, go2);
		DowithCollide3(go1, go2);
		next.DowithCollide(go1, go2);
		
	}

	private void DowithCollide1(GObject go1, GObject go2) {
		if (go1.Rect().intersects(go2.Rect()) && Judge(go1.good, go2.good)) {
			if (go1 instanceof Enemy1 && go2 instanceof BombBullet) {
				go2.dead = true;
				go1.dead =true;
				new Bullet2(go2.x, go2.y, Direction.U, true);
				new Bullet2(go2.x, go2.y, Direction.D, true);
				new Bullet2(go2.x, go2.y, Direction.UL, true);
				new Bullet2(go2.x, go2.y, Direction.UR, true);
				new Bullet2(go2.x, go2.y, Direction.DL, true);
				new Bullet2(go2.x, go2.y, Direction.DR, true);
				new Bullet2(go2.x, go2.y, Direction.L, true);
				new Bullet2(go2.x, go2.y, Direction.R, true);
				new Exploder1(go1.x, go1.y);
			} else {
				if (go2 instanceof Enemy1 && go1 instanceof BombBullet)
					DowithCollide1(go2, go1);
			}
		}
	}

	private void DowithCollide2(GObject go1, GObject go2) {
		if (go1.Rect().intersects(go2.Rect()) && (Judge(go1.good, go2.good))) {
			if (go1 instanceof Enemy2 && go2 instanceof BombBullet) {
				go2.dead = true;
				go1.dead =true;
				new Bullet2(go2.x, go2.y, Direction.U, true);
				new Bullet2(go2.x, go2.y, Direction.D, true);
				new Bullet2(go2.x, go2.y, Direction.UL, true);
				new Bullet2(go2.x, go2.y, Direction.UR, true);
				new Bullet2(go2.x, go2.y, Direction.DL, true);
				new Bullet2(go2.x, go2.y, Direction.DR, true);
				new Bullet2(go2.x, go2.y, Direction.L, true);
				new Bullet2(go2.x, go2.y, Direction.R, true);
				new Exploder2(go1.x, go1.y);
			} else {
				if (go2 instanceof Enemy2 && go1 instanceof BombBullet)
					DowithCollide2(go2, go1);
			}
		}
	}

	private void DowithCollide3(GObject go1, GObject go2) {
		if (go1.Rect().intersects(go2.Rect()) && Judge(go1.good, go2.good)) {
			if (go1 instanceof Enemy3 && go2 instanceof BombBullet) {
				go2.dead = true;
				go1.dead =true;
				new Bullet2(go2.x, go2.y, Direction.U, true);
				new Bullet2(go2.x, go2.y, Direction.D, true);
				new Bullet2(go2.x, go2.y, Direction.UL, true);
				new Bullet2(go2.x, go2.y, Direction.UR, true);
				new Bullet2(go2.x, go2.y, Direction.DL, true);
				new Bullet2(go2.x, go2.y, Direction.DR, true);
				new Bullet2(go2.x, go2.y, Direction.L, true);
				new Bullet2(go2.x, go2.y, Direction.R, true);
				new Exploder3(go1.x, go1.y);
			} else {
				if (go2 instanceof Enemy3 && go1 instanceof BombBullet)
					DowithCollide3(go2, go1);

			}
		}
	}

	protected boolean Judge(boolean a, boolean b) {
		if ((a && b) || (!a && !b))
			return false;
		else
			return true;

	}
}

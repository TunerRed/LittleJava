package Colliders;

import modle.Collide;
import modle.GObject;
import modle.Game;
import modle.Status;
import musicThread.Music;
import EnemyObject.Boss;
import EnemyObject.Enemy1;
import EnemyObject.Enemy2;
import EnemyObject.Enemy3;
import Exploders.Exploder1;
import Exploders.Exploder2;
import Exploders.Exploder3;
import bullet.BombBullet;
import bullet.Bullet;

// 友方子弹队敌机
public class Collider3 implements Collide {
	public static Collider4 next = null;
	public void DowithCollide(GObject go1, GObject go2) {
		DowithCollide1(go1, go2);
		DowithCollide2(go1, go2);
		DowithCollide3(go1, go2);
		DowithCollide4(go1, go2);
		next.DowithCollide(go1, go2);

	}

	private void DowithCollide1(GObject go1, GObject go2) {

		if (go1.Rect().intersects(go2.Rect()) && Judge(go1.good, go2.good)) {
			if (go1 instanceof Enemy1 && go2 instanceof Bullet
					&& !(go2 instanceof BombBullet)) {
				go2.dead = true;
				go1.AddBloodValue(go2.bloodvalue);
				if (go1.dead) {
					Music.run2();
					new Exploder1(go1.x, go1.y);
				}
			} else {
				if (go2 instanceof Enemy1 && go1 instanceof Bullet)
					DowithCollide1(go2, go1);
			}
		}
	}
	private void DowithCollide2(GObject go1, GObject go2) {
		if (go1.Rect().intersects(go2.Rect()) && (Judge(go1.good, go2.good))) {
			if (go1 instanceof Enemy2 && go2 instanceof Bullet
					&& !(go2 instanceof BombBullet)) {
				go2.dead = true;
				go1.AddBloodValue(go2.bloodvalue);
				if (go1.dead) {
					Music.run3();
					new Exploder2(go1.x, go1.y);
				}
			} else {
				if (go2 instanceof Enemy2 && go1 instanceof Bullet)
					DowithCollide2(go2, go1);
			}
		}
	}

	private void DowithCollide3(GObject go1, GObject go2) {
		if (go1.Rect().intersects(go2.Rect()) && Judge(go1.good, go2.good)) {
			if (go1 instanceof Enemy3 && go2 instanceof Bullet
					&& !(go2 instanceof BombBullet)) {
				go2.dead = true;
				go1.AddBloodValue(go2.bloodvalue);
				if (go1.dead) {
					Music.run3();
					new Exploder3(go1.x, go1.y);
				}
			} else {
				if (go2 instanceof Enemy3 && go1 instanceof Bullet)
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
	private void DowithCollide4(GObject go1, GObject go2) {
		if (go1.Rect().intersects(go2.Rect()) && Judge(go1.good, go2.good)) {
			if (go1 instanceof Boss && go2 instanceof Bullet
					&& !(go2 instanceof BombBullet)) {
				go2.dead = true;
				go1.AddBloodValue(go2.bloodvalue);
				if (go1.dead) {
					Music.run2();
					Game.game.status = Status.OVER;
					Game.game.changeStatus();
				}
			} else {
				if (go2 instanceof Enemy1 && go1 instanceof Bullet)
					DowithCollide1(go2, go1);
			}
		}
	}

}

package Colliders;

import modle.Collide;
import modle.GObject;
import Exploders.Exploder4;
import GameObject.Hero;
import bullet.BombBullet;
import bullet.Bullet;

// 友方子弹队敌机
public class Collider6 implements Collide {
	public static Collider7 next = null;
	public void DowithCollide(GObject go1, GObject go2){
		DowithCollide1(go1,go2);
		next.DowithCollide(go1,go2);
	}
	public void DowithCollide1(GObject go1, GObject go2) {

		if (go1.Rect().intersects(go2.Rect())  &&Judge(go1.good, go2.good)) {
			if (go1 instanceof Hero && go2 instanceof Bullet&&!(go2 instanceof BombBullet) ) {
				go2.dead = true;
				go1.AddBloodValue(go2.bloodvalue);
				if (go1.dead){
					new Exploder4(go1.x, go1.y);

				}
			} else {
				if (go2 instanceof Hero && go1 instanceof Bullet)
					DowithCollide1(go2, go1);
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

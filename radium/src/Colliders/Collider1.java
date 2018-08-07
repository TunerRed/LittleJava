package Colliders;

import modle.Collide;
import modle.GObject;
import musicThread.Music;
import GameObject.BloodUp;
import GameObject.Hero;

public class Collider1 implements Collide {
	public static Collider2 next = null;

	@Override
	public void DowithCollide(GObject go1, GObject go2) {
       	if (go1.Rect().intersects(go2.Rect())&&!go1.dead&&!go2.dead) {

			if (go1 instanceof Hero && go2 instanceof BloodUp) {
				go2.dead = true;
				go1.AddBloodValue(go2.bloodvalue);
                Music.run6();
			} else {
				if (go2 instanceof Hero && go1 instanceof BloodUp)
					DowithCollide(go2, go1);
				else {
					next.DowithCollide(go1, go2);
				}

			}
		}
	}
}

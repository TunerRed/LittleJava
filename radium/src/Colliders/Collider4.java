package Colliders;

import modle.Collide;
import modle.GObject;
import musicThread.Music;
import radium.GameMain;
import GameObject.BombObject;
import GameObject.Hero;

public class Collider4 implements Collide {
	public static Collider5 next = null;
	@Override
	public void DowithCollide(GObject go1, GObject go2) {
       	if (go1.Rect().intersects(go2.Rect())&&!go1.dead&&!go2.dead) {
			if (go1 instanceof Hero && go2 instanceof BombObject) {
				go2.dead = true;
				GameMain.bombcount++;
				Music.run6();
			} else {
				if (go2 instanceof Hero && go1 instanceof BombObject)
					DowithCollide(go2, go1);
				else {
				        next.DowithCollide(go1, go2);
				}

			}
		}
	}
}

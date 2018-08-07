package Colliders;

import modle.Collide;
import modle.GObject;
import musicThread.Music;
import GameObject.Hero;
import GameObject.StrategyUp;
import bullet.Lightbullet;

public class Collider2 implements Collide {
	public static Collider3 next = null;

	@Override
	
	
		public void DowithCollide(GObject go1, GObject go2) {
			// TODO 自动生成的方法存根
		if (go1 instanceof Lightbullet  && go2 instanceof Lightbullet) {
			}
				if (go1 instanceof Hero && go2 instanceof StrategyUp) {
					go2.dead = true;
					((Hero)go1).changestep();
					Music.run7();

				} else {
					if (go2 instanceof Hero && go1 instanceof StrategyUp)
						DowithCollide(go2, go1);
					else {
						
						next.DowithCollide(go1, go2);
					}

				}
			} 
		
}

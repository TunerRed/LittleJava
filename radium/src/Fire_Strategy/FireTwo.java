package Fire_Strategy;

import modle.Direction;
import modle.Firestrategy;
import bullet.Bullet;
import bullet.Bullet2;

public class FireTwo extends Firestrategy {

	@Override
	public void Fire(int x, int y, boolean good) {
		// TODO 自动生成的方法存根
		super.Fire(x, y, good);
		Bullet2 bullet1 = new Bullet2(x + 16, y, Direction.U, good);
		bullet1.xspeed = bullet1.speed / 4;
		Bullet2 bullet2 = new Bullet2(x + 16, y, Direction.UL, good);
		bullet2.xspeed = bullet1.speed / 4;
		Bullet2 bullet3 = new Bullet2(x + 16, y, Direction.UR, good);
		bullet3.xspeed = bullet1.speed / 4;
	}

}

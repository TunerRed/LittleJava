package Fire_Strategy;

import modle.Direction;
import modle.Firestrategy;
import musicThread.Music;
import bullet.BombBullet;
import bullet.Bullet2;

public class FireThree extends Firestrategy {

	@Override
	public void Fire(int x, int y,boolean good) {
		// TODO 自动生成的方法存根
		super.Fire(x, y,good);
		new BombBullet(x+16, y, Direction.U,good);
		
	}

}

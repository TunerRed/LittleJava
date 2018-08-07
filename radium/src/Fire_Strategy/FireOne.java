package Fire_Strategy;

import modle.Direction;
import modle.Firestrategy;
import musicThread.Music;
import bullet.Bullet1;

public class FireOne extends Firestrategy {

	@Override
	public void Fire(int x, int y,boolean good) {
		// TODO 自动生成的方法存根
		super.Fire(x, y,good);
		Music.run5();
		new Bullet1(x+16, y, Direction.U,good);
	}

}

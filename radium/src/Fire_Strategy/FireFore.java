package Fire_Strategy;

import modle.Direction;
import modle.Firestrategy;
import bullet.Bullet1;
import bullet.Bullet3;

public class FireFore extends Firestrategy{

	@Override
	public void Fire(int x, int y,boolean good) {
		// TODO 自动生成的方法存根
		super.Fire(x, y,good);
		new Bullet1(x+16,y,Direction.UR,good);
		new Bullet1(x+16,y,Direction.UL,good);
		new Bullet1(x+16,y,Direction.UL,good);
		new Bullet1(x+16,y,Direction.UR,good);
		new Bullet3(x+16,y,Direction.U,good);
	}

}

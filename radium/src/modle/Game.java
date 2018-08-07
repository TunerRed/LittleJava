package modle;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.util.LinkedList;

import musicThread.Music;
import radium.GameMain;
import Colliders.Colliders;
import GameObject.Hero;
import bullet.BombBullet;

public class Game {
	// ////////////////////////////////////// 拥有的游戏物体
	public static Hero hero;
	public static BackGround bg;
	public static LinkedList<GObject> objects[] = new LinkedList[10];

	public static Game game = new Game();
	private static int step = 1;
	private static long mill = 0;
	public static Status status = Status.READY;
	public static Thread thread = null;
	public int m = 1;// m 代表的是
	// /////////////////////////////////////
	static {
		for (int i = 1; i <= 9; i++)
			objects[i] = new LinkedList<GObject>();
		thread = new GameStartThread();
	}
	private boolean up = false, down = false, left = false, right = false,
			hitB = false, space = false;

	public void init() {
		changeStatus();

	}

	public void changeStatus() {
		checkM();
		if (status != Status.LOADING)
			bg = new BackGround();
		if (status == Status.RUNNING)
			hero = new Hero();
		if (status == Status.READY) {
			Music.run9();
			thread.interrupt();
			thread = new GameStartThread();
			thread.start();
		}
		if (status == Status.LOADING) {
			thread.interrupt();
			thread = new LoadingThread();
			thread.start();

		}
		if (status == Status.RUNNING) {

			thread.interrupt();
			thread = new GameDisPatchThread();
			thread.start();

		}
		if (status == Status.OVER) {
			thread.interrupt();
			thread = new GameOverThread();
			thread.start();

		}
	}

	private void checkM() {
		switch (status) {
		case READY:
			m = 1;
			break;
		case RUNNING:
			m = 2;
			break;
		case FALSE:
			m = 3;
			break;
		case OVER:
			m = 4;
			break;
		case SUCCESS:
			m = 5;
			break;
		case LOADING:
			m = 6;
			break;
		}
		for (int i = 1; i <= objects.length - 1; i++)
			objects[i].clear();
	}

	public static Game getGame() {
		return game;
	}

	public Status getStatus() {
		return this.status;
	}

	public void paint(Graphics g) {
		if (status != Status.LOADING)
			bg.paint(g);
		for (int i = 0; i <= objects[m].size() - 1; i++) {
			for (int j = 0; j <= objects[m].size() - 1; j++) {
				Colliders.DowithCollide(objects[m].get(i), objects[m].get(j));
			}
			try {
				if (!objects[m].get(i).dead) {
					objects[m].get(i).paint(g);
				} else
					objects[m].remove(i);
			} catch (Exception e) {

			}
		}

	}

	public void notifyKeyCode(int keyCode) {
		switch (keyCode) {

		case KeyEvent.VK_F:
			if (mill == 0 && GameMain.bombcount >= 1) {
				mill = System.currentTimeMillis();
				new BombBullet(hero.x + 15, hero.y, Direction.U, true);
				Music.run8();
				GameMain.bombcount--;
			}
			if (GameMain.bombcount >= 1 && checkTimeGap(100)) {
				new BombBullet(hero.x + 15, hero.y, Direction.U, true);
				Music.run8();
				mill = System.currentTimeMillis();
				GameMain.bombcount--;
			}
			break;
		case KeyEvent.VK_W:
			if (!hero.d1) {
				hero.d1 = true;
				hero.dir = Direction.U;
			} else {
				if (!hero.d2) {
					hero.d2 = true;
					hero.dir2 = Direction.U;
				}
			}
			break;
		case KeyEvent.VK_S:
			if (!hero.d1) {
				hero.d1 = true;
				hero.dir = Direction.D;
			} else {
				if (!hero.d2) {
					hero.d2 = true;
					hero.dir2 = Direction.D;
				}
			}
			break;
		case KeyEvent.VK_A:
			if (!hero.d1) {
				hero.d1 = true;
				hero.dir = Direction.L;
			} else {
				if (!hero.d2) {
					hero.d2 = true;
					hero.dir2 = Direction.L;
				}
			}
			break;
		case KeyEvent.VK_D:
			if (!hero.d1) {
				hero.d1 = true;
				hero.dir = Direction.R;
			} else {
				if (!hero.d2) {
					hero.d2 = true;
					hero.dir2 = Direction.R;
				}
			}
			break;
		case KeyEvent.VK_SPACE:
			hitB = true;
			break;
		}
		hero.move();
		if (hitB) {
			hero.hit();
		}

	}

	public void notifyKeyCode2(int keyCode) {
		switch (keyCode) {
		case KeyEvent.VK_W:
			if (hero.dir == Direction.U)
				hero.d1 = false;
			if (hero.dir2 == Direction.U)
				hero.d2 = false;
			break;
		case KeyEvent.VK_S:
			if (hero.dir == Direction.D)
				hero.d1 = false;
			if (hero.dir2 == Direction.D)
				hero.d2 = false;
			break;
		case KeyEvent.VK_A:
			if (hero.dir == Direction.L)
				hero.d1 = false;
			if (hero.dir2 == Direction.L)
				hero.d2 = false;
			left = false;
			break;
		case KeyEvent.VK_D:
			if (hero.dir == Direction.R)
				hero.d1 = false;
			if (hero.dir2 == Direction.R)
				hero.d2 = false;
			break;
		case KeyEvent.VK_SPACE:
			hitB = false;
			break;

		}

	}

	public static boolean checkTimeGap(int gap) {
		boolean timeGap = false;
		if (Math.abs(mill - System.currentTimeMillis()) > gap) {
			timeGap = true;
		}
		mill = System.currentTimeMillis();
		return timeGap;
	}

	public void notifyKeyCode3(char keyChar) {

	}
}

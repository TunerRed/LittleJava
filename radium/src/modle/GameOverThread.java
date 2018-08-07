package modle;

import StartPanel.OvertPanel1;

public class GameOverThread extends Thread {
	private static OvertPanel1 overP=null;
	public GameOverThread() {
	   
	}
	// 游戏物体的开始界面的管理
	public void run() {
		if (Game.getGame().getStatus() == Status.OVER) {
			overP=new OvertPanel1();
		}
		
	}

}

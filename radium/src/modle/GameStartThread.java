package modle;

import StartPanel.StartPanel1;

public class GameStartThread extends Thread {
	private static StartPanel1 startP=null;
	public GameStartThread() {
	   
	}
	// 游戏物体的开始界面的管理
	public void run() {
		if (Game.getGame().getStatus() == Status.READY) {
			startP=new StartPanel1();
		}
		
	}

}

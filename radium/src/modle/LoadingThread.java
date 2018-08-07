package modle;

import StartPanel.StartPanel2;


public class LoadingThread extends Thread {
	private static StartPanel2 startP=null;

	public LoadingThread() {
	}

	// 游戏物体的开始界面的管理
	public void run() {
	
		if (Game.getGame().getStatus() == Status.LOADING) {
			startP=new StartPanel2();
		
		}
	}

}

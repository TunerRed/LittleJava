package modle;

import StartPanel.StartPanel1;

public class GameStartThread extends Thread {
	private static StartPanel1 startP=null;
	public GameStartThread() {
	   
	}
	// ��Ϸ����Ŀ�ʼ����Ĺ���
	public void run() {
		if (Game.getGame().getStatus() == Status.READY) {
			startP=new StartPanel1();
		}
		
	}

}

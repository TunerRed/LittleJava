package modle;

import StartPanel.OvertPanel1;

public class GameOverThread extends Thread {
	private static OvertPanel1 overP=null;
	public GameOverThread() {
	   
	}
	// ��Ϸ����Ŀ�ʼ����Ĺ���
	public void run() {
		if (Game.getGame().getStatus() == Status.OVER) {
			overP=new OvertPanel1();
		}
		
	}

}

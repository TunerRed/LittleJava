package modle;

import StartPanel.StartPanel2;


public class LoadingThread extends Thread {
	private static StartPanel2 startP=null;

	public LoadingThread() {
	}

	// ��Ϸ����Ŀ�ʼ����Ĺ���
	public void run() {
	
		if (Game.getGame().getStatus() == Status.LOADING) {
			startP=new StartPanel2();
		
		}
	}

}

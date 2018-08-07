package modle;

import java.io.IOException;
import java.util.Properties;

import GameObject.Hero;

public class GameDisPatchThread extends Thread {
	private static Properties proper;
	private  int count = 0;
	public GameDisPatchThread() {
		proper = new Properties();
		try {
			proper.load(Hero.class.getClassLoader().getResourceAsStream(
					"config\\dispatch_object.properties"));
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
    //游戏物体的派发要要在游戏状态在运行的时候进行
	public void run() {
		while (Game.getGame().getStatus()==Status.RUNNING) {
			System.out.println(count+"count");
			this.GetObject();
			try {
				sleep(1000);
				count++;
			} catch (InterruptedException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}
	}
	private void GetObject() {
		
		String str = proper.getProperty("S" + count);
		if (null != str) {
			String tempstr = str.split("_")[0];
			int tempcount = Integer.parseInt(str.split("_")[1]);
			
			try {
				for (int i = 1; i <= tempcount; i++)
					Class.forName(tempstr).newInstance();
				
			} catch (InstantiationException | IllegalAccessException
					| ClassNotFoundException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}

	}

}

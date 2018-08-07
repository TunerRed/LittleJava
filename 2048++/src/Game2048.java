import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Game2048 {
	private Image background;
	private GameMove array;
	
	/**
	 * ��ȡ����ͼƬ
	 */
	public Game2048(){
		array = new GameMove();
		try {
			background = ImageIO.read(new File("bgmain.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}//��ȡ�ļ��׳��쳣
	}
	/**����ͼƬλ��
	 * 
	 */
	public void paint(Graphics g) {
		g.drawImage(background, 0,0, null);
		array.paintArray(g);
		g.drawString(""+array.getScore(), 710, 110);
		if(Control.BACKSPACE){
			Game.getInstance().isGame = false;
		}else if(array.over()){
			g.setColor(Color.YELLOW);
			g.drawString("Game Over", 650, 500);
		}
		if(Control.SPACE){
			array.sort();
		}
	}
	
}

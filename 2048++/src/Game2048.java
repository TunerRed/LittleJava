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
	 * 读取背景图片
	 */
	public Game2048(){
		array = new GameMove();
		try {
			background = ImageIO.read(new File("bgmain.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}//读取文件抛出异常
	}
	/**设置图片位置
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

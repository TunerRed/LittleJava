import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Start {
	private Image start,pointer;
	private Image[] span = new Image[9];
	private int current = 0,count = 0;
	public Start(){
		try {
			start = ImageIO.read(new File("bginitial.png"));
			pointer = ImageIO.read(new File("arrow.png"));
			for(int i=0; i < span.length ; i++){
				span[i] = ImageIO.read(new File("span/xz"+(i+1)+".png"));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	private void keyboard(){
		if(Control.DOWN && current < 2){
			current++;
		}
		else if(Control.UP && current > 0){
			current--;
		}
		else if(Control.ENTER && current == 0){
			Game.getInstance().startGame();
		}
		else if(Control.ENTER && current == 2){
			System.exit(0);
		}
	}
	private void draw(Graphics g){
		g.drawImage(start, 0, 0, null);
		g.drawImage(span[count++], -200, -200, null);
		if(count == span.length){
			count = 0;
		}
		g.drawImage(pointer, 405+60*current, 336+63*current, null);
	}
	/**
	 * 外部调用此方法。
	 * 先响应键盘后绘图。
	 * */
	public void paint(Graphics g) {
		keyboard();
		draw(g);
	}                    
}

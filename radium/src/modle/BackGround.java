package modle;

import java.awt.Graphics;
import java.awt.Image;

import javax.imageio.ImageIO;

import radium.GameMain;

public class BackGround {
	private Image img;
	private int y=0;
	public BackGround(){
		try{
			img=ImageIO.read(BackGround.class.getClassLoader().getResourceAsStream("background.png"));
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	public void paint(Graphics g){
		if(y>GameMain.HEIGHT)
			y=0;
		y++;
		g.drawImage(img,0,y-GameMain.HEIGHT,GameMain.WIDTH,GameMain.HEIGHT,null);
		g.drawImage(img,0,y,GameMain.WIDTH,GameMain.HEIGHT,null);
	}

}

package GameObject;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

import radium.GameMain;

public class StrategyUp extends AwardObject{
	public static  Image img=null;
	static {
		try {
			img = ImageIO.read(Hero.class.getClassLoader().getResourceAsStream(
					"up1.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public StrategyUp(){
		this.width=38;
		this.height=38;
		Random random=new Random();
		x=random.nextInt(GameMain.CWIDTH-width);
		y=random.nextInt(GameMain.CHEIGHT-height);
	}

	@Override
	public Rectangle Rect() {
		return new Rectangle(x,y+(int)((2/3.0)*height),width,(int)((1/3.0)*height));
	}
	
	protected void draw(Graphics g) {
		g.drawImage(img,x,y,width,height,null);
	}


}

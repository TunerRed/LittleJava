package GameObject;

import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;

import modle.GObject;
import modle.Game;
import radium.GameMain;

public class Bomb extends GObject {
	private static Image img=null;
	static {
		try {
			img = ImageIO.read(Hero.class.getClassLoader().getResourceAsStream(
					"bomb.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

    public Bomb(){
    	x=10;
    	y=GameMain.CHEIGHT-100;
    	width=50;
    	height=65;
    }
	@Override
	protected void draw(Graphics g) {
          g.drawImage(img, x, y, width, height, null);
	}

}

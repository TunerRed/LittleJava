package GameObject;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import modle.GObject;
import radium.GameMain;

public class BombString extends GObject{
	
	public BombString(){
		
		this.x=70;
		this.y=642;
		
	}
	
	protected  void draw(Graphics g) {
		Color oldc=g.getColor();
		g.setColor(Color.BLACK);
		Font oldfont= g.getFont();
		Font font=new Font("ºÚÌå",3,20 );
		g.setFont(font);
		g.drawString("X " +GameMain.bombcount, x, y);
		
	}
	
}

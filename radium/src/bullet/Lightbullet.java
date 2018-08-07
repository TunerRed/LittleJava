package bullet;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.io.IOException;

import javax.imageio.ImageIO;

import modle.Direction;
import GameObject.Hero;

public class Lightbullet extends Bullet {
   private static Image img;
   private static final int WIDTH=10,HEIGHT=-900,SPEED=900;
   static{
	   try {
		img= ImageIO.read(Hero.class.getClassLoader().getResourceAsStream("light.png"));
	} catch (IOException e) {
		e.printStackTrace();
	}
   }
   public void paint(Graphics g) {
		check();
		draw(g);
		move();
		
	}
   public Lightbullet(int x, int y,Direction dir) {
		super(x, y,dir);
		width=WIDTH;
		height=HEIGHT;
		good=false;
		speed=SPEED;
		dir=dir;
		if(!good)
		this.bloodvalue=-50;
		else
			this.bloodvalue=-10;
	}
   public Rectangle Rect(){
	   return new Rectangle(x,y+height,width,-height);
   }

   public Lightbullet(int x, int y,Direction dir,boolean good) {
	   
		super(x, y,dir);
		this.good=good;;
		width=WIDTH;
		height=HEIGHT;
		speed=SPEED;
		dir=dir;
		if(!good)
			this.bloodvalue=-50;
			else
				this.bloodvalue=-10;
	}

	@Override
	protected void draw(Graphics g) {
		
		g.drawImage(img, x, y, width, height, null);
	
	}

	@Override
	protected void move() {
             y-=speed;		
		
	}
   
}

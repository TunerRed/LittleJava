package bullet;

import java.awt.Graphics;
import java.awt.Rectangle;

import modle.Direction;
import modle.GObject;
import radium.GameMain;

public abstract class Bullet extends GObject{
	
	protected  Direction dir;
	public Bullet (int x,int y,Direction dir,boolean good){
		super();
		this.x=x;
		this.y=y;
		this.dir=dir;
		this.good=good;
	}
	@Override
	public Rectangle Rect() {
		return super.Rect();
	}
	public Bullet (int x,int y,Direction dir){
		super();
		this.x=x;
		this.y=y;
		this.dir=dir;
		this.good=true;
	}
	@Override
	protected abstract void draw(Graphics g);
	@Override
	protected void check() {
		if(x<=0||y<=0||x+width>=GameMain.CWIDTH||y+height>=GameMain.CHEIGHT)
			dead=true;
	}
}

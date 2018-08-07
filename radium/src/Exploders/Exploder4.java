package Exploders;

import java.awt.Graphics;

import modle.Game;
import modle.Status;
import GameObject.Exploder;
// hero's exploder
public class Exploder4 extends Exploder {

	public Exploder4(int x,int y) {
		super(4,4, x, y);
		width=40;
		height=50;
	}

	protected void draw(Graphics g) {
		if (count / 6 <= m) {
			
			if (count % 6 == 0) {
				g.drawImage(imges[count / 6 - 1], x, y, width, height, null);

			}
			count++;
		}
		else{
			this.dead=true;
			Game.game.status = Status.OVER;
			Game.game.changeStatus();
	
		}

	}


}

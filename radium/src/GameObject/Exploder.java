package GameObject;

import java.awt.Graphics;
import java.awt.Image;

import javax.imageio.ImageIO;

import modle.GObject;
import EnemyObject.Enemy1;

public abstract class Exploder extends GObject {
	protected static int m;
	protected static int num;
	protected static Image[] imges;
	protected static int MaxCount;
	protected static int count;

	public Exploder(int m, int num, int x, int y) {
		this.m = m;
		this.num = num;
		imges = new Image[m];
		MaxCount = m * 6;
		count = 1;
		this.x=x;
		this.y=y;

		for (int i = 1; i <= m - 1; i++) {
			try {
				imges[i - 1] = ImageIO.read(Enemy1.class.getClassLoader()
						.getResourceAsStream(
								"exploder" + num + "_" + i + ".png"));
			} catch (Exception e) {

				System.out.println("num is" + num);
				System.out.println("m is" + m);
				System.out.println("i is" + i);
				System.out.println(imges.length);
				e.printStackTrace();
			}
		}

	}

	protected void draw(Graphics g) {
		if (count / 6 <= m) {
			
			if (count % 6 == 0) {
				g.drawImage(imges[count / 6 - 1], x, y, width, height, null);

			}
			count++;
		}
		else
			this.dead=true;

	}

}

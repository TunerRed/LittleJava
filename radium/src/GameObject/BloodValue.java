package GameObject;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;

import modle.GObject;

public class BloodValue extends GObject {
	private static Image img = null;
	private int maxvalue;

	static {
		try {
			img = ImageIO.read(Hero.class.getClassLoader().getResourceAsStream(
					"bloodvalue.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public BloodValue(GObject go, int x, int y) {
		this.x = x;
		this.y = y;
		this.maxvalue = go.bloodvalue;
		this.bloodvalue = maxvalue;
		this.width = 631 / 3;
		this.height = 94 / 4;

	}

	@Override
	protected void draw(Graphics g) {
		Color old = g.getColor();
		g.setColor(Color.WHITE);
		g.drawImage(img, x, y, width, height, null);
		g.fillRect((int) ((width * (63.5 / 631))),
				(int) ((height * (11.5 / 94))),
				(int) ((504.0 / 631) * (width - width
						* (bloodvalue / (double) maxvalue))),
				(int) (height * (71.0 / 94)));
		g.setColor(old);
	}

	@Override
	public void AddBloodValue(int value) {
		super.AddBloodValue(value);
		if(bloodvalue<0)
			bloodvalue=0;
	}

}

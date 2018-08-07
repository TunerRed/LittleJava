package GameObject;

import modle.Direction;
import modle.GObject;

public abstract class AwardObject extends GObject{

	@Override
	protected void move(Direction dir) {
			switch (dir) {
			case U:
				y -= speed;
				break;
			case D:
				y += speed;
				break;
			case L:
				x -= speed;
				break;
			case R:
				x += speed;
				break;
			case UL:
				x -= speed;
				y -= speed;
				break;
			case UR:
				x += speed;
				y -= speed;
				break;
			case DL:
				x -= speed;
				y -= speed;
				break;
			case DR:
				x += speed;
				y -= speed;
				break;

			}

	}
	

}

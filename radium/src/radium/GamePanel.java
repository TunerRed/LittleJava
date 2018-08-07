package radium;

import java.awt.Graphics;

import javax.swing.JPanel;

import modle.Game;

public class GamePanel extends JPanel {
	Game game = null;

	public GamePanel(Game game) {
		this.game = game;

	}
	public void paint(Graphics g) {
	game.paint(g);
	}

}

package radium;

import java.awt.EventQueue;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

import modle.Game;
import modle.Status;
import musicThread.Music;

public class GameMain extends JFrame {
	public static JFrame GameMain;
	public static int WIDTH = 900, CWIDTH = 890;
	public static int HEIGHT = 730, CHEIGHT = 700;
	public static int bombcount = 1;
	public static JPanel Jcontenpane;
	// ////////////////////////////////////////////////////plane's modle
	// ////////////////////////////////////////////////////
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GameMain window = new GameMain();
					window.GameMain.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GameMain() {
		initialize();

	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		GameMain = new JFrame();
		GameMain.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (e.getX() >= 300 && e.getX() <= 370 && e.getY() <= 360 && e.getY()>= 300) {
					Music.run1();
					Game.game.status = Status.LOADING;
					Game.game.changeStatus();
				    
				}
				if(e.getX() >= 350 && e.getX() <= 350+75 && e.getY() <= 460 && e.getY()>= 400) {
					System.exit(0);
					
				}
				if(e.getX() >= 170 && e.getX() <= 170+114 && e.getY() <= 575+60 && e.getY()>= 575) {
					System.exit(0);
				}
				if(e.getX() >= 490 && e.getX() <= 490+114 && e.getY() <= 570+60 && e.getY()>= 570) {
					Music.run1();
					Game.game.status = Status.LOADING;
					Game.game.changeStatus();
					
				}

			}
		});
		GameMain.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				Game.getGame().notifyKeyCode(e.getKeyCode());
			//	GameMain.repaint();
			}

			public void keyReleased(KeyEvent e) {
				Game.getGame().notifyKeyCode2(e.getKeyCode()); // notifyKeyCode2这个方法是用来在松开键的时候把Game中的布尔值取消掉
				//GameMain.repaint();

		}
//
//			public void keyTyped(KeyEvent e) {
//				Game.getGame().notifyKeyCode3(e.getKeyChar());
//				GameMain.repaint();
//
//			}

		});

		GameMain.setBounds(300, 0, WIDTH, HEIGHT);
		GameMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GameMain.getContentPane().setLayout(null);
		GameMain.setTitle("C-Dragon");
		GameMain.setContentPane(getJPanal());
		Game.getGame().init();
		new Thread() {
			public void run() {
				while (true) {
					try {
						Thread.sleep(31);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					GameMain.repaint();
				}
			}
		}.start();
		;
	}

	private JPanel getJPanal() {
		Jcontenpane = new GamePanel(Game.getGame());

		return Jcontenpane;
	}

}

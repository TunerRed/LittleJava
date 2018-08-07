import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;

/**继承JPanel并且实现监听器接口
 * 
 */
@SuppressWarnings("serial")
/**同时继承JPanel和实现监听器，更方便，主要是设置游戏面板
 * 
 */
public class GamePanel extends JPanel implements KeyListener{
	
	public GamePanel(){
		this.setPreferredSize(new Dimension(800,600));
		this.setLayout(null);
		this.addKeyListener(this);
		this.setFocusable(true);
		
		/**只要游戏仍在继续，就不断重画
		 * 
		 */
		new Thread(){
			public void run(){
				while(true){
					try {
						Thread.sleep(60);
					} catch (InterruptedException e) {}
					repaint();
				}
			}
		}.start();
	}
	
	/**
	 * 调取静态的Game对象获得应该重画的内容
	 * */
	public void paint(Graphics g){
		super.paint(g);
		Game.getInstance().paint(g);
	}


	/**
	 * 实现键盘监听，改变Control类中相应值为true
	 * */
	@Override
	public void keyPressed(KeyEvent e) {
		switch(e.getKeyCode()){
		case KeyEvent.VK_UP:
			Control.UP = true;
			break;
		case KeyEvent.VK_DOWN:
			Control.DOWN = true;
			break;
		case KeyEvent.VK_LEFT:
			Control.LEFT = true;
			break;
		case KeyEvent.VK_RIGHT:
			Control.RIGHT = true;
			break;
		case KeyEvent.VK_ENTER:
			Control.ENTER = true;
			break;
		case KeyEvent.VK_BACK_SPACE:
			Control.BACKSPACE = true;
			break;
		case KeyEvent.VK_SPACE:
			Control.SPACE = true;
			break;
		default:
			break;
		}
		
	}
	
	/**
	 * 实现键盘监听，改变Control类中相应值为false
	 * */
	@Override
	public void keyReleased(KeyEvent e) {
		switch(e.getKeyCode()){
		case KeyEvent.VK_UP:
			Control.UP = false;
			break;
		case KeyEvent.VK_DOWN:
			Control.DOWN = false;
			break;
		case KeyEvent.VK_LEFT:
			Control.LEFT = false;
			break;
		case KeyEvent.VK_RIGHT:
			Control.RIGHT = false;
			break;
		case KeyEvent.VK_ENTER:
			Control.ENTER = false;
			break;
		case KeyEvent.VK_BACK_SPACE:
			Control.BACKSPACE = false;
			break;
		case KeyEvent.VK_SPACE:
			Control.SPACE = false;
			break;
		default:
			break;
		}
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
	}
}

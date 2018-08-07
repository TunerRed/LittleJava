import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;

/**�̳�JPanel����ʵ�ּ������ӿ�
 * 
 */
@SuppressWarnings("serial")
/**ͬʱ�̳�JPanel��ʵ�ּ������������㣬��Ҫ��������Ϸ���
 * 
 */
public class GamePanel extends JPanel implements KeyListener{
	
	public GamePanel(){
		this.setPreferredSize(new Dimension(800,600));
		this.setLayout(null);
		this.addKeyListener(this);
		this.setFocusable(true);
		
		/**ֻҪ��Ϸ���ڼ������Ͳ����ػ�
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
	 * ��ȡ��̬��Game������Ӧ���ػ�������
	 * */
	public void paint(Graphics g){
		super.paint(g);
		Game.getInstance().paint(g);
	}


	/**
	 * ʵ�ּ��̼������ı�Control������ӦֵΪtrue
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
	 * ʵ�ּ��̼������ı�Control������ӦֵΪfalse
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

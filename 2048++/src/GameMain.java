import javax.swing.JFrame;

public class GameMain extends JFrame {
	//������
	public static void main(String[] arg){
		new GameMain();
	}
	
	/**
	 *  ������Ϸ�Ŀ�ܺ����
	 */
	    public GameMain(){
		this.setTitle("2048");
		/**
		 * �رմ��ڼ���������
		 */
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		/**
		 * ���ô�����ʾλ��Ϊ����
		 */
		this.setLocation(500,200);
		this.getContentPane().add(new GamePanel());
		/**
		 * ��С���ɸ���
		 */
		this.setResizable(false);
		this.pack();
		this.setVisible(true);
	}
}

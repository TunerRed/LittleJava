import javax.swing.JFrame;

public class GameMain extends JFrame {
	//主方法
	public static void main(String[] arg){
		new GameMain();
	}
	
	/**
	 *  设置游戏的框架和面板
	 */
	    public GameMain(){
		this.setTitle("2048");
		/**
		 * 关闭窗口即结束程序
		 */
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		/**
		 * 设置窗口显示位置为中心
		 */
		this.setLocation(500,200);
		this.getContentPane().add(new GamePanel());
		/**
		 * 大小不可更改
		 */
		this.setResizable(false);
		this.pack();
		this.setVisible(true);
	}
}

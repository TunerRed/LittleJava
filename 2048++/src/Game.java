import java.awt.Graphics;

/**
 * 其他类在使用这个类时
 * 全部都是在使用getInstance()方法获得静态的Game对象
 * 这样做可以保证所有的其他对象在试图改变整个游戏较大状态变动时比较方便
 * 而且它们所操作的也必定是同一个对象
 * 避免了操作不同对象出现BUG的问题
 * */

public class Game {
	private Start start ;
	private Game2048 game2048;
	public boolean isGame;
	private static Game game = new Game();
/**
 *Game的构造方法，分别有开始游戏界面，主游戏界面，是否进入游戏界面
 */
	public Game(){

		start = new Start();
		game2048  = new Game2048();
		isGame = false;
	}
	/**
	 * 获得静态变量
	 */
	public static Game getInstance(){
		return game;
	}
	/**
	 * 开始游戏方法
	 */
	public void startGame(){
		game2048 = new Game2048();
		this.isGame = true;
	}
	/**
	 * 用于画界面，如果读取到开始游戏，则重画游戏主界面，若果不是则重画初始界面
	 */
	public void paint(Graphics g){
		if(isGame){
			game2048.paint(g);
		}
		else{
			start.paint(g);
		}
	}
}

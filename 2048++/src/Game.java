import java.awt.Graphics;

/**
 * ��������ʹ�������ʱ
 * ȫ��������ʹ��getInstance()������þ�̬��Game����
 * ���������Ա�֤���е�������������ͼ�ı�������Ϸ�ϴ�״̬�䶯ʱ�ȽϷ���
 * ����������������Ҳ�ض���ͬһ������
 * �����˲�����ͬ�������BUG������
 * */

public class Game {
	private Start start ;
	private Game2048 game2048;
	public boolean isGame;
	private static Game game = new Game();
/**
 *Game�Ĺ��췽�����ֱ��п�ʼ��Ϸ���棬����Ϸ���棬�Ƿ������Ϸ����
 */
	public Game(){

		start = new Start();
		game2048  = new Game2048();
		isGame = false;
	}
	/**
	 * ��þ�̬����
	 */
	public static Game getInstance(){
		return game;
	}
	/**
	 * ��ʼ��Ϸ����
	 */
	public void startGame(){
		game2048 = new Game2048();
		this.isGame = true;
	}
	/**
	 * ���ڻ����棬�����ȡ����ʼ��Ϸ�����ػ���Ϸ�����棬�����������ػ���ʼ����
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

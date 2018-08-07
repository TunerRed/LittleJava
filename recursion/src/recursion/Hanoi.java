package recursion;

import javax.swing.JOptionPane;
/*
 * time:2012.12.2
 * author:王金宇
 * description:
 */
public class Hanoi {
	private final static String from = "盘子B";
	private final static String to = "盘子C";
	private final static String mid = "盘子A";

	public static void main(String[] args) {
		String input = JOptionPane.showInputDialog("请输入你要移动的盘子数");
		int num = Integer.parseInt(input);
		Hanoi.move(num, from, mid, to);
	}
	private static void move(int num, String from2, String mid2, String to2) {
		if (num == 1) {
			System.out.println("移动盘子1 从" + from2 + "到" + to2);
		} else {
			move(num - 1, from2, to2, mid2);
			System.out.println("移动盘子" + num + " 从" + from2 + "到" + to2);
//			这样也可以，只是略蛋疼
//			递归策略：先写num==1时，else中只需要写出num==2时的情况，基本就不会出错
//			move(num - 1, mid2, to2, from2);
//			move(num - 1, from2, mid2, to2);
			move(num-1,mid2,from2,to2);
		}

	}

}

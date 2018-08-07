package recursion;

import javax.swing.JOptionPane;
/*
 * time:2012.12.2
 * author:������
 * description:
 */
public class Hanoi {
	private final static String from = "����B";
	private final static String to = "����C";
	private final static String mid = "����A";

	public static void main(String[] args) {
		String input = JOptionPane.showInputDialog("��������Ҫ�ƶ���������");
		int num = Integer.parseInt(input);
		Hanoi.move(num, from, mid, to);
	}
	private static void move(int num, String from2, String mid2, String to2) {
		if (num == 1) {
			System.out.println("�ƶ�����1 ��" + from2 + "��" + to2);
		} else {
			move(num - 1, from2, to2, mid2);
			System.out.println("�ƶ�����" + num + " ��" + from2 + "��" + to2);
//			����Ҳ���ԣ�ֻ���Ե���
//			�ݹ���ԣ���дnum==1ʱ��else��ֻ��Ҫд��num==2ʱ������������Ͳ������
//			move(num - 1, mid2, to2, from2);
//			move(num - 1, from2, mid2, to2);
			move(num-1,mid2,from2,to2);
		}

	}

}

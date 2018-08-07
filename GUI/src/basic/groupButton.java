package basic;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class groupButton extends JPanel{
	private JLabel label = new JLabel();
	private JPanel panel = new JPanel();
	private String s1,s2,s3;
	private JRadioButton button1,button2,button3;
	private ButtonGroup group = new ButtonGroup();
	public groupButton(){
		s1="���Ǻܳ���s1";
		s2="���ǲ��̵�s2";
		s3="����s3";
		button1 = new JRadioButton("����s1");
		button2 = new JRadioButton("����s2");
		button3 = new JRadioButton("����s3");
		group.add(button1);
		group.add(button2);
		group.add(button3);
		button1.addActionListener(new myListener());
		button2.addActionListener(new myListener());
		button3.addActionListener(new myListener());
		label.setText("���ǳ�ֵ");
		label.setFont(new Font("վ��߶˺��޶���1.13",2,20));
		panel.add(label);
		add(panel);
		add(button1);
		add(button2);
		add(button3);
		panel.setPreferredSize(new Dimension(300,60));
		setPreferredSize(new Dimension(300,180));
	}
	
	public JLabel getMyLabel(){
		return label;
	}
	
	
	private class myListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			if(e.getSource()==button1)
				label.setText(s1);
			if(e.getSource()==button2)
				label.setText(s2);
			if(e.getSource()==button3)
				label.setText(s3);
		}
	}
}

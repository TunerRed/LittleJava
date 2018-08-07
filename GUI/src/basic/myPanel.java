package basic;

import java.awt.Button;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class myPanel extends JPanel{
	private JPanel buttonPanel = new JPanel();
	private JButton left = new JButton("left");
	private JButton right = new JButton("right");
	private JLabel label = new JLabel("push a button");
	
	public myPanel(){
		Button b;
		setPreferredSize(new Dimension(200,80));
		buttonPanel.setPreferredSize(new Dimension(200,40));
		left.addActionListener(new myListener());
		right.addActionListener(new myListener());
		buttonPanel.add(left);
		buttonPanel.add(right);
		
		left.setToolTipText("ÕâÊÇÖú¼Ç·û");
		right.setEnabled(false);
		
		add(label);
		add(buttonPanel);
	}
	
	private class myListener implements ActionListener{
		public void actionPerformed(ActionEvent a){
			if(a.getSource()==left)
				label.setText("LEFT");
			else
				label.setText("RIGHT");
		}
	}
}

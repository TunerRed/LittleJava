package basic;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

class aCheckBox extends JPanel{
	private JLabel label = new JLabel("A Font Style Example");
	private JCheckBox bold,italic;
	private JPanel panel = new JPanel();
	public aCheckBox(){
		label.setFont(new Font("ËÎÌו",0,10));
		bold = new JCheckBox("BOLD");
		italic = new JCheckBox("ITALIC");
		bold.addItemListener(new myListener());
		italic.addItemListener(new myListener());
		panel.setPreferredSize(new Dimension(200,40));
		setPreferredSize(new Dimension(200,80));
		panel.add(bold);
		panel.add(italic);
		add(label);
		add(panel );
	}
	
	private class myListener implements ItemListener{
		public void itemStateChanged(ItemEvent i){
			int style=0;
			if(i.getSource()==bold)
				System.out.println("good job");
			if(bold.isSelected())
				style=Font.BOLD;
			if(italic.isSelected())
				style=Font.ITALIC;
			label.setFont(new Font("ËÎÌו",style,10));
		}
	}
}
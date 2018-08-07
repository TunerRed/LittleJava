package basic;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JColorChooser;
import javax.swing.JPanel;

public class ColorChoose extends JPanel{
	JPanel colorPanel = new JPanel();
	public ColorChoose(){
		colorPanel.setPreferredSize(new Dimension(200,300));
		colorPanel.setBackground(JColorChooser.showDialog(this, "Ñ¡ÔñÑÕÉ«", Color.BLACK));
		add(colorPanel);
	}
}

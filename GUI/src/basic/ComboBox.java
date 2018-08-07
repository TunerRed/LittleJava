package basic;

import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JComboBox;
import javax.swing.JPanel;

public class ComboBox extends JPanel{
	String [] s = {"a","b","c"};
	JComboBox<String> line = new JComboBox<String>(s);
	public ComboBox(){
		line.setAlignmentY(Component.CENTER_ALIGNMENT);
		add(line);
		setPreferredSize(new Dimension(100,200));
	}
}
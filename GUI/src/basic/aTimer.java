package basic;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.Timer;

class aTimer extends JPanel{
	Timer t;
	int i = 1;
	public aTimer(){
		t = new Timer(500,new linelisten());
		setBackground(Color.yellow);
		setPreferredSize(new Dimension(300,300));
		t.start();
		t.stop();
		t.start();
		t.stop();
		t.start();
		t.stop();
		t.start();
		t.stop();
		t.start();
		t.stop();
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.drawLine(100,i*50,280,i*50);
	}
	
	private class linelisten implements ActionListener{
		public void actionPerformed(ActionEvent e){
			i++;
			repaint();
		}
	}
}

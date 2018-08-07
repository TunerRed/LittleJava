package basic;
import javax.swing.*;

public class GUI{
	public static void main(String[] args){
		JFrame frame=new JFrame("my jframe");
		
		JPanel panel=new FileChoose();
		
		frame.add(new ComboBox());
		frame.add(panel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setLocation(200,200);
		frame.setVisible(true);
		
		//JOptionPane option = new JOptionPane();
		//String str = option.showInputDialog(frame,"balabala");
		//option.showConfirmDialog(frame,str);
		//option.showMessageDialog(frame,str);
	}
} 


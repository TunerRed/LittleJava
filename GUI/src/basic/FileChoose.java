package basic;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.*;
public class FileChoose extends JPanel{
	JFileChooser choose = new JFileChooser();
	JTextArea area = new JTextArea(20,30);
	String str = "";
	public FileChoose(){
		int myFile = choose.showOpenDialog(null);
		add(area);
		if(myFile!=JFileChooser.APPROVE_OPTION)
			area.setText("未选中文件？");
		else {
			File file = choose.getSelectedFile();
			try {
				Scanner scan = new Scanner(file);
				while (scan.hasNext())
					str+=scan.nextLine()+"\n";
				scan.close();
				area.setText(str);
				
			} catch (FileNotFoundException e) {}
		}
	}
}

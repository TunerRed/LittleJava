import java.awt.Checkbox;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Holiday extends JPanel implements MouseListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<String> items;
	private JButton submit,analyse;
	private Checkbox item[];
	Datas data;
	File file;
	private int n = 0,max_width = 0;
	public  Holiday(){
		super();
		
		try {
			file = new File("./Log.txt");
			if(!file.exists()){
				file.createNewFile();
				items = new ArrayList<String>();
				{
					items.add("仰卧起坐");
					items.add("英语背作文");
					items.add("程序模拟登录提交");
					items.add("Unity官方示例");
					items.add("绯想天则神AI，体术");
					items.add("女装学园");
					items.add("崩坏：圣女碎片");
					items.add("崩坏：游侠碎片");
					items.add("崩坏：强袭碎片");
					items.add("崩坏：山吹碎片");
					items.add("崩坏：绯红碎片");
					items.add("崩坏：指挥中心");
					items.add("QQ飞车");
					items.add("DB2");
					items.add("数据结构实验");
					items.add("电影");
					items.add("小说");
				}
				n = items.size();
				data = new Datas(items,n);
			}
			else
			{
				ObjectInputStream in = new ObjectInputStream(new FileInputStream(file));
				data = (Datas)(in.readObject());
				items = data.getItemList();
				n = items.size();
				in.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		setLayout(new GridLayout(n+2, 1));
		item = new Checkbox[n];
		for(int i = 0; i < n; i++)
		{
			if(items.get(i).length() > max_width)
				max_width = items.get(i).length();
			item[i] = new Checkbox(items.get(i));
			add(item[i]);
		}
		
		
		submit = new JButton("提交");
		submit.addMouseListener(this);
		add(submit);
		
		analyse = new JButton("分析");
		analyse.addMouseListener(this);
		add(analyse);
		
	}
	
	public int get_n_height(){
		return n;
	}
	
	public int get_n_width(){
		return max_width > 10? max_width:10;
	}

	public static void main(String[] args) {
		JFrame f = new JFrame();
		f.setTitle("假期计划完成表");
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Holiday h = new Holiday();
		f.add(h);
		f.setSize(20*(h.get_n_width()+3), 30*(h.get_n_height()+2));
		f.setResizable(false);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getSource() == submit){
			try {
				
				String s = "";
				for(int i = 0; i < n; i++)
					if(item[i].getState())
						s+=1;
					else
						s+=0;
					
				data.add(s);
				
				ObjectOutputStream write = new ObjectOutputStream(new FileOutputStream(file));
				write.writeObject(data);
				write.close();
				
			} catch (IOException e1) {
				e1.printStackTrace();
				System.exit(-1);
			}
		}
		else if(e.getSource() == analyse){
			JOptionPane.showMessageDialog(this, data.score(),"假期评测",JOptionPane.INFORMATION_MESSAGE);
		}
	}
	@Override
	public void mousePressed(MouseEvent e) {}
	@Override
	public void mouseReleased(MouseEvent e) {}
	@Override
	public void mouseEntered(MouseEvent e) {}
	@Override
	public void mouseExited(MouseEvent e) {}

}

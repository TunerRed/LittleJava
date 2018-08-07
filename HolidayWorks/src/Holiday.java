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
					items.add("��������");
					items.add("Ӣ�ﱳ����");
					items.add("����ģ���¼�ύ");
					items.add("Unity�ٷ�ʾ��");
					items.add("���������AI������");
					items.add("Ůװѧ԰");
					items.add("������ʥŮ��Ƭ");
					items.add("������������Ƭ");
					items.add("������ǿϮ��Ƭ");
					items.add("������ɽ����Ƭ");
					items.add("������糺���Ƭ");
					items.add("������ָ������");
					items.add("QQ�ɳ�");
					items.add("DB2");
					items.add("���ݽṹʵ��");
					items.add("��Ӱ");
					items.add("С˵");
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
		
		
		submit = new JButton("�ύ");
		submit.addMouseListener(this);
		add(submit);
		
		analyse = new JButton("����");
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
		f.setTitle("���ڼƻ���ɱ�");
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
			JOptionPane.showMessageDialog(this, data.score(),"��������",JOptionPane.INFORMATION_MESSAGE);
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

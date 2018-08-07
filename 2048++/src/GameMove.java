import java.applet.AudioClip;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import javax.imageio.ImageIO;

public class GameMove{
	
	private static AudioClip yes,no;
	static {
		try {
			yes = java.applet.Applet.newAudioClip(GameMove.class.getClassLoader().getResource("true.wav"));
			no = java.applet.Applet.newAudioClip(GameMove.class.getClassLoader().getResource("false.wav"));
		} catch (Exception ef) {
		}
	}
	
	final private int size=4;
	private Random ran=new Random();
	/**
	 * moveIn判断是否可以在合并数字前移动数字的代码块中某个数字想要移动的方向有没有0
	 * move判断是否可以在合并数字前移动数字，记录合成前有没有移动过
	 * flag判断是否进行了数字的合成
	 * */
	private boolean moveIn=false,flag=false,move = false;
	private Number data[][]=new Number[size][size];
	private static int imgBounds;
	private int score;
	//数字图片
	private static Image numbers[] = new Image[12];
	static{
		try {
			numbers[0] = null;
			for(int i = 1 ; i < numbers.length ; i++){
				numbers[i] = ImageIO.read(new File("num/"+(int)Math.pow(2, i)+".png"));
			}
			imgBounds = numbers[1].getWidth(null);
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
		
	public GameMove(){
		for(int i = 0 ; i < data.length ; i++)
			for(int j = 0 ; j < data[i].length ; j++)
				data[i][j] = new Number();
		data[2][1].update();
		data[1][3].update();
	}
	
	public int getScore(){
		return score;
	}
	public Number[][] getNumbers(){
		return data;
	}
		
	public void paintArray(Graphics g){
		if(Control.UP && checkTimeGap(100)){
			dataUp();
		}else if(Control.DOWN && checkTimeGap(100)){
			dataDown();
		}else if(Control.LEFT && checkTimeGap(100)){
			dataLeft();
		}else if(Control.RIGHT && checkTimeGap(100)){
			dataRight();
		}
		for(int i = 0 ; i < getNumbers().length ; i++){
			for(int j = 0 ; j < getNumbers()[i].length ; j++){
				for(int id = 0 ; id < numbers.length ; id++)
					if(getNumbers()[i][j].getID() == id){
						g.drawImage(numbers[id], j*(imgBounds+4), i*(imgBounds+4), null);
						break;
					}
			}
			
		}		
	}
	
	public void p(){
		for(int i = 0 ; i < getNumbers().length ; i++){
			for(int j = 0 ; j < getNumbers()[i].length ; j++){
				System.out.printf(getNumbers()[i][j].getID()+"\t");
			}
			System.out.println();
		}
		System.out.println();
	}
		
		private void random(){
		    int i,j;
			boolean move=false;
			for(i=0;i<size;i++)
			    for(j=0;j<size;j++)
				    if(data[i][j].getID()==0){
					    move=true;
						i=size;
						break;
					}
				if(move){
			        do{
			            i=ran.nextInt(size);
			            j=ran.nextInt(size);
			        }while(data[i][j].getID()!=0);
		            data[i][j].update();;
				}
		}
		
		public boolean over(){
		    //检查是不是存在空的
			for(int i=0;i<size;i++)
			    for(int j=0;j<size;j++)
				    if(data[i][j].getID()==0)
					    return false;
			
	        //检查是不是存在可以合并的对象(上、左分别检查一次，下、右与上、左相同)		
			for(int i=0;i<data.length;i++)
			    for(int j=0;j<data.length-1;j++)
				    if(data[i][j].equals(data[i][j+1]))
						return false;
			for(int i=0;i<data.length;i++)
			    for(int j=0;j<data.length-1;j++)
				    if(data[j][i].equals(data[j+1][i]))
					    return false;
			return true;
		}
		
		private void dataLeft(){
				
		    //检查是不是可以进行移动0
			for(int i=0;i<data.length;i++){
			    for(int j=0;j<data.length;j++){
				    if(data[i][j].getID()==0)
					    moveIn=true;
					if(moveIn&&data[i][j].getID()!=0){
						move=true;
					}   
				}
				if(move)
				    break;
				moveIn=false;
			}
			//进行移动0
			if(move)
		        for(int i=0;i<data.length;i++)
			        for(int m=0,j=0;j<data.length;j++)
				        if(data[i][j].getID()!=0){
					        data[i][m].setID(data[i][j].getID());
						    if(m!=j)
						        data[i][j].clear();
						    m++;
					    }
			//数值合并准备0
			for(int i=0;i<data.length;i++)
			    for(int j=0;j<data.length-1;j++){
				    if(data[i][j].getID()!=0&&data[i][j].equals(data[i][j+1])){
					    data[i][j].update();
					    score+=Math.pow(2, data[i][j].getID());
						data[i][j+1].clear();
						flag=true;
					}
				}	
			//进行合并之后的移动0(如果进行过合并的话0)
			if(flag){
				yes.play();
				for(int i=0;i<data.length;i++){
				    for(int m=0,j=0;j<data.length;j++){
					    if(data[i][j].getID()!=0){
					    	data[i][m].setID(data[i][j].getID());
							if(m!=j)
							    data[i][j].clear();
							m++;
						}
					}
				}				
			}else if(move){
				no.play();
			}
			if(move || flag){
				//随机寻找一个空地点生成数字2
				random();
			}
			flag = false;
			move = false;
			moveIn = false;
		}
		
		private void dataRight(){
		    
			
			//检查是否可以移动
			for(int i=data.length-1;i>=0;i--){
			    for(int j=data.length-1;j>=0;j--){
				    if(data[i][j].getID()==0)
					    moveIn=true;
					if(moveIn&&data[i][j].getID()!=0)
					    move=true;
				}
				if(move)
				    break;
				moveIn=false;
			}
			
			//开始移动
			if(move)
		    for(int i=data.length-1;i>=0;i--)
			    for(int m=data.length-1,j=data.length-1;j>=0;j--)
				    if(data[i][j].getID()!=0){
				    	data[i][m].setID(data[i][j].getID());
						if(m!=j)
						    data[i][j].clear();
						m--;
					}
			//数值合并准备
			for(int i=data.length-1;i>=0;i--)
			    for(int j=data.length-1;j>0;j--){
				    if(data[i][j].getID()!=0&&data[i][j].equals(data[i][j-1])){
					    data[i][j].update();
					    score+=Math.pow(2, data[i][j].getID());
						data[i][j-1].clear();
						flag=true;
					}
				}
				
			//进行合并之后的移动(如果进行过合并的话)
			if(flag){
				yes.play();
				for(int i=data.length-1;i>=0;i--){
				    for(int m=data.length-1,j=data.length-1;j>=0;j--){
					    if(data[i][j].getID()!=0){
						    data[i][m].setID(data[i][j].getID());
							if(m!=j)
							    data[i][j].clear();
							m--;
						}
					}
				}
			}else if(move){
				no.play();
			}
			if(move || flag){
				//随机寻找一个空地点生成数字2
				random();
			}
			flag = false;
			move = false;
			moveIn = false;
		}
		
		private void dataUp(){
		    boolean moveIn=false,move=false;
			//检查是否可以移动
			for(int i=0;i<data.length;i++){
			    for(int j=0;j<data.length;j++){
				    if(data[j][i].getID()==0)
					    moveIn=true;
					if(moveIn&&data[j][i].getID()!=0)
					    move=true;
				}
				if(move)
				    break;
				moveIn=false;
			}
			
			//开始移动
			if(move)
		    for(int i=0;i<data.length;i++)
			    for(int m=0,j=0;j<data.length;j++)
				    if(data[j][i].getID()!=0){
					    data[m][i].setID(data[j][i].getID());
						if(m!=j)
						    data[j][i].clear();;
						m++;
					}
			//数值合并准备
			for(int i=0;i<data.length;i++)
			    for(int j=0;j<data.length-1;j++){
				    if(data[j][i].getID()!=0&&data[j][i].equals(data[j+1][i])){
					    data[j][i].update();
					    score+=Math.pow(2, data[j][i].getID());
						data[j+1][i].clear();
						flag=true;
					}
				}
			
			//进行合并之后的移动(如果进行过合并的话)
			if(flag){
				yes.play();
				for(int i=0;i<data.length;i++)
				    for(int m=0,j=0;j<data.length;j++)
					    if(data[j][i].getID()!=0){
						    data[m][i].setID(data[j][i].getID());
							if(m!=j)
							    data[j][i].clear();
							m++;
						}
			}else if(move){
				no.play();
			}
			if(move || flag){
				//随机寻找一个空地点生成数字2
				random();
			}
			flag = false;
			move = false;
			moveIn = false;
		}
		
		private void dataDown(){
		    boolean moveIn=false,move=false;
			//检查是否可以移动
			for(int i=data.length-1;i>=0;i--){
			    for(int j=data.length-1;j>=0;j--){
				    if(data[j][i].getID()==0)
					    moveIn=true;
					if(moveIn&&data[j][i].getID()!=0)
					    move=true;
				}
				if(move)
				    break;
				moveIn=false;
			}
			
			//开始移动
			if(move)
		    for(int i=data.length-1;i>=0;i--)
			    for(int m=data.length-1,j=data.length-1;j>=0;j--)
				    if(data[j][i].getID()!=0){
					    data[m][i].setID(data[j][i].getID());
						if(m!=j)
						    data[j][i].clear();
						m--;
					}		
			//数值合并准备
			for(int i=data.length-1;i>=0;i--)
			    for(int j=data.length-1;j>0;j--){
				    if(data[j][i].getID()!=0&&data[j][i].equals(data[j-1][i])){
					    data[j][i].update();
					    score+=Math.pow(2, data[j][i].getID());
						data[j-1][i].clear();
						flag=true;
					}
				}		
					
			//进行合并之后的移动(如果进行过合并的话)
			if(flag){
				yes.play();
				for(int i=data.length-1;i>=0;i--)
				    for(int m=data.length-1,j=data.length-1;j>=0;j--)
					    if(data[j][i].getID()!=0){
						    data[m][i].setID(data[j][i].getID());
							if(m!=j)
							    data[j][i].clear();;
							m--;
						}
			}else if(move){
				no.play();
			}
			if(move || flag){
				//随机寻找一个空地点生成数字2
				random();
			}
			flag = false;
			move = false;
			moveIn = false;
		}	
	
		public void sort(){
			ArrayList<Integer> IDs = new ArrayList<Integer>();
			for(int i = 0 ; i < data.length ; i++)
				for(int j = 0 ; j < data.length ; j++)
					IDs.add(data[i][j].getID());
			IDs.sort(null);
			for(int i = 0 ; i < data.length ; i++){
				for(int j = 0 ; j < data[i].length ; j++){
					data[i][j].setID(IDs.get(i*data.length+j));
				}
			}
		}
		
		private long mill = System.currentTimeMillis();
		private boolean checkTimeGap(int gap) {
			boolean timeGap = false;
			if (Math.abs(mill - System.currentTimeMillis()) > gap) {
				timeGap = true;
			}
			mill = System.currentTimeMillis();
			return timeGap;
		}
}

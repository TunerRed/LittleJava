package myThread;
public class test {
	public static void main(String[] args) throws InterruptedException{
		int a=0;
		Thread1 t1=new Thread1();
		Thread1 t2=new Thread1();
		Thread1 t3=new Thread1();
		t1.start();
		t2.start();
		t1.sleep(5000);
		for(int i=0;i<10000;i++)
			for(int j=0;j<100;j++)
				a++;
		
		t3.start();
	}
}

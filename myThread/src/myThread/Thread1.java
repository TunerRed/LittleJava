package myThread;

public class Thread1 extends Thread{
	public Thread1(){
		super();
	}
	public void run(){
		int a=0;
		System.out.println("I'm a thread");
		for(int i=0;i<10000;i++)
			for(int j=0;j<100;j++)
				a++;
		for(int i=0;i<10;i++){
			for(int j=0;j<=i;j++){
				System.out.print("*");
			}
			System.out.println();
		}
	}
}

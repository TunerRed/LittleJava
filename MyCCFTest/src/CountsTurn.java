import java.util.Scanner;

public class CountsTurn {

	public static void main(String[] args) {
		int a[] = new int[1000];
		int total = 0,turns = 0;
		boolean isUping = false;
		
		Scanner scan = new Scanner(System.in);
		
		total = scan.nextInt();
		
		for(int i = 0 ; i < total ; i++){
			a[i] = scan.nextInt();
		}
		
		if(a[1] - a[0] > 0 )
			isUping = true;
		
		for(int i = 2 ; i < total ; i++){
			if(isUping && a[i] - a[i-1] < 0){
				isUping = false;
				turns++;
			}
			else if(!isUping && a[i] - a[i-1] > 0){
				isUping = true;
				turns++;
			}
		}
		
		System.out.println(turns);
		
		scan.close();
		
	}

}

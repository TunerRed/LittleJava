import java.util.Scanner;

public class Tetris {

	public static void main(String[] args) {
		int a[][] = new int[15][10];
		int b[][] = new int[4][4];
		int c = 0, step = 0;
		Scanner scan = new Scanner(System.in);

		for (int i = 0; i < a.length; i++)
			for (int j = 0; j < a[i].length; j++)
				a[i][j] = scan.nextInt();
		for (int i = 0; i < b.length; i++)
			for (int j = 0; j < b[i].length; j++)
				b[i][j] = scan.nextInt();
		c = scan.nextInt();

		step = canGoSteps(a, b, c);

		for (int i = 0; i < 4; i++) {
			int j;
			for(j = b.length - 1; j >= 0 ; j--){
				if(b[j][i] != 0)
					a[j+step][i+c-1] = 1;
			}
		}

		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++)
				System.out.print(a[i][j] + " ");
			System.out.println();
		}

		scan.close();
	}

	private static int canGoSteps(int[][] a, int[][] b, int c) {
		int steps[] = new int[4];

		for (int i = 0; i < 4; i++) {
			int j;
			for(j = b.length - 1; j >= 0 ; j--){
				if(b[j][i] != 0)
					break;
			}
			steps[i] = b.length - j - 1;
			for(j = b.length -1; j < a.length ; j++){
				if(a[j][i+c-1] != 0)
					break;
			}
			steps[i] += j - 4;
		}

		steps[0] = Math.min(steps[0], steps[1]);
		steps[1] = Math.min(steps[2], steps[3]);
		steps[0] = Math.min(steps[0], steps[1]);

		return steps[0];
	}

}

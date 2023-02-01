package BOJ;

import java.util.Scanner;

public class 색종이_2563 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[][] map = new int[100][100];
		
		int N = sc.nextInt();
		int[] black = new int[2];
		for(int i=0; i<N; i++) {
			black[0] = sc.nextInt();
			black[1] = sc.nextInt();
			for(int x=black[0]; x<black[0] + 10; x++) {
				for(int y=black[1]; y<black[1] + 10; y++) {
					map[x][y] = 1;
				}
			}
		}
		int cnt = 0;
		for(int i=0; i<100; i++)
			for(int j=0; j<100; j++)
				cnt += map[i][j];
		System.out.println(cnt);
		sc.close();
	}

}

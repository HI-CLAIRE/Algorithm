package SWEA;

import java.util.Scanner;

public class 달팽이숫자_0926 {

	static int[][] map;
	static int N;
	
	private static boolean judgeDir(int x, int y, int dir) {
		
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int tc=1; tc<=T; tc++) {
			N = sc.nextInt();
			map = new int[N][N];
			
			int x=0, y=0, dir=0;
			
			for(int i=1; i<=N*N; i++) {
				map[x][y] = i;
				
				if(judgeDir(x, y, dir))
					dir = (dir + 1) % 4;
			}
		}

	}

}

package SWEA;

import java.util.Scanner;

public class 달팽이숫자 {
	
	static boolean judgeDir(int[][] map, int x, int y, int dir, int n) {
		switch(dir) {
		case 0: y++; break;
		case 1: x++; break;
		case 2: y--; break;
		case 3: x--;
		}
		if(x>=n||y>=n||x<0||y<0||map[x][y] != 0)
			return true;
		return false;
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int tc=1; tc<=T; tc++) {
			int N = sc.nextInt();
			int x = 0;
			int y = 0;
			int[][] map = new int[N][N];
			
			int dir = 0;
			/* RIGHT: 0
			 * DOWN: 1
			 * LEFT: 2
			 * UP: 3
			 */
			
			for(int i=1; i<=N*N; i++) {
				map[x][y] = i;
				
				if(judgeDir(map, x, y, dir, N))
					dir = (dir+1) % 4;
				
				switch(dir) {
				case 0: y++; break;
				case 1: x++; break;
				case 2: y--; break;
				case 3: x--;
				}	
			}
			
			System.out.println("#" + tc);
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++)
					System.out.print(map[i][j] + " ");
				System.out.println();
			}
		}
		sc.close();
	}
}

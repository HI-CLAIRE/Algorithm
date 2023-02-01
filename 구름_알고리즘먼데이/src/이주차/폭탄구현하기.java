package 이주차;

import java.util.Scanner;

public class 폭탄구현하기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int k = sc.nextInt();
		
		int[][] map = new int[n][n];
		
		int[] dr = {-1, 0, 1, 0};
		int[] dc = {0, 1, 0, -1};
		
		for(int i=0; i<k; i++) {
			int r = sc.nextInt() - 1;
			int c = sc.nextInt() - 1;
			
			map[r][c] += 1;
			for(int d=0; d<4; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				
				if(nr>=0 && nc>=0 && nr<n && nc<n) {
					map[nr][nc] += 1;
				}
			}
		}
		
		int ans = 0;
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				ans += map[i][j];
			}
		}
		
		System.out.println(ans);
		sc.close();
	}

}

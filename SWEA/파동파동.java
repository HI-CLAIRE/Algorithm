package IM대비SWEA;

import java.util.Scanner;

public class 파동파동 {

	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();
		Scanner sc = new Scanner(System.in);
		
		// 좌상 -> 상 -> 우상 -> 우 -> 우하 -> 하 -> 좌하 -> 좌 
		int[] dr = {-1, -1, -1, 0, 1, 1, 1, 0};
		int[] dc = {-1, 0, 1, 1, 1, 0, -1, -1};
		
		int T = sc.nextInt();
		for(int tc=1; tc<=T; tc++) {
			int N = sc.nextInt();		 // 배열크기 
			int[][] map = new int[N][N]; // 초기 map
			
			int init = sc.nextInt();	// 초기값 
			int r = sc.nextInt();		// 시작 좌표(r)
			int c = sc.nextInt();		// 시작 좌표(c)
			int D = sc.nextInt();		// 증감 
			
			map[r][c] = init;
			int i = 1;
			int next = 0;
			while(true) {
				next = init - (D*i);
				
				if(next <= 0) break;
				
				for(int d=0; d<8; d++) {
					int nr = r + dr[d] * i;
					int nc = c + dc[d] * i;
					
					// 범위 안에 있을 때만 파동파동 
					if(nr>=0 && nc>=0 && nr<N && nc<N) {
						map[nr][nc] = next;
					}
				}
				i++;
			}
			printer(map, N);
		}

	}
	
	public static void printer(int[][] map, int N) {
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				System.out.print(map[i][j] + "  ");
			}
			System.out.println();
		}
	}

}

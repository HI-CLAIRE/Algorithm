package IM대비SWEA;

import java.util.Scanner;

public class 고대유적 {

	static int N, M, ans;
	static int[][] map;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		int T = sc.nextInt();
		for(int tc=1; tc<=T; tc++) {
			sb.append("#").append(tc).append(" ");
			N = sc.nextInt();
			M = sc.nextInt();
			
			map = new int[N][M];
			for(int r=0; r<N; r++) {
				for(int c=0; c<M; c++) {
					map[r][c] = sc.nextInt();
				}
			}
			
			int[] dr = {1, 0};
			int[] dc = {0, 1};
			
			ans = 0;
			for(int r=0; r<N; r++) {
				for(int c=0; c<M; c++) {
					if(map[r][c] == 1) {
						for(int d=0; d<2; d++) {
							int cnt = 1;
							int i =1;
							while(true) {
								int nr = r + dr[d]*i;
								int nc = c + dc[d]*i;
								if(nr>=N || nc>=M || map[nr][nc]==0) {
									ans = Math.max(ans, cnt);
									break;
								}						
								if(map[nr][nc] == 1) cnt++;
								i++;
							}
						}
					}
				}
			}
			sb.append(ans).append("\n");
		}
		System.out.println(sb.toString());
		sc.close();
	}

}

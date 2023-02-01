package S2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 유기농배추_1012 {

	static int[][] map;
	static int M, N, K;
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int tc=1; tc<=T; tc++) {
			M = sc.nextInt();
			N = sc.nextInt();
			K = sc.nextInt();
			
			map = new int[M][N];
			
			for(int k=0; k<K; k++) {
				map[sc.nextInt()][sc.nextInt()] = 1;
			}
			
			int cnt = 0;
			for(int r=0; r<M; r++) {
				for(int c=0; c<N; c++) {
					if(map[r][c] == 1) {
						bfs(r, c);
						cnt++;						
					}
				}
			}
			System.out.println(cnt);
		}

	}

	private static void bfs(int R, int C) {
		Queue<int[]> q = new LinkedList<>();
		
		map[R][C] = 0;
		q.offer(new int[] {R, C});
		
		while(!q.isEmpty()) {
			int[] pos = q.poll();
			int r = pos[0];
			int c = pos[1];
			
			for(int d=0; d<4; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				
				if(nr>=0 && nr<=M-1 && nc>=0 && nc<=N-1 && map[nr][nc] == 1) {
					map[nr][nc] = 0;
					q.offer(new int[] {nr, nc});
				}
			}
		}
		
	}

}

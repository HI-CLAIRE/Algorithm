package S2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 아기상어2_17086 {

	public static class Node {
		int r;
		int c;
		int cnt;
		public Node(int r, int c, int cnt) {
			super();
			this.r = r;
			this.c = c;
			this.cnt = cnt;
		}
		
	}
	
	static int[][] map;
	static int N, M, max;
	static boolean[][] visited;
	static int[] dr = {-1, -1, 0, 1, 1, 1, 0, -1};
	static int[] dc = {0, 1, 1, 1, 0, -1, -1, -1};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		map = new int[N][M];
		visited = new boolean[N][M];
		
		for(int r=0; r<N; r++) {
			for(int c=0; c<M; c++) {
				map[r][c] = sc.nextInt();
			}
		}
		max = 0;
		for(int r=0; r<N; r++) {
			for(int c=0; c<M; c++) {
				if(!visited[r][c] && map[r][c] == 0) {
					bfs(r, c, 0);
					
					// 방문 초기화
					visited = new boolean[N][M];
				}
			
			}
		}
		System.out.println(max);
		sc.close();

	}

	private static void bfs(int R, int C, int Cnt) {
		Queue<Node> q = new LinkedList();
		
		visited[R][C] = true;
		q.offer(new Node(R, C, Cnt));
		
		while(!q.isEmpty()) {
			Node pos = q.poll();
			int r = pos.r;
			int c = pos.c;
			int cnt = pos.cnt;
			
			// 탈출조건
			// 1일때 최댓값을 구하고 탈출
			if(map[r][c] == 1) {
				max = Math.max(cnt, max);
				return;
			}
			
			for(int d=0; d<8; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				
				if(nr>=0 && nr <=N-1 && nc>=0 && nc<=M-1 && !visited[nr][nc]) {
					visited[nr][nc] = true;
					q.offer(new Node(nr, nc, cnt + 1));
				}
			}
		}
	}

}
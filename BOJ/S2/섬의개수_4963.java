package S2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 섬의개수_4963 {

	public static class Island {
		int r;
		int c;
		
		public Island(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
		
	}
	static int R, C;
	static int[][] map;
	static boolean[][] visited;
	static int[] dr = {-1, -1, 0, 1, 1, 1, 0, -1};
	static int[] dc = {0, 1, 1, 1, 0, -1, -1, -1};

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			R = sc.nextInt();
			C = sc.nextInt();
			
			if(R==0 && C==0) break;
			
			map = new int[C][R];
			visited = new boolean[C][R];
			for(int r=0; r<C; r++) {
				for(int c=0; c<R; c++) {
					map[r][c] = sc.nextInt();
				}
			}

			int cnt = 0;
			for(int r=0; r<C; r++) {
				for(int c=0; c<R; c++) {
					if(!visited[r][c] && map[r][c] == 1) {
						bfs(r, c);
//						System.out.println("여기");
						cnt++;
					}
						
				}
			}
			System.out.println(cnt);
		}
		
		sc.close();
	}

	/*
	 * 방문처리는 항상 큐에 집어 넣기 전에
	 * BFS 순서
	 * 1. 비어있는 큐를 만듦
	 * 2. 시작정점을 방문처리 후 && 시작정점을 큐에 집어 넣음
	 * 3. while(!queue.isEmpty) {
	 * 		4. 큐에서 정점 v을 하나 꺼냄
	 * 		5. v에 연결된 w가 있다면 w를 방문처리 후 && 그 정점을 큐에 집어 넣음
	 * 	  }
	 */
	private static void bfs(int i, int j) {
		Queue<Island> q = new LinkedList<>();
		
		visited[i][j] = true;
		q.offer(new Island(i, j));
		
		while(!q.isEmpty()) {
			Island currentLand = q.poll();
			int r = currentLand.r;
			int c = currentLand.c;
			
			for(int d=0; d<8; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];

				if(nr>=0 && nr<=C-1 && nc>=0 && nc<=R-1 && !visited[nr][nc] && map[nr][nc]==1) {
					visited[nr][nc] = true;
					q.offer(new Island(nr, nc));
				}
			}
			
		}
		
		
	}

}

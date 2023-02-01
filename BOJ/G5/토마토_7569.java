package G5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 토마토_7569 {

	static int M, N, H, max;
	static int[][][] box;
	static boolean[][][] visited;
	static int[] dr = {-1, 0, 1, 0, 0, 0};
	static int[] dc = {0, 1, 0, -1, 0, 0};
	static int[] dh = {0, 0, 0, 0, 1, -1};
	static Queue<Tomato> q = new LinkedList<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		
		box = new int[M][N][H];
		visited = new boolean[M][N][H];
		
		// -1인 칸은 갈 수 없으므로 방문처리를 한 후 들어가지 못하도록
		for(int h=0; h<H; h++) {
			for(int r=0; r<M; r++) {
				st = new StringTokenizer(br.readLine());
				for(int c=0; c<N; c++) {
					box[r][c][h] = Integer.parseInt(st.nextToken());
					if(box[r][c][h] == -1) {
						visited[r][c][h] = true;		
					}
					else if(box[r][c][h] == 1) {
						visited[r][c][h] = true;
						q.offer(new Tomato(r, c, 0, h));
					}
				}
			}			
		}
		max = 0;
		bfs();
		for(int h=0; h<H; h++) {
			for(int i=0; i<M; i++) {
				for(int j=0; j<N; j++) {
					if(box[i][j][h] == 0) {
						max = -1;
						break;
					}
				}
			}			
		}
		
		System.out.println(max);
	}

	private static void bfs() {
		while(!q.isEmpty()) {
			Tomato pos = q.poll();
			int r = pos.r;
			int c = pos.c;
			int cnt = pos.cnt;
			int h = pos.floor;
			
			// 사방탐색 진행
			for(int d=0; d<6; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				int nh = h + dh[d];
				
				if(nr>=0 && nr<=M-1 && nc>=0 && nc<=N-1 && nh>=0 && nh<=H-1 && 
						!visited[nr][nc][nh] && box[nr][nc][nh]==0) {
					visited[nr][nc][nh] = true;
					box[nr][nc][nh] = 1;
					q.offer(new Tomato(nr, nc, cnt+1, nh));
				}
			}
			max = Math.max(max, cnt);
		}
	}

	public static class Tomato {
		int r;
		int c;
		int cnt;
		int floor;
		public Tomato(int r, int c, int cnt, int floor) {
			super();
			this.r = r;
			this.c = c;
			this.cnt = cnt;
			this.floor = floor;
		}
		
	}
}

package IM대비SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 그는내가아는전설의폭탄마였어 {

	static int[][] map;
	static int N, P;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int T = Integer.parseInt(st.nextToken());
		
		for(int tc=1; tc<=T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());			
			P = Integer.parseInt(st.nextToken());
			
			map = new int[N][N];
			for(int r=0; r<N; r++) {
				st = new StringTokenizer(br.readLine());
				for(int c=0; c<N; c++) {
					map[r][c] = Integer.parseInt(st.nextToken());
				}
			}
			// 대각선 
			int[] cr = {-1, -1, 1, 1};
			int[] cc = {-1, 1, 1, -1};
			
			// 직선 
			int[] sr = {-1, 0, 1, 0};
			int[] sc = {0, 1, 0, -1};
			int max = Integer.MIN_VALUE;
			for(int r=0; r<N; r++) {
				for(int c=0; c<N; c++) {
					int s = bomb(r, c, sr, sc); // 직선 
					int x = bomb(r, c, cr, cc); // 대각선 
					max = Math.max(max, Math.max(s, x));
				}
			}
			
			System.out.println("#" + tc + " " + max);
		}

	}

	private static int bomb(int r, int c, int[] dr, int[] dc) {
		int ans = 0;
		
		for(int i=1; i<=P; i++) {
			for(int d=0; d<4; d++) {
				int nr = r + dr[d] * i;
				int nc = c + dc[d] * i;
				
				if(nr>=0 && nc>=0 && nr<N && nc<N) {
					ans += map[nr][nc];
				}
			}	
		}
		return ans + map[r][c];
	}

}

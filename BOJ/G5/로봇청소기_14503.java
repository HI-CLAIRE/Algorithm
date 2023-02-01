package G5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 로봇청소기_14503 {

	static int R, C, cnt;
	static int[][] map;
	static int[] robot;
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
				
		st = new StringTokenizer(br.readLine());
		robot = new int[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
		
		// 0-북 1-동 2-남 3-서 
		int d = Integer.parseInt(st.nextToken());
		
		map = new int[R][C];
		for(int r=0; r<R; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c=0; c<C; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		cnt  = 0;
		// 현재 로봇이 있는 좌표를 넘겨주기 
		dfs(robot[0], robot[1], d);
		System.out.println(cnt);
//		printer();
	}

	private static void dfs(int r, int c, int d) {
		// 현재 로봇이 있는 곳은 청소하였으므로 -1로 표시 
		if(map[r][c] == 0) {
			map[r][c] = -1;
			cnt++;			
		}
		else if(map[r][c] == 1)
			return;
		
//		System.out.printf("r : %d, c : %d, d : %d\n", r, c, d);
//		System.out.printf("cnt : %d\n", cnt);
 
		
		// 현재 d의 왼쪽방향을 네번 봐보면서 있으면 진행 없으면 return
		for(int i=0; i<4; i++) {
			d = (d+3) % 4;
			
			int nr = r + dr[d];
			int nc = c + dc[d];
			
			if(nr>=0 && nc>=0 && nr<R && nc<C && map[nr][nc]==0) {
				dfs(nr, nc, d);
				return;
			} 
			
		}
		
		// return해서 돌아온 위치
		back(r, c, d);
	}

	// 다시다
	private static void back(int r, int c, int d) {
			// 1->3 정반대의 방향으로 후진필요 
							
		int nd = (d + 2) % 4;
		
		r += dr[nd];
		c += dc[nd];
		if(r>=0 && c>=0 && r<R && c<C) {
			dfs(r, c, d);
			return;
		}
	}

//	private static void printer() {
//		for(int i=0; i<R; i++) {
//			for(int j=0; j<C; j++) {
//				System.out.printf("%3d ", map[i][j]);
//			}
//			System.out.println();
//		}
//	}
	
// 반례
//	7 7
//	4 2 1
//	1 1 1 1 1 1 1
//	1 0 0 0 1 0 1
//	1 0 1 1 0 0 1
//	1 0 0 0 0 1 1
//	1 0 0 1 0 0 1
//	1 0 0 0 0 0 1
//	1 1 1 1 1 1 1
//	>> 11
	
}

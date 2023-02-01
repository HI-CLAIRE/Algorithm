package G4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 미세먼지안녕_17145_다시 {

	static int R, C, T;
	static int[][] map, copy;
	static ArrayList<int[]> filter = new ArrayList<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());

		map = new int[R][C];
		copy = new int[R][C];
		
		// map 입력받기
		for(int r=0; r<R; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c=0; c<C; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
				if(map[r][c] == -1) {
					filter.add(new int[] {r,c});
				}
			}
		}
		for(int t=0; t<T; t++) {
			// 미세먼지 확산
			diffusion();
			
			// 공기청정기 순환
			circulator();	
//			printer();
		}
		int ans = 0;
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				ans += map[i][j];
			}
		}
		System.out.println(ans + 2);
		
	}
	

	/*
	 * 확산되는 순서
	 * 1. copy 배열에 현재 미먼을 제외한 확산된 먼지양을 저장
	 * 2. 현재 map 배열에 확산되고 남은 양 더해가면서 저장
	 * 3. 마지막에 map과 copy를 병합 
	 */
	
	private static void diffusion() {
		int[] dr = {-1, 0, 1, 0};
		int[] dc = {0, 1, 0, -1};
		
		for(int r=0; r<R; r++) {
			for(int c=0; c<C; c++) {
				
				int dustAmount = map[r][c] / 5;
				int cnt = 0;
				for(int d=0; d<4; d++) {
					int nr = r + dr[d];
					int nc = c + dc[d];
					
					if(nr>=0 && nc>=0 && nr<R && nc<C && map[nr][nc] != -1) {
						copy[nr][nc] += dustAmount;
						cnt++;
					}
				}
				map[r][c] -= dustAmount * cnt;
			}
		}
		
		for(int r=0; r<R; r++) {
			for(int c=0; c<C; c++) {
				map[r][c] += copy[r][c];
				copy[r][c] = 0;	// 초기화 
			}
		}
	}

	
	// 순환 
	private static void circulator() {
		int[] up = filter.get(0); 
		
		// 상 -> 우 -> 하 -> 좌  
		int[] drUp = {-1, 0, 1, 0};
		int[] dcUp = {0, 1, 0, -1};
		
		// 초기조건 
		int d = 0;
		int r = up[0] - 1; 
		int c = up[1];
		
		// 1. up (시계반대방향)
		while(true) {			
			int nr = r + drUp[d];
			int nc = c + dcUp[d];
			
			// 종료조건 
			if(nr == up[0] && nc == up[1]) {
				map[r][c] = 0;
				break;
			}
			
			if(nr<0 || nc<0 || nr>up[0] || nc>=C) {
				d = (d + 1) % 4;
				continue;		// 다음 반복문  
			}
			
			map[r][c] = map[nr][nc];
			
			r = nr;
			c = nc;
		}
		
		
		
		int[] down = filter.get(1);
		// 하 -> 우 -> 상 -> 좌  
		int[] drDown = {1, 0, -1, 0};
		int[] dcDown = {0, 1, 0, -1};
		d = 0;

		// 초기조건 
		d = 0;
		r = down[0] + 1;
		c = down[1];
		
		// 2. down (시계방향)
		while(true) {			
			int nr = r + drDown[d];
			int nc = c + dcDown[d];
			
			// 종료조건 
			if(nr == down[0] && nc == down[1]) {
				map[r][c] = 0;
				break;
			}
			
			if(nr<down[0] || nc<0 || nr>=R || nc>=C) {
				d = (d + 1) % 4;
				continue;		// 다음 반복문  
			}
			
			map[r][c] = map[nr][nc];
			
			r = nr;
			c = nc;
		}
	}

//	private static void printer() {
//		for(int i=0; i<R; i++) {
//			for(int j=0; j<C; j++) {
//				System.out.print(map[i][j] + " ");
//			}
//			System.out.println();
//		}
//	}

}

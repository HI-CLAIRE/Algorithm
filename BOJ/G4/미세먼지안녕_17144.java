package G4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 미세먼지안녕_17144 {

	static int R, C, T;
	static int[][] map;
	static ArrayList<int[]> filter;
	static ArrayList<int[]> dust;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());

		map = new int[R][C];
		
		
		// map 입력받기
		for(int r=0; r<R; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c=0; c<C; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
				if(map[r][c] == -1) {
					filter.add(new int[] {r, c});
				}
				else if(map[r][c] > 0) {
					dust.add(new int[] {r, c});
				}
			}
		}
		for(int t=0; t<T; t++) {
			// 미세먼지 확산
			diffusion(t);
			
			// 공기청정기 순환
			circulator();			
		}
		
	}
	
	private static void diffusion(int t) {
		int dr[] = {-1, 0, 1, 0};
		int dc[] = {0, 1, 0, -1};
		
		int r = dust.get(t)[0];
		int c = dust.get(t)[1];
		int cnt = 0;	// 확산된 방향의 개수
		int dustAmount = map[r][c] / 5;	// 확산된 미세먼지 양
		
		for(int d=0; d<4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			
			// 인접한 칸은 현재 미먼양 + 확산된양
			if(nr>=0 && nc>=0 && nr<R && nc<C && map[nr][nc] != -1) {
				map[nr][nc] = map[r][c] + dustAmount;
				cnt++;
			}
		}
		// 바뀐 현재 미먼양
		map[r][c] -= dustAmount * cnt;
		
		// 바뀌고난 미세먼지 값들을 다시 dust에 넣어줘야함.
		// 어떻게?
	}

	private static void circulator() {
		
		
	}


}

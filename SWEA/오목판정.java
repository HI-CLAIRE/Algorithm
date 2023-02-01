package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 오목판정 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			int N = Integer.parseInt(br.readLine());
			Character[][] map = new Character[N][N];
			sb.append("#").append(tc).append(" ");
			
			// 입력
			for(int i=0; i<N; i++) {
				String line = br.readLine();
				for(int j=0; j<N; j++) {
					map[i][j] = line.charAt(j);
				}
			}
			
			// 판별 45도, 90도, 125도, 180도
			int[] dx = {1, 1, 1, 0};
			int[] dy = {-1, 0, 1, 1};
			
			int cnt=1;
			boolean omoq = false;
			
			out : for(int y=0; y<N; y++) {
				for(int x=0; x<N; x++) {
					if(map[y][x] == 'o') {
						for(int d=0; d<4; d++) {
							for(cnt=1; cnt<=5; cnt++) {	
								if(cnt >= 5) { 
									omoq = true;
									break out;
								}
								int nx = x + dx[d] * cnt, ny = y + dy[d] * cnt;
								if(nx>=N || ny>=N || nx<0 || ny<0) break;
								if(map[ny][nx] != 'o') break;
							}
						}
					}
				}
			}
			if(omoq) sb.append("YES").append("\n");
			else sb.append("NO").append("\n");
		}
		System.out.println(sb.toString());
	}
}

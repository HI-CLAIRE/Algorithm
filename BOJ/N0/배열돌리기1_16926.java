package BOJ;

import java.io.IOException;
import java.util.Scanner;

public class 배열돌리기1_16926 {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int M = sc.nextInt();
		int N = sc.nextInt();
		int R = sc.nextInt();
		int[][] map = new int[M][N];
		for(int i=0; i<M; i++)
			for(int j=0; j<N; j++)
				map[i][j] = sc.nextInt();
		int[] dx = {-1, 0, 1, 0};
		int[] dy = {0, -1, 0, 1};
		
		int x=0, y=0, d=0;
		int min = Math.min(M, N);
		for(int layer = 0; layer<min/2;layer++) {
			x = layer; y = layer;
			for(int r=0; r<R; r++) {
				int tmp = map[layer][layer];
				while(true) {
					int nx = x + dx[d];
					int ny = y + dy[d];
					
					if(ny>=M-layer || nx>=N-layer || ny<layer || nx<layer) {
						d = (d+1) % 4;
						continue;
					}
					map[y][x] = map[ny][nx];
					x = nx; y = ny;
					if(nx == layer && ny == layer) {
						map[layer+1][layer] = tmp;
						break;
					}
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<M; i++) {
			for(int j=0; j<N; j++) {
				sb.append(map[i][j]).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
		sc.close();
	}
}

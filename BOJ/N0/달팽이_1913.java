package BOJ;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class 달팽이_1913 {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] map = new int[N][N];
		int[] dirX = {0, 1, 0, -1}; // 진행방향  
		int[] dirY = {1, 0, -1, 0}; // 하 우 상 좌
		int d = 0, x = 0, y = 0;
		
		map[y][x] = N * N;
		
		for(int n=N*N - 1; n>=1; n--) {
			int nx = x + dirX[d];
			int ny = y + dirY[d];
			
			if(nx >= N || ny >= N || nx < 0 || ny < 0 || map[ny][nx]!= 0) {
				d = (d+1) % 4;
				n++;
			}
			else {
				x = nx;
				y = ny;				
				map[ny][nx] = n;
			}
		}
		
		int num = sc.nextInt();
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String ans = "";
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				bw.write(String.valueOf(map[i][j]) + " ");
				if(num == map[i][j]) {
					ans = (i+1) + " " + (j+1);
				}
			}
			bw.write("\n");
		}
		bw.write(ans);
		bw.flush();
		bw.close();
		sc.close(); 
	}

}

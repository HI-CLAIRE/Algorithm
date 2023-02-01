package BOJ;

import java.util.Scanner;

public class 창고다각형_2304 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] map = new int[1000][1000];
		for(int tc=0; tc<N; tc++) {
			int L = sc.nextInt();
			int H = sc.nextInt();
			for(int i=0; i<H; i++)
				map[L][i] = 1;
		}
		int cnt = 0;
		int ans = 0;
		for(int i=0; i<1000; i++) {
			for(int j=0; j<1000; j++) {
				int nx = i + cnt;
				if(nx>=1000 || nx<0) continue;
				while(map[i][j] == 1 && map[nx][j] == 1) {
					cnt++;
					for(int k=0; k<cnt; k++)
						map[i+k][j] = 1;
				}
				if(map[i][j] == 1) ans++;
			}
		}
		for(int i=0;i<20; i++) {
			for(int j=0; j<20; j++)
				System.out.print(map[i][j]);
			System.out.println();
		}
		System.out.println(ans);
	}

}

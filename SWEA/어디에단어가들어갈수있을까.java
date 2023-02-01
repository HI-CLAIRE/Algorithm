package SWEA;

import java.util.Scanner;

public class 어디에단어가들어갈수있을까 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int tc=1; tc<=T; tc++) {
			int N = sc.nextInt();
			int K = sc.nextInt();
			int[][] map = new int[N][N];
			for(int i=0; i<N; i++)
				for(int j=0; j<N; j++)
					map[i][j] = sc.nextInt();
			int ans = 0;
			for(int i=0; i<N; i++) {
				int cnt = 0;
				for(int j=0; j<N; j++) {
					if(map[i][j] == 0) {
						if(cnt == K) ans++;
						cnt = 0;
					}
					else cnt++;
				}
				if(cnt == K) ans++;	
			}
			for(int j=0; j<N; j++) {
				int cnt = 0;
				for(int i=0; i<N; i++) {
					if(map[i][j] == 0) {
						if(cnt == K) ans++;
						cnt = 0;
					}
					else cnt++;
				}
				if(cnt == K) ans++;	
			}
			System.out.println("#" + tc + " " + ans);
		}
		sc.close();
	}
}

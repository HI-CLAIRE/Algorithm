package SWEA;

import java.util.Scanner;

public class 파리퇴치 {
	public static int spray(int[][] arr, int[][] DIR, int M, int x, int y) {
		int sum = arr[x][y];
		for(int dir=0; dir<DIR.length; dir++) {	
			for(int i=1; i<M; i++) {
				int nx = x + (i*DIR[dir][0]);
				int ny = y + (i*DIR[dir][1]);
				if(nx >= arr.length || nx < 0) continue;	// 행 값 범위 제한
		    	if(ny >= arr[0].length || ny < 0) continue;	// 열 값 범위 제한
				sum += arr[nx][ny];
			}
		}
		return sum;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int tc=1; tc<=T; tc++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			int ans = 0;
			
			int[][] fly = new int[N][N];
			for(int i=0; i<N; i++)
				for(int j=0; j<N; j++)
					fly[i][j] = sc.nextInt();
			
			int[][] dirT = {{-1, 0},{1, 0},{0, -1},{0, 1}};     //십자가 방향
			int[][] dirX = {{-1, -1}, {1, 1}, {-1, 1}, {1, -1}}; //엑스 방향
			
			int sumT, sumX = 0;
			int max = 0;
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					
					sumT = spray(fly, dirT, M, i, j);
					sumX = spray(fly, dirX, M, i, j);
					max = Math.max(sumT, sumX);
					ans = Math.max(ans, max);
				}
			}
			System.out.println("#" + tc + " " + ans);
		}
	}
}

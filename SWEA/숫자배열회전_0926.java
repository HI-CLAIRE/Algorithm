package SWEA;

import java.util.Scanner;

public class 숫자배열회전_0926 {

	static int N;
	
	private static int[][] turn(int[][] arr) {
		int[][] ans = new int[N][N];
		for(int j=0; j<N; j++) {
			for(int i=0; i<N; i++) {
				ans[i][(N-1) - j] = arr[j][i];
			}
		}
		return ans;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int tc=1; tc<=T; tc++) {
			N = sc.nextInt();
			int[][] map = new int[N][N];
			
			for(int i=0; i<N; i++)
				for(int j=0; j<N; j++)
					map[i][j] = sc.nextInt();
			
			int[][] t1 = turn(map);
			int[][] t2 = turn(t1);
			int[][] t3 = turn(t2);
			
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(tc).append("\n");
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++)
					sb.append(t1[i][j]);
				sb.append(" ");
				for(int j=0; j<N; j++)
					sb.append(t2[i][j]);
				sb.append(" ");
				for(int j=0; j<N; j++)
					sb.append(t3[i][j]);
				sb.append("\n");
			}
			System.out.print(sb.toString());
		}
	}

}

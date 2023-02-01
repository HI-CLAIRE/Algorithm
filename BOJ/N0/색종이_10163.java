package BOJ;

import java.util.Scanner;

public class 색종이_10163 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] sq = new int[4];
		int[][] map = new int[1001][1001];
		for (int n = 0; n < N; n++) {
			for (int i = 0; i < 4; i++)
				sq[i] = sc.nextInt();
			
			// INPUT
			int x = sq[0];
			int y = sq[1];
			int len = sq[2];
			int height = sq[3];
			
			// 범위만큼 n+1로 채우기
			for (int r = x; r < x + len; r++) 
				for (int j = y; j < y + height; j++) 
					map[r][j] = n + 1;
		}
		// 노출된 부분 카운트
		for (int n = 1; n <= N; n++) {
			int cnt = 0;
			for (int arr[] : map) 
				for (int i : arr) 
					if (i == n)       //해당하는 값만 카운트해서 바로 내보내기
						cnt++;
			System.out.println(cnt);
		}
		sc.close();
	}
}

package SWEA;

import java.util.Scanner;

public class 농작물수확하기{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int[][] arr = new int[N][N];
			for(int i = 0; i < N; i++) {
				String str = sc.next();
				for(int j = 0; j < N; j++) {
					arr[i][j] = str.charAt(j) - '0';//'1' '0'
				}
			}
			int ans = 0; //수확 총합을 저장할 변수.
			int r = N / 2;
			int c = N / 2;
			
			//순회를 전체를 하되,
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					//해당 칸이 r과c가 변한 거리의 합이 (N/2) 보다 작거나 같으면??
					if ( Math.abs(r - i) + Math.abs(c - j) <= N / 2 )
						ans += arr[i][j];
				}
			}
//			int mid = N/2;
//			for(int i = 0; i <= mid ; i++) {
//				for(int j = mid-i;  j <= mid+i; j++)
//					ans += arr[i][j];
//			}
//			//5*5일때 mid는 2행인데 i는 3행부터 시작
//			//3행일때 1-3까지 이동
//			//4행일때 2-2까지 이동
//			for(int i = mid+1; i < N; i++) {
//				for(int j = i - mid; j < N - (i-mid); j++)
//					ans += arr[i][j];
//			}
			
			
			System.out.println("#" + tc + " " + ans);
		}
	}
}
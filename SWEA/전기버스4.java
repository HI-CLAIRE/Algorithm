package IM대비SWEA;

import java.util.Scanner;

public class 전기버스4 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for(int tc=1; tc<=T; tc++) {
			int K = sc.nextInt();
			int N = sc.nextInt();
			int M = sc.nextInt();
			
			boolean[] board = new boolean[N+K];
			for(int i=0; i<M; i++) {
				board[sc.nextInt()] = true;
			}
			
			int last=0, ans=0;
			
			out: for(int i=0; i<N; i++) {
				
				// start부터 K만큼 가보기
				for(int start=i; start<K+i; start++) {
					if(j>=N) break out;
					if(board[j]) last =j;
				}
				
				// 충전을 못 한 것
				if(last == start) {
					break;
				}
				System.out.println(1234);
				// 충전을 했으면 다음 시작 지점이 start가 되어야 한다.
				start = last;
				ans++;
			}
			System.out.println(ans);
		}
	}

}

package IM대비SWEA;

import java.util.Scanner;

public class 전기버스 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		int T = sc.nextInt();
		for(int tc=1; tc<=T; tc++) {
			int K = sc.nextInt(); // 충전하면 갈 수 있는 거리 
			int N = sc.nextInt(); // 정류장 수  
			int M = sc.nextInt(); // 충전기가 있는 정류장 번호 
			
			int[] busStops = new int[N + 1];
			int[] chargers = new int[N + 1];
			int[] dp = new int[N + 1];
			
			for(int i=0; i<N; i++) {
				busStops[i] = i;
			}
			for(int i=0; i<M; i++) {
				chargers[sc.nextInt()] = K;
			}
			
			for(int i=N-1; i>=0; i--) {
				int start = i + busStops[i];
				
				// dp[0] = chargers[i] + dp[3]
				if(start < N+1) {
					dp[i] = chargers[i] + dp[start];
				} else {
					dp[i] = dp[i+1];
				}
			}
			sb.append("#").append(tc).append(" ").append(dp[1]).append("\n");
		}
		System.out.print(sb.toString());
	}

}

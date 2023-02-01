package S3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 퇴사_14501 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[] T = new int[N+2];
		int[] P = new int[N+2];
		int[] dp = new int[N+2];
		
		for(int i=1; i<=N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			T[i] = Integer.parseInt(st.nextToken());
			P[i] = Integer.parseInt(st.nextToken());
		}

		for(int i=N; i>0; i--) {
			// i번째 날의 상담기간 
			int day = i + T[i];
			
			// dp[1] = MAX(P[1] + dp[4], dp[2])
			if(day <= N+1) {
				dp[i] = Math.max(P[i] + dp[day], dp[i+1]);
			} 
			// 상담일이 퇴사일을 초과하면 자동으로 dp[i+1] 의 값이 받을수 있는 최대금액 
			else {
				dp[i] = dp[i+1];
			}
		}
		System.out.println(dp[1]);
		br.close();
	}

}

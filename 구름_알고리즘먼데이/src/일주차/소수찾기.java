package 일주차;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 소수찾기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		
		boolean[] prime = new boolean[N+1];
		int[] arr = new int[N+1];
		
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<=N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		prime[0] = prime[1] = true;
		
		for(int i=2; i*i<=N; i++) {
			if(!prime[i]) {
				for(int j=i*i; j<=N; j+=i) {
					prime[j] = true;
				}
			}
		}

		int ans = 0;
		for(int i=1; i<=N; i++) {
			if(!prime[i])
				ans += arr[i];
		}
		System.out.println(ans);
		br.close();
	}

}

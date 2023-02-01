package S5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 소수찾기_1978 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int cnt = 0;
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			int n = Integer.parseInt(st.nextToken());
			
			if(isPrime(n)) {
				System.out.println(n);
				cnt++;
			}
		}
		System.out.println(cnt);
		
		br.close();
	}
	
	public static boolean isPrime(int n) {
		if(n < 2) return false;
		else {
			for(int i=2; i*i<=n; i++) {
				if(n % i == 0) return false;
			}
		}
		return true;
	}
}

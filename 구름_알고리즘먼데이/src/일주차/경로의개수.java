package 일주차;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 경로의개수 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		long[] arr = new long[T];
		for(int t=0; t<T; t++) {
			arr[t] = Integer.parseInt(st.nextToken());
		}
		
		
		long ans = 1;
		for(long i : arr) {
			ans *= i;
		}
		System.out.println(ans);
		
	} 

}

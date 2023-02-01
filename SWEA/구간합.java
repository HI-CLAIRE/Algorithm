package SWEA;

import java.util.Arrays;
import java.util.Scanner;

public class 구간합 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int tc=1; tc<=T; tc++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			
			int[] list = new int[N];
			
			for(int i=0; i<N; i++) {
				list[i] = sc.nextInt();
			}
			
			int min = Integer.MAX_VALUE;
			int max = Integer.MIN_VALUE;
			
			for(int i=0; i<=N-M; i++) {
				int tmp = 0;
				for(int j=0; j<M; j++) {
					tmp += list[i+j];
				}
				min = Math.min(min, tmp);
				max = Math.max(max, tmp);
			}
			
			int ans = max - min;		
			System.out.println("#" +tc+ " " + ans);
		}
		sc.close();
	}
}

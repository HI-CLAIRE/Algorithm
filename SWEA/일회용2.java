package IM대비SWEA;

import java.util.Arrays;
import java.util.Scanner;

public class 일회용2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int tc=1; tc<=T; tc++) {
			int N = sc.nextInt();
			int k_min = sc.nextInt();
			int k_max = sc.nextInt();
			
			int[] arr = new int[N];
			for(int i=0; i<N; i++) {
				arr[i] = sc.nextInt();
			}
			Arrays.sort(arr);
			
			int[] board = new int[101];
			for(int i=0; i<N; i++) {
				board[arr[i]]++;
			}
			
			int T1=0, T2=0, c1=0, c2=0, c3=0;
			int min = Integer.MAX_VALUE;
			int max = Integer.MIN_VALUE;
			int ans = Integer.MAX_VALUE;
			boolean isOk = false;
			
			for(int i=1; i<100; i++) {
				T1 = i;
				for(int j=i+1; j<=100; j++) {
					T2 = j;
					c1 = c2 = c3 = 0;
					
					
					if(board[j] != 0) {
						for(int k=0; k<T1; k++)
							c1 += board[k];
						for(int k=T1; k<T2; k++)
							c2 += board[k];
						for(int k=T2; k<N; k++)
							c3 += board[k];
					}
					
					
					
					if(c1<k_min || c2<k_min || c3<k_min || c1>k_max || c2>k_max || c3>k_max) {
						continue;
					}
					System.out.printf("%d %d %d %d %d\n",T1, T2, c1, c2, c3);
					min = Math.min(c1, Math.min(c2, c3));
					max = Math.max(c1, Math.max(c2, c3));
					
					ans = Math.min(ans, max - min);
					isOk = true;
				}
				
			}
			if(isOk) System.out.println(ans);
			else System.out.println("-1");
		}
	}
}

/*
 * arr[10] = {2, 2, 3, 4, 4, 4, 5, 5, 5, 5};
 * board[101] = {0, 2, 1, 3, 4, 0, ...};
 * 0 / 2 / 1 3 4	T1 = 2, T2 = 3
 * 1   2   3 4 5
 * i   j
 * 
 * i = 1, j = 2
 * 0 2 / 1 / 3 4	T1 = 3, T2 = 4
 * 1 2   3   4 5
 * 
 * 0 2 1 / 3 / 4	T1 = 4, T2 = 5
 * k_min = 1, k_max = 6;
 */

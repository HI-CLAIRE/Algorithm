package IM대비SWEA;

import java.util.Scanner;

public class 찐막막막막 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int tc=1; tc<=T; tc++) {
			int N = sc.nextInt();	 // 10
			int k_min = sc.nextInt();// 1
			int k_max = sc.nextInt();// 6
			
			int[] arr = new int[N];
			// 점수
			for(int i=0; i<N; i++) {
				arr[i] = sc.nextInt();
			}
			
			// board[101] = {0, 2, 1, 3, 4, ...}
			int[] board = new int[101];
			for(int i=0; i<N; i++) {
				board[arr[i]]++;
			}
			
			// 0 / 2 / 1 3 4
			// 0 2 / 1 / 3 4
			// 0 2 1 / 3 / 4 -> 정답
			
			int T1=0, T2=0;
			int ans = Integer.MAX_VALUE;
			int min = Integer.MAX_VALUE;
			int max = Integer.MIN_VALUE;
			boolean isOk = false;
			
			for(int i=1; i<100; i++) {
				T1 = i;
				
				for(int j=i+1; j<=100; j++) {
					int c1=0, c2=0, c3=0;
					T2 = j;
					
					for(int k=0; k<T1; k++) {
						c1 += board[k];
					}
					for(int k=T1; k<T2; k++) {
						c2 += board[k];
					}
					for(int k=T2; k<=100; k++) {
						c3 += board[k];
					}
					
					if(c1<k_min || c2<k_min || c3<k_min || c1>k_max || c2>k_max || c3>k_max) {
						continue;
					}
					
					min = Math.min(c1, Math.min(c2, c3));
					max = Math.max(c1, Math.max(c2, c3));
					
					ans = Math.min(ans, max - min);
					isOk = true;
					
					System.out.println("T1 : " + T1 + ", T2 : " + T2);
				}
//				System.out.println(c1 + " " + c2 + " " + c3);
			}
			if(isOk) System.out.println(ans);
			else System.out.println("-1");
		}

	}

}


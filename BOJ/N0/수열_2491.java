package BOJ;

import java.util.Scanner;

public class 수열_2491 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[] arr = new int[N];
		for(int n=0; n<N; n++)
			arr[n] = sc.nextInt();
		
		int ans = 1;
		
		// 오름차순 최댓값 구하기 
		int maxI = 1;
		for(int i=1; i<N; i++) {
			if(arr[i - 1] - arr[i] <= 0)
				maxI++;
			else
				maxI = 1; //초기화 
			ans = Math.max(maxI, ans);
		}
		
		// 내림차순 최댓값 구하기 
		int maxD = 1;
		for(int i=1; i<N; i++) {
			if(arr[i - 1] - arr[i] >= 0) 
				maxD++;
			else
				maxD = 1; //초기화 
			ans = Math.max(maxD, ans);
		}
		
		System.out.println(ans);
		sc.close();
	}

}

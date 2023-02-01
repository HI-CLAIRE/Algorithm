package S3;

import java.util.Scanner;

public class 계단오르기_2579 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[] arr = new int[N + 1];
		int[] tmp = new int[N + 1];
		for(int i=1; i<=N; i++)
			arr[i] = sc.nextInt();
		
		tmp[1] = arr[1];
		
		if(N >= 2)
			tmp[2] = arr[1] + arr[2];
		
		int max = 0;
		for(int i=3; i<=N; i++) {
			max = Math.max(tmp[i-2], tmp[i-3] + arr[i-1]);
			tmp[i] = max + arr[i];
		}
		
		System.out.println(tmp[N]);
		sc.close();
	}
}

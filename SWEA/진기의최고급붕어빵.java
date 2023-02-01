package SWEA;

import java.util.Arrays;
import java.util.Scanner;

public class 진기의최고급붕어빵 {

	public static void main(String[] args) {
		Scanner sc =  new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int tc=1; tc<=T; tc++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			int K = sc.nextInt();
			int[] arr = new int[N];
			for(int i=0; i<N; i++)
				arr[i] = sc.nextInt();
			Arrays.sort(arr);
			int now = 0;
			int left = 0;
			int isPos = 1;
			for(int i : arr) {
				now = (i / M) * K;
				if(now - left <= 0)
					isPos = 0;
				left++;
			}
			if(isPos == 0) System.out.println("#" + tc + " " + "Impossible");
			else System.out.println("#" + tc + " " + "Possible");
		}
		sc.close();
	}
}

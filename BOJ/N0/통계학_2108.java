package BOJ;

import java.util.Arrays;
import java.util.Scanner;

public class 통계학_2108 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		double sum = 0;
		int[] arr = new int[N];
		
		for(int i=0; i<N; i++) {
			arr[i] = sc.nextInt();
			sum += arr[i];
		}
		Arrays.sort(arr);		
		
		int cnt = 0;
		int max = -1;
		int mod = arr[0];
		int flag = 0;
		for(int i=0; i<N-1; i++) {
			if(arr[i+1] == arr[i])
				cnt++;
			else cnt = 0;
			if(max < cnt) {
				max = cnt;
				mod = arr[i];
				flag = 1;
			} else if(max == cnt && flag == 1) {
				mod = arr[i];
				flag = 0;
			}
		}
		System.out.println(Math.round(sum/N));
		System.out.println(arr[N/2]);
		System.out.println(mod);
		System.out.println(arr[N-1] - arr[0]);
		sc.close();
		
	}
}
package SWEA;

import java.util.Arrays;
import java.util.Scanner;

public class 중간평균값구하기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		int[] arr = new int[10];
		for(int tc=1; tc<=T; tc++) {
			double sum = 0;
			for(int i=0; i<10; i++) {
				arr[i] = sc.nextInt();
				sum += arr[i];
			}
			Arrays.sort(arr);
			sum = sum-arr[0]-arr[9];
			System.out.println("#"+ tc + " " + Math.round(sum/8));
		}
		sc.close();
	}
}

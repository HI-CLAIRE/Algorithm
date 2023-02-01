package SWEA;

import java.util.Arrays;
import java.util.Scanner;

public class 중간값찾기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[] arr = new int[N];
		for(int n=0; n<N; n++)
			arr[n] = sc.nextInt();
		Arrays.sort(arr);
		System.out.println(arr[N/2]);
		sc.close();
	}
}

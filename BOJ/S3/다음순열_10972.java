package S3;

import java.util.Scanner;

public class 다음순열_10972 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[] arr = new int[N];
		for(int i=0; i<N; i++)
			arr[i] = sc.nextInt();
		
		if(!np(arr)) System.out.println(-1);
		else {
			for(int i : arr)
				System.out.print(i + " ");
		}
	}

	public static boolean np(int[] arr) {
		// 1. 꼭대기 찾기 (없으면 false)
		int i = arr.length - 1;
		while(i > 0 && arr[i -1] >= arr[i]) i--;
		if(i == 0) return false;
			
		// 2. 낭떠러지보다 큰 수 찾기
		int j = arr.length - 1;
		while(arr[i-1] >= arr[j]) j--;
		
		// 3. B <-> C
		swap(arr, i-1, j);
		
		// 4. 역순
		int k = arr.length - 1;
		while(i < k) swap(arr, i++, k--);
		return true;
	}
	
	public static void swap(int[] arr, int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}
}

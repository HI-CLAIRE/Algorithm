package 모의SW역량테스트;

import java.util.Scanner;

public class 숫자만들기_교수님 {
	
	static int min, max;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=1; tc<=T; tc++) {
			int N = sc.nextInt();
			int[] ops = new int[4];
			int[] nums = new int[N];
			int[] arr = new int[N-1];
			
			for(int i=0; i<4; i++) {
				ops[i] = sc.nextInt();
			}
			
			for(int i=0; i<N; i++) {
				nums[i] = sc.nextInt();
			}
			
			int idx = 0;
			for(int i=0; i<4; i++) {
				for(int j=0; j<ops[i]; j++) {
					arr[idx++] = i;
				}
			}
			
			min = Integer.MAX_VALUE;
			max = Integer.MIN_VALUE;
			
			do {
				int res = nums[0];
				for(int i=0; i<arr.length; i++) {
					int o = arr[i];
					if(o == 0) res += nums[i+1];
					if(o == 1) res -= nums[i+1];
					if(o == 2) res *= nums[i+1];
					if(o == 3) res /= nums[i+1];
					
				}
				max = Math.max(max, res);
				min = Math.min(min, res);
			}while(np(arr));
			
			System.out.printf("#%d %d\n", tc, max - min);
		}
	}
	
	private static boolean np(int[] arr) {
		int i = arr.length - 1;
		while(i > 0 && arr[i - 1] >= arr[i]) i--;
		if(i == 0) return false;
		int j = arr.length - 1;
		while(arr[i-1] >= arr[j]) j--;
		swap(arr, i-1, j);
		int k = arr.length - 1;
		while(i < k) swap(arr, i++, k--);
		
		return false;
	}
	
	private static void swap(int[] arr, int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}

}

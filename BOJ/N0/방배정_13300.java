package BOJ;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 방배정_13300 {
	public static int room(List<Integer> arr, int K) {
		int cnt = 0;
		
		
		
		return cnt;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		int[][] arr = new int[N][2];
		for(int i=0; i<N; i++) {
			for(int j=0; j<2; j++)
				arr[i][j] = sc.nextInt();
		}
		List<Integer> female = new ArrayList<>();
		List<Integer> male = new ArrayList<>();
		
 		for(int i=0; i<N; i++) {
 			if(arr[i][0] == 0)
 				female.add(arr[i][1]);
 			else
 				male.add(arr[i][1]);
 		}
 		int ans = 0;
 		ans = room(female, K) + room(male, K);
 		System.out.println(ans);
	}
}

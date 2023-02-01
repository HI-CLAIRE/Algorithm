package BOJ;

import java.util.Scanner;

public class 참외밭_2477 {

	public static void main(String[] args) {
		//방향 동1, 서2, 남3, 북4
		
		Scanner sc = new Scanner(System.in);
		int melon = sc.nextInt();
		
		int[][] arr = new int[6][2];
		int[] cnt = new int[5];
		int ans = 1;
		
		for(int i=0; i<6; i++) {
			int dir = sc.nextInt();
			int val = sc.nextInt();
			arr[i][0] = dir;
			arr[i][1] = val;
			cnt[dir]++;
		}
		
		int minSq = 1;
		for(int i=0; i<6; i++) {
			if(cnt[arr[i][0]] == 1) { 
				ans *= arr[i][1];
				minSq *= arr[(i+3)%6][1];
			}
		}
		ans -= minSq;
		System.out.println(ans * melon);
	}

}

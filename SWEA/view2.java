package SWEA;

import java.util.Scanner;

public class view2 {

	static int N;
	static int[] building;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for(int tc=1; tc<=10; tc++) {
			N = sc.nextInt();
			building = new int[N];
			for(int i=0; i<N; i++) {
				building[i] = sc.nextInt();
			}
			int cnt = 0;
			for(int i=2; i<N-2; i++) {
				int max = Math.max(building[i-2], Math.max(building[i-1], 
						Math.max(building[i+1], building[i+2])));
				if(building[i] > max) cnt+=building[i] - max;
			}
			System.out.println("#" + tc + " " + cnt);
		}
	}

}

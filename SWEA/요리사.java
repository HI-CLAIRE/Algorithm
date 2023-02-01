package 모의SW역량테스트;

import java.util.Scanner;

public class 요리사 {

	static int[][] map;
	static int N;
	static boolean[] visited;
	static int[] f1;
	static int[] f2;
	static int min = Integer.MAX_VALUE;
	
	// 식재료 두 개를 넘겨줬을 때 음식의 
	private static int synergy(int[] f) {
		int ans = 0;
		
		for(int i : f) {
			for(int j : f) {
				ans += map[i][j];
			}
		}
		return ans;
	}
	
	// 식재료 중복 없이 뽑기 (조합)
	// food1 과 food2 조합 배열 2개 필요
	private static void comb(boolean[] visited, int start, int r) {
	//	System.out.printf("start : %d, r : %d, N : %d\n", start, r, N);
		if(r == 0) {
			f1 = new int[N/2];
			f2 = new int[N/2];
			
			// i, j=f1, k=f2
			for(int i=0, j=0, k=0; i<N; i++) {
				if(visited[i]) f1[j++] = i;
				elsenaver.c f2[k++] = i;
			}
			
			int flavor = Math.abs(synergy(f1) - synergy(f2));
			
			// 맛의 최소 구하기 
			min = Math.min(flavor, min);
			
			return;
		}
		for(int i=start; i<N; i++) {
			visited[i] = true;
			comb(visited, i+1, r-1);
			visited[i] = false;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int tc=1; tc<=T; tc++) {
			N = sc.nextInt();
			visited = new boolean[N];
			map = new int[N][N];
			
			for(int j = 0; j<N; j++) {
				for(int i=0; i<N; i++) {
					map[j][i] = sc.nextInt();
				}
			}
			
			comb(visited, 0, N/2);
			System.out.println("#" + tc + " " + min);
			min = Integer.MAX_VALUE;
		}
	}

}

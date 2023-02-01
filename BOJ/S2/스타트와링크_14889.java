package S2;

import java.util.Scanner;

public class 스타트와링크_14889 {

	static int min = Integer.MAX_VALUE;
	static boolean[] visited;
	static int N;
	static int[][] map;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		
		map = new int[N][N];
		visited = new boolean[N];
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		comb(visited, 0, N/2);
		System.out.println(min);
		sc.close();
	}
	
	private static void comb(boolean[] visited, int start, int r) {
		if(r == 0) {
			int[] team1 = new int[N/2];
			int[] team2 = new int[N/2];
			
			for(int i=0, j=0, k=0; i<N; i++) {
				if(visited[i]) team1[j++] = i;
				else team2[k++] = i;
			}
			
			int diff = Math.abs(sumAbility(team1) - sumAbility(team2));
			min = Math.min(min, diff);
	
			return;
		}
		for(int i=start; i<N; i++) {
			visited[i] = true;
			comb(visited, i+1, r-1);
			visited[i] = false;
		}
	}
	
	private static int sumAbility(int[] team) {
		int sum = 0;
		for(int i : team)
			for(int j : team)
				sum += map[i][j];
		return sum;
	}

}

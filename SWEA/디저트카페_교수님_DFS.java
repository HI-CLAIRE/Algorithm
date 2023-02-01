package 모의SW역량테스트;

import java.util.ArrayList;
import java.util.Scanner;

public class 디저트카페_교수님_DFS {
	// 우하 -> 좌하 -> 좌상 -> 우상
	static int[] dr = {1, 1, -1, -1};
	static int[] dc = {1, -1, -1, 1};
	
	static int N;
	static int[][] map;
	static int max;
	
	private static void tour(int or, int oc, int cr, int cc, int d, int cnt, ArrayList<Integer> list) {
		// 다시 출발점으로 돌아온 상황
		if(or == cr && oc == cc && d == 3) {
			if(cnt > max) max = cnt;
			return;
		}
		
		// 유도 조건
		// 1. 기존 방향으로 그대로 가거나 d => d
		// 2. 그 다음 방향으로 꺾어서 가거나 d => d+1
		
		// 1. 기존 방향(d)으로 그대로 가기
		int nr = cr + dr[d];
		int nc = cc + dc[d];
		
		// 경계조건을 만족하면서 기족에 가지 않은 디저트 카페 번호인 경우에만
		// 다음으로 진행 가능
		if(nr>= 0 && nr<=N-1 && nc>=0 && nc<=N-1) {
			if(!list.contains(map[nr][nc])) {
				list.add(map[nr][nc]);
				tour(or, oc, nr, nc, d, cnt+1, list);
				
				// 뒤에서 영향을 미치면 안되므로 초기화를 시켜준다.
				list.remove(list.size()-1);
			}
		}
		
		// 2. 시계방향으로 꺾어서 가기 (d+1)
		// d가 0,1,2인 경우에만 방향을 꺾을 수 있음
		if(d < 3) {
			nr = cr + dr[d+1];	// d+1 방향으로의 다음 위치
			nc = cc + dc[d+1];
			
			if(nr>= 0 && nr<=N-1 && nc>=0 && nc<=N-1) {
				if(!list.contains(map[nr][nc])) {
					list.add(map[nr][nc]);
					tour(or, oc, nr, nc, d+1, cnt+1, list);
					
					list.remove(list.size()-1);
				}
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=1; tc<=T; tc++) {
			N = sc.nextInt();
			map = new int[N][N];
			for(int r=0; r<N; r++) {
				for(int c=0; c<N; c++) {
					map[r][c] = sc.nextInt();
				}
			}
			max = -1;
			
			for(int r=0; r<N; r++) {
				for(int c=0; c<N; c++) {
					// dfs(r,c);
					/*
					 * 재귀함수의 설계
					 * 임의로 주어진 정점에서 다음 정점으로 가기 위해 필요한 정보들
					 * - 현재 위치: (cr, cc) (current)
					 * - 현재 방향: d
					 * 		-> 제일 처음에는 0으로 시작 (0 -> 1 -> 2 -> 3)
					 * 		-> 만약 현재 방향이 d로 주어지면 그 다음 정점을 d 방향으로 계속 가던가
					 * 										d + 1 방향 가면 있음
					 * - 출발지: (or, oc) (origin)
					 * - 지금까지 거쳐간 디저트 카페의 숫자들: ArrayList<Integer>
					 * - 움직인 횟수: cnt
					 */
					tour(r, c, r, c, 0, 0, new ArrayList<Integer>());
				}
			}
			
			System.out.printf("#%d %d\n", tc, max);
		}

	}

}

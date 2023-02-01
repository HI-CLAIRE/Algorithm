package 모의SW역량테스트;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 디저트카페_교수님_BFS {
	// 우하 -> 좌하 -> 좌상 -> 우상
	static int[] dr = {1, 1, -1, -1};
	static int[] dc = {1, -1, -1, 1};
	
	static int N;
	static int[][] map;
	static int max;
	
	// 큐에서 사용하기 위해서 Node 클래스를 만든다.
	public static class Node {
		// 현재 위치
		int r; 
		int c;
		
		int d; 		// 방향
		int cnt;	// 횟수
		ArrayList<Integer> list; // 거쳐온 카페 번호 저장
		
		public Node(int r, int c, int d, int cnt, ArrayList<Integer> list) {
			super();
			this.r = r;
			this.c = c;
			this.d = d;
			this.cnt = cnt;
			this.list = list;
		}
		
		
	}
	
	// 매개변수 : 시작점
	/*
	 * 방문처리는 항상 큐에 집어 넣기 전에
	 * BFS 순서
	 * 1. 비어있는 큐를 만듦
	 * 2. 시작정점을 방문처리 후 && 시작정점을 큐에 집어 넣음
	 * 3. while(!queue.isEmpty) {
	 * 		4. 큐에서 정점 v을 하나 꺼냄
	 * 		5. v에 연결된 w가 있다면 w를 방문처리 후 && 그 정점을 큐에 집어 넣음
	 * 	  }
	 */
	private static void bfs(int R, int C) {
		// 1. 비어 있는 큐를 만듦
		Queue<Node> queue = new LinkedList<>();
		
		// 2. 시작 정점을 큐에 집어 넣음
		queue.offer(new Node(R, C, 0, 0, new ArrayList<Integer>()));
		
		// 3. while(!queue.isEmpty())
		while(!queue.isEmpty()) {
			// 4. 큐에서 정점을 하나 꺼냄
			Node currentNode = queue.poll();
			int r = currentNode.r;
			int c = currentNode.c;
			int d = currentNode.d;
			int cnt = currentNode.cnt;
			ArrayList<Integer> list = currentNode.list;
			
			// 만약에 이 정점이 시작 위치(R, C)와 같고, 방향이 3이라면
			// 목표 지점에 도달한 것임
			if(r==R && c==C && d==3) {
				if(cnt > max) max = cnt;
			}
			
			// 1. 그대로 가거나
			int nr = r + dr[d];
			int nc = c + dc[d];
			if(nr>=0 && nr<=N-1 && nc>=0 && nc<=N-1) {
				if(!list.contains(map[nr][nc])) {
				
					// 새로운 리스트를 만들어서 복사 후 넘김
					ArrayList<Integer> list2 = new ArrayList<>();
					for(int i : list) 
						list2.add(i);
					list2.add(map[nr][nc]);
					
					// 다음 갈 지점을 큐에 집어 넣음
					queue.offer(new Node(nr, nc, d, cnt+1, list2));
				}
			}
			
			// 2. 꺾어서 가거나
			if(d<3) {
				nr = r + dr[d+1];
				nc = c + dc[d+1];
				
				if(nr>=0 && nr<=N-1 && nc>=0 && nc<=N-1) {
					// 새로운 리스트를 만들어서 복사 후 넘김
					ArrayList<Integer> list3 = new ArrayList<>();
					for(int i : list) 
						list3.add(i);
					list3.add(map[nr][nc]);
					
					// 다음 갈 지점을 큐에 집어 넣음
					queue.offer(new Node(nr, nc, d+1, cnt+1, list3));
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
			
			/*
			 * BFS 탐색
			 * 모든 정점이 출발지가 될 수 있다.
			 * (0,0),..(N-1,N-1)
			 * 2중 for문을 돌면서 모든 정점으로부터 BFS 탐색 시작
			 */
			
			for(int r=0; r<N; r++) {
				for(int c=0; c<N; c++) {
					
					bfs(r, c);
				}
			}
			
			System.out.printf("#%d %d\n", tc, max);
		}

	}

}

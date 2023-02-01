package G5;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 스타트링크_5014 {

	static int F,S,G;
	static int[] building;
	static int[] dir = new int[2];
	static boolean[] visited;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		F = sc.nextInt();	// 총 F층으로 이루어진 건물 
		S = sc.nextInt();	// 강호가 있는 위치 
		G = sc.nextInt();	// 스타트링크가 있는 곳의 위치 
		dir[0] = sc.nextInt();	// up
		dir[1] = sc.nextInt() * -1;	// down
		
		building = new int[F+1];	// 빌딩은 1층부터 
		visited = new boolean[F+1];
	
		bfs(S);
		sc.close();
	}

	private static void bfs(int s) {
		Queue<Integer> q = new LinkedList<>();
		
		q.offer(s);
		visited[s] = true;
		building[s] = 0;
		
		while(!q.isEmpty()) {
			int pos = q.poll();
			// 강호가 목표층에 도달했을 때 종료 
			if(pos == G) {
				System.out.println(building[pos]);
				return;
			}
			
			// 위, 아래 탐색 
			for(int i=0; i<2; i++) {
				int next = pos + dir[i];
				
				if(1<=next && next<=F && !visited[next]) {
					visited[next] = true;
					q.offer(next);
					building[next] = building[pos] + 1;
				}
				
			}
		}
		System.out.println("use the stairs");
	}

}

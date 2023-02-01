package S1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class 단지번호붙이기_2667 {
	
	public static class Node {
		int r;
		int c;
		public Node(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
	}

	static int N;
	static int[][] map;
	static boolean[][] visited;
	static int[] dr = {1, 0, -1, 0};
	static int[] dc = {0, 1, 0, -1};
	static ArrayList<Integer> cnt_arr = new ArrayList<Integer>(); 
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visited = new boolean[N][N];
		
		for(int r=0; r<N; r++) {
			String str = br.readLine();
			for(int c=0; c<N; c++) {
				map[r][c] = str.charAt(c) - '0';
			}
		}
		
		int islands = 0;
		for(int r=0; r<N; r++) {
			for(int c=0; c<N; c++) {
				if(!visited[r][c] && map[r][c]==1) {
					bfs(r,c);
					islands++;
				}
			}
		}
		System.out.println(islands);
		
		Collections.sort(cnt_arr);
		
		for(int i : cnt_arr) {
			System.out.println(i);
		}
		
	}
	
	private static void bfs(int R, int C) {
		Queue<Node> q = new LinkedList<>();
		
		visited[R][C] = true;
		q.offer(new Node(R,C));
		int cnt = 1;
		
		while(!q.isEmpty()) {
			
			Node now = q.poll();
			int r = now.r;
			int c = now.c;
			
			for(int d=0; d<4; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				
				if(nr>=0 && nr<N && nc>=0 && nc<N && !visited[nr][nc] && map[nr][nc]==1) {
					visited[nr][nc] = true;
					cnt++;
					q.offer(new Node(nr, nc));
				}
				
			}
		}
		cnt_arr.add(cnt);
		
	}
	
}

/*
 * 반례

3
101
010
101

7
1110101
0110101
1110101
0000111
0100000
0111110
0111001

5
10101
01111
11111
01011
10111

25
1100110011001100110011000
0011001100110011001100110
1100110011001100110011000
0011001100110011001100110
1100110011001100110011000
0011001100110011001100110
1100110011001100110011000
0011001100110011001100110
1100110011001100110011000
0011001100110011001100110
1100110011001100110011000
0011001100110011001100110
1100110011001100110011000
0011001100110011001100110
1100110011001100110011000
0011001100110011001100110
1100110011001100110011000
0011001100110011001100110
1100110011001100110011000
0011001100110011001100110
0011001100110011001100110
1100110011001100110011000
0011001100110011001100110
1100110011001100110011000
0011001100110011001100110




 */

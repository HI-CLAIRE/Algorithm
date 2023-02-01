package 모의SW역량테스트;

import java.util.Scanner;

public class 디저트카페_0927 {

	static int N;
	static int[][] map;
	
	// 시계방향 (동 -> 남 -> 서 -> 북)
	static int[] dx = {1, -1, -1, 1};
	static int[] dy = {-1, -1, 1, 1};
	static int min;
	
	private static boolean isOk(int y, int x, int d) {
		int ny = y + dy[d];
		int nx = x + dx[d];
		
		
		return true;
	}
	
	// 시작점은 양쪽 끝을 뺀 절반만큼만( (0,1)(0,2)(1,1)(1,2) )
	// 1. 직진할지 2. 방향을 꺽을지
	// 가는 길에 똑같은 desert 있으면 돌아가기
	// 경계선을 만나면 방향 틀기
	// 매개변수 : 시작하는 가게 좌표
	private static void route(int y, int x, int d) {
		// 종료조건?
		// 투어를 마치고 (시작가게 == 마지막가게) 일때
		
		int ny = y + dy[d];
		int nx = x + dx[d];
		
		if(nx >= N || ny >= N || nx < 0 || ny < 0)
			d = (d + 1) % 4;
		
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int tc=1; tc<=T; tc++) {
			N = sc.nextInt();
			map = new int[N][N];
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			
			min = Integer.MAX_VALUE;
			for(int i=0; i<N; i++) {
				for(int j=1; j<=N-2; j++) {
					route(i, j, 0);
				}
			}
		}
		sc.close();
	}

}

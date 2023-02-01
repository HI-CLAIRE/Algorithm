package G5;

import java.util.Scanner;

public class 파이프옮기기1_17070 {
	/*
	public static int[][] map;	// 지도 저장
	public static int cnt ;		// 경우의 수
	public static int N;		// 정사각형
	
	// 움직이는 함수
	// 현재 상태 && 현재 위치
	// 가로 = 0, 세로 = 1, 대각선 = 2
	public static void move(int y, int x, int status) {
		// 종료조건
		// x 랑 y 가 둘 다 N이 됐을 때 cnt++ 하고 return
		if(x == N-1 && y == N-1) {
//			System.out.println(cnt);
			cnt++;
			return;
		}
		
		// 재귀
		// 순서대로 1, 2, 3 함수 들렸다가 안 되면 다음 함수로 
		// 더이상 갈 진행할 수 있는 함수가 없다면 종료
		
		// 0. 가로
		if(x+1 < N && status != 1 && map[y][x+1] != 1) {
//			System.out.println("가로");
//			System.out.println("[" + y + ", "+ x + "]");
			move(y, x+1, 0);
		}
		// 1. 세로
		if(y+1 < N && status != 0 && map[y+1][x] != 1) {
//			System.out.println("세로");
//			System.out.println("[" + y + ", "+ x + "]");
			move(y+1, x, 1);
		}
		// 2. 대각선
		if(x+1<N && y+1<N && map[y][x+1] != 1 && map[y+1][x] != 1 && map[y+1][x+1] != 1) {
//			System.out.println("대각선");
//			System.out.println("[" + y + ", "+ x + "]");
			move(y+1, x+1, 2);
		}
	}
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		map = new int[N][N];
		
		for(int j=0; j<N; j++) {
			for(int i=0; i<N; i++) {
				map[j][i] = sc.nextInt();
			}
		}
		
		move(0, 1, 0);
		System.out.println(cnt);
		
	}
	*/
	static int N;
	static int[][] map;
	static int cnt;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map = new int[N + 1][N + 1]; // N+1 크기로 만들어서 1부터 N까지 인덱스를 사용.
		cnt = 0;

		for (int r = 1; r <= N; r++) {
			for (int c = 1; c <= N; c++) {
				map[r][c] = sc.nextInt();
			}
		}

		// 기억해야 하는 상태
		// r: 행좌표, c: 열좌표, dir: 파이프의 방향
		// 방향 dir
		// 1 - 가로
		// 2 - 세로
		// 3 - 대각선

		// 재귀함수의 시작.
		// 현재 위치 (1, 2), 가로 방향인 상황에서
		// 다음 상황으로 전이시키는 함수
		movePipe(1, 2, 1);
		// ..
		// movePipe(N, N, ?);
		System.out.println(cnt);

	}

	private static void movePipe(int r, int c, int dir) {
		// 기저조건
		if (r == N && c == N) {
			cnt++;
			return;
		}

		// 유도조건
		// 1. 현재 방향 dir
		// 2. 갈수 있는 방향으로 갈수 있다면 재귀 호출
		if (dir == 1) { // 가로
			// 가로로 갈 수 있다면 가로로 감
			if (c + 1 <= N && map[r][c + 1] == 0)
				movePipe(r, c + 1, 1);

			// 대각선으로도 갈 수 있다면 대각선으로 감
			if (r + 1 <= N && c + 1 <= N && map[r + 1][c] == 0 && map[r][c + 1] == 0 && map[r + 1][c + 1] == 0)
				movePipe(r + 1, c + 1, 3);

		} else if (dir == 2) { // 세로
			// 세로로 갈 수 있다면 세로로 감
			if (r + 1 <= N && map[r + 1][c] == 0)
				movePipe(r + 1, c, 2);

			// 대각선으로도 갈 수 있다면 대각선으로 감
			if (r + 1 <= N && c + 1 <= N && map[r + 1][c] == 0 && map[r][c + 1] == 0 && map[r + 1][c + 1] == 0)
				movePipe(r + 1, c + 1, 3);

		} else if (dir == 3) { // 대각선
			// 가로로 갈 수 있다면 가로로 감
			if (c + 1 <= N && map[r][c + 1] == 0)
				movePipe(r, c + 1, 1);
			
			// 세로로 갈 수 있다면 세로로 감
			if (r + 1 <= N && map[r + 1][c] == 0)
				movePipe(r + 1, c, 2);

			// 대각선으로도 갈 수 있다면 대각선으로 감
			if (r + 1 <= N && c + 1 <= N && map[r + 1][c] == 0 && map[r][c + 1] == 0 && map[r + 1][c + 1] == 0)
				movePipe(r + 1, c + 1, 3);
		}

	}
}

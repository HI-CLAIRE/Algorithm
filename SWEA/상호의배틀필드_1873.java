package IM대비SWEA;

import java.util.Scanner;

public class 상호의배틀필드_1873 {

	static int H, W, d;
	static char[][] map;
	static int[] pos = new int[2];
	static int[] dr = {-1, 1, 0, 0}; // 상 하 좌 우
	static int[] dc = {0, 0, -1, 1};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt(); 
		for(int tc=1; tc<=T; tc++) {
			H = sc.nextInt();
			W = sc.nextInt();
			
			map = new char[H][W];
			for(int r=0; r<H; r++) {
				String str = sc.next();
				for(int c=0; c<W; c++) {
					map[r][c] = str.charAt(c);
					// 방향이랑 탱크의 포지션을 저장해준다.
					if(map[r][c] == '^' || map[r][c] == 'v' || map[r][c] == '<' || map[r][c] == '>') {
						pos[0] = r;
						pos[1] = c;
						switch(map[r][c]) {
							case '^' : d=0;
								break;
							case 'v' : d=1;
								break;
							case '<' : d=2; 
								break;
							case '>' : d=3;
								break;
						}
					}
				}
			}
			
			int n = sc.nextInt();
			String console = sc.next();
							
			for(int i=0; i<n; i++) {
				char action = console.charAt(i);
				switch(action) {
					case 'U' : d=0; move(d);
						break;
					case 'D' : d=1; move(d);
						break;
					case 'L' : d=2; move(d);
						break;
					case 'R' : d=3; move(d);
						break;
					case 'S' : shoot(d);
				}
			}
			
			printer(tc);
		}
	}

	// 벽돌(*) -> 평지(.) (이동가능)
	// 강철(#) -> 강철 (이동불가능)
	// 물(-)			(이동불가능)
	
	public static void move(int d) {
		
		map[pos[0]][pos[1]] = tank(d);
		
		int nr = pos[0] + dr[d];
		int nc = pos[1] + dc[d];
		
		if(nr<0 || nc<0 || nr>=H || nc>=W || map[nr][nc]!='.') return;
		
		// 움직인 칸에 현재 위치 삽입
		map[nr][nc] = map[pos[0]][pos[1]];
		map[pos[0]][pos[1]] = '.';
		
		pos[0] = nr;
		pos[1] = nc;
		
	}
	
	public static void shoot(int d) {
		int i = 1;

		while(true) {

			int nr = pos[0] + dr[d] * i;
			int nc = pos[1] + dc[d] * i;

			// 범위를 벗어나면 종료
			if(nr<0 || nc<0 || nr>=H || nc>=W) return;

			// 움직인 칸이 강철이면 바로 아무 변화 없음
			if(map[nr][nc] == '#') return;
			
			// 벽돌(*)이면 평지(.)로 바꾸기 
			else if(map[nr][nc] == '*') {
				map[nr][nc] = '.';
				return;
			}
			
			i++;
		}
		
	}
	
	private static void printer(int tc) {
		StringBuilder sb = new StringBuilder();
		
		sb.append("#").append(tc).append(" ");
		
		for(int i=0; i<H; i++) {
			for(int j=0; j<W; j++) {
				sb.append(map[i][j]);
			}
			sb.append("\n");
		}
		System.out.print(sb.toString());
	}
	
	private static char tank(int d) {
		if(d == 0) return '^';
		else if(d == 1) return 'v';
		else if(d == 2) return '<';
		else if(d == 3) return '>';
		return 0;
	}
	
}

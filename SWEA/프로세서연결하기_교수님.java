package 모의SW역량테스트;

import java.util.ArrayList;
import java.util.Scanner;

public class 프로세서연결하기_교수님 {

	static int N;
	static int[][] arr;
	static ArrayList<int[]> coreToLink;
	
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	static int maxCnt;
	static int minLength;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=1; tc<=T; tc++) {
			N = sc.nextInt();
			arr = new int[N][N];
			coreToLink = new ArrayList<>();
			
			for(int r=0; r<N; r++) {
				for(int c=0; c<N; c++) {
					arr[r][c] = sc.nextInt();
					if(arr[r][c] == 1 &&
							r!=0 && r!=N-1 && c!=0 && c!=N-1) {
						coreToLink.add(new int[] {r,c});
					}
				}
			} 
			
			maxCnt = Integer.MIN_VALUE;
			minLength = Integer.MIN_VALUE;
			/*
			 재귀함수
			 coreToLink에 저장된 코어를 하나씩 가장자리에 연결하는 재귀함수
			 예를 들어, 리스트레 코어 5개가 있는 경우
			 재귀함수 이름 : LinkCore(idx)
			 LinkCore(0) : 0번 코어를 연결하고 다음(idx + 1) 함수 호출
				->LinkCore(1) : 1번 코어 연결 후 다음 호출
					-> LinkCore(2)
						...
							-> LinkCore(5) : 종료
							
			  idx번째 연결하는 경우
			  	- 연결 X: 연결 카운트가 증가 X
			  	- 위: 연결 카운트가 증가
			  	- 아래: 연결 카운트가 증가
			  	- 좌: 연결 카운트가 증가
			  	- 우: 연결 카운트가 증가
			*/
			linkCore(0, 0);
			System.out.printf("#%d %d", tc, minLength);
		}
	}
		
	private static void linkCore(int idx, int cnt) {
		// 기저 조건
		if(idx == coreToLink.size()) {
			// 각 경우의 수마다 전선의 길이를 구해야 함
			int length = wireLength();
			// 최대 연결수가 발견된다면, 업데이트.
			if( cnt > maxCnt) {
				maxCnt = cnt;
				minLength = length;
			}
			// 최대연결수와 같고, 더 작은 길이가 발견된다면
			// 길이 갱신
			if( cnt == maxCnt) {
				if(length < minLength) {
					minLength = length;
				}
			}
			
			return;
		}
		
		// 유도 조건
		// 1. 연결 안하고 x, 상하좌우(2345 - for문)
		
		// 1. 연결 안하고 다음 코어 연결하러 가기
		linkCore(idx+1, cnt);
		
		// 현재 코어의 위치
		int[] core = coreToLink.get(idx);
		int r = core[0];
		int c = core[1];
		
		// 2~5. 상하좌우
		for(int d=0; d<4; d++) {
			// 해당 방향으로 연결할 수 있으면
			   // 현재 코어의 위치 -> 해당 방향으로 탐색
			if(isAvailable(r, c, d)) { // 연결할 수 있다면
				putWire(r, c, d, 2);
				// 연결하고 -> 그 다음 연결하러 가기
				linkCore(idx+1, cnt+1);
				// 초기화
				putWire(r, c, d, 0);
			}
						
		}
		
	}

	// 전선의 길이를 구하는 함수
	// 2의 개수를 센다.
	private static int wireLength() {
		int cnt = 0;
		for(int r=0; r<N; r++) {
			for(int c=0; c<N; c++) {
				if(arr[r][c] == 2) cnt++;
			}
		}
		return cnt;
	}


	// r, c에서 출발해서, d 방향으로 숫자를 채워넣는 함수
	// 2로 채워넣으면 전선을 놓는 것이고
	// 0으로 다시 채워 넣으면 전선을 지우는 것임.
	private static void putWire(int r, int c, int d, int n) {
		int nr = r + dr[d];
		int nc = c + dc[d];
		
		while(true) {
			// 그 다음칸이 경계 밖을 벗어났다면 더 이상 검사할 필요가 없음.
			if(nr < 0 || nr > N-1 || nc < 0 || nc > N-1 ) {
				break;
			}
			
			// 그 다음칸을 숫자 n으로 채워넣음.
			arr[nr][nc] = n;

			// 그 다음칸을 확인하러 감
			nr += dr[d];
			nc += dc[d];
		}
		
	}


	// r, c에서 출발해서, d 방향으로 전선을 놓을 수 있는지 여부.
	private static boolean isAvailable(int r, int c, int d) {
		// (r,c)의 다음 칸부터 검사 시작
		int nr = r + dr[d];
		int nc = c + dc[d];
		while(true) {
			// 그 다음칸이 경계 밖을 벗어났다면 더 이상 검사할 필요가 없음.
			if(nr < 0 || nr > N-1 || nc < 0 || nc > N-1 ) {
				break;
			}
			// 그 다음칸이 빈칸이 아니라면
			if(arr[nr][nc] != 0) {
				return false; // 연결할 수 없음
			}
			// 그 다음칸을 확인하러 감
			nr += dr[d];
			nc += dc[d];
		}
		// 경계 밖으로 벗어날 때까지 모두 0이라면
		return true; // 연결할 수 있음
	}

}

package 모의SW역량테스트;

import java.util.Scanner;

public class 보호필름_교수님 {

	static int D, W, K;
	static int[][] arr;
	static int min;
	static int[] layerA, layerB;
	
	private static void process(int idx, int cnt) {
		if(idx == D) {
			if(check()) {	// 검사를 통과했다면
				// 약품 처리 횟수의 최솟값을 갱신
				if(cnt < min) min = cnt;
			}
			return;
		}
		
		// min : 임시최적해
		// cnt >= min : 더이상 탐색할 의미가 없음
		if(cnt >= min) return;
		// 가지치기를 하려면 유도 조건의 순서도 중요
		// ex) A 처리, B 처리, 처리 x
		
		// 유도조건
		// - 3가지 : 처리 x, A 처리, B 처리
		
		// 지금 현재 idx번째의 막의 상태를 임시 저장
		int[] tmp = arr[idx];
		
		// 처리 x
		process(idx+1, cnt);
		
		// A 처리
		arr[idx] = layerA;
		process(idx+1, cnt+1);
		
		// B 처리
		arr[idx] = layerB;
		process(idx+1, cnt+1);
		
		// 행렬 복원
		arr[idx] = tmp;
	}
	
	private static boolean check() {
		/*
		 	열을 고정하고 행을 0부터 D-1까지 내려가면서
		 	같은 것의 갯수를 셈
		 	같은 것이 연속되는 것이 K개 이상인지??
		*/
		
		for(int c=0; c<W; c++) {
			int cnt = 1;
			int max = 0; // cnt의 최댓값, K개 이상이면 됨
			for(int r=0; r<D-1; r++) {
				if(arr[r][c] == arr[r+1][c]) // r, r+1이 같다면
					cnt++;	// 갯수를 늘려주고
				else	// r, r+1 다르다면 
					cnt = 1;	// cnt 초기화
				
				// 항상 같은 경우만 있는 것이 아님
				if(cnt > max) max = cnt;	//최댓값 갱신
			}
			if(max < K) return false;	// 하나라도 K보다 작은 열이 있으면 false
		}
		return true;	//모든 열이 K 이상이므로 true
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int tc = 1; tc<=T; tc++) {
			D = sc.nextInt();
			W = sc.nextInt();
			K = sc.nextInt();
			
			arr = new int[D][W];
			layerA = new int[W];
			layerB = new int[W];
			
			for(int i=0; i<W; i++)
				layerB[i] = 1;
			
			min = Integer.MAX_VALUE;
			for(int i=0; i<D; i++) {
				for(int j=0; j<W; j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			/*
			 재귀함수 호출
			 막(행)이 D개가 있음
			 0,1,2,...,D-1
			
			 먼저 idx에 대해서 작업을 수행하고, idx+1번째 작업을 호출
			 process(idx)
			 시작 호출: process(0) : 0번 막에 대해서 작업 수행 후, 다음 호출
				-> process(1) : 1번 막에 대해서 작업 수행 후, 다음 호출
					-> process(2)
						...
						-> process(D-1)
							-> process(D) : idx == D 이므로 종료.
			각 작업은
				1. 처리를 안함 : 약품 사용 횟수 증가 x
				2. A를 처리 : 약품 사용 횟수 증가
				3. B를 처리 : 약품 사용 횟수 증가
					=> 약품 사용 횟수를 저장하기 위해 파라미터 cnt 추가
			 process(idx, cnt);
			 시작 : process(0, 0) : 0번 작업을 수행하고, 다음 호출
			 	만약 약품 처리를 안 했으면 -> process(1,0) 호출
			 	A 약품 처리했으면 -> process(1,1);
			 	B 약품 처리했으면 -> process(1,1);
			
			*/
			process(0, 0);
			
			System.out.printf("#%d %d\n", tc, min);
		}
	}
	
	
}

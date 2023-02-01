package 모의SW역량테스트;

import java.util.Scanner;

public class 요리사_교수님 {

	static boolean[] selected;
	static int N;	// N개 중에서 
	static int R;	// R개를 뽑는 조합
	static int[][] arr; // 시너지 배열 
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=1; tc<=T; tc++) {
			
		}
		
		
		
		comb(0, 0);
	}

	// 조합.
	
	
	// N개에서 R개 뽑는 조합 
	// comb 함수
	// comb(idx, startIdx);
	// 2개를 뽑는 조합 -> idx: 0,1
	// 3개를 뽑는 조합 -> idx: 0,1,2
	// startIdx: 어디서부터 시작해서 뽑을 수 있는지 정해주는 것 
	private static void comb(int idx, int startIdx) {
		// 기저조건 
		if(idx == R) {
			int sumA = 0;
			
			int sumB = 0;
			
			return;
		}
		
		// 유도조건 
		for(int i=startIdx; i<N; i++) {
			selected[i] = true;
			comb(idx + 1, i+1);
			selected[i] = false;
		}
	}
}

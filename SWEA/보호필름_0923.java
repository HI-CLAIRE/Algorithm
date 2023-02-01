package 모의SW역량테스트;

import java.util.Scanner;

public class 보호필름_0923 {

	static int[][] film;
	static int D, K, W;
	
	// 약품 투입 메소드
	private static void putMed(int[] row, int med) {
		for(int i : row) {
			i = med;
		}
	}
	
	// 성능 검사할 메소드
	// 세로 줄을 넘겨주면 동일한 특성을 지닌 셀이 3개 이상 연속으로 있는지 판별
	private static boolean checkCols(int[] col) {
		int flag = 0, cnt = 0;
		for(int i : col) {
			if(i==0 && flag == 1) {
				flag = 0;
				cnt = 1;
			}
			else if(i==1 && flag==0) {
				flag = 1;
				cnt = 1;
			}
			else cnt++;
		}
		if(cnt >= 3) return true;
		else return false;
	}
	
	// 재귀를 돌리면서 검사해볼 메소드..?
	private static void checkFilm(int depth) {
		if(depth == D) {
			
		}
	}
	
	public static void main(String[] args) {
		Scanner sc  = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int tc=1; tc<=T; tc++) {
			D = sc.nextInt();
			W = sc.nextInt();
			K = sc.nextInt();
			film = new int[D][W];
			tmp = new int[D][W];
			for(int j=0; j<D; j++) {
				for(int i=0; i<W; i++) {
					film[j][i] = sc.nextInt();
				}
				
			}
		}
		sc.close();
	}
}

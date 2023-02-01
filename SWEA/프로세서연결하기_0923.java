package 모의SW역량테스트;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 프로세서연결하기_0923 {

	static int N;
	static int[][] map;
	static List<int[]> core = new ArrayList<int[]>();
	
	// 백트래킹
	
	// 현재 코어의 좌표를 가지고 그 자리가 유망한지 확인
	// 갈 수 없는 곳 -> 경계선 밖, 1(core), 2(전선)
	static boolean isOk(int x, int y) {
		for(int i=0; i<N; i++) {
			if(map[y][i] != 0) return false;
			if(map[i][x] != 0) return false;
		}
		return true;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int tc=1; tc<=T; tc++) {
			N = sc.nextInt();
			core = new ArrayList<>();
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					map[i][j] = sc.nextInt();
					if(map[i][j] == 1)
						core.add(new int[] {i,j});
				}
			}
		}

	}

}

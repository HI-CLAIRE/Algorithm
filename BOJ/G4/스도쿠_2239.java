package G4;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 스도쿠_2239 {
	
	static int[][] map = new int[9][9];
	static List<int[]> blanks = new ArrayList<>();
	
	private static boolean isOk(int x, int y, int num) {
		for(int i=0; i<9; i++) {
//			System.out.println("직선");
			if(map[y][i] == num) return false;
			if(map[i][x] == num) return false;
		}
		
		int startX = (x / 3) * 3;
		int startY = (y / 3) * 3;
		for(int j=startY; j<startY+3; j++) {
			for(int i=startX; i<startX+3; i++) {
				if(map[j][i] == num) {
//					System.out.println("사각형");
					return false;
					
				}
			}
		}
		return true;
	}
	
	private static boolean sudoku(int i) {
//		System.out.println(i);
		if(i == blanks.size()) {
			return true;
		}
		
		// 빈칸의 현재 좌표에 1~9까지 넣어보면서 가능하면
		// 다음 빈칸 확인
		int y = blanks.get(i)[0];
		int x = blanks.get(i)[1];
		for(int num=1; num<=9; num++) {
			//System.out.println("여기");
			if(isOk(x, y, num)) {
				
				map[y][x] = num;
				if(sudoku(i + 1))
					return true;
				map[y][x] = 0;
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int i=0; i<9; i++) {
			String line = sc.next();
			for(int j=0; j<9; j++) {
				int k = line.charAt(j) - '0';
				map[i][j] = k;
				if(map[i][j] == 0)
					blanks.add(new int[] {i, j});
			}
		}
		sudoku(0);
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<9; i++) {
			for(int j=0; j<9; j++) {
				sb.append(map[i][j]);
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
	/*
035469278
782105609
060278135
321046897
804913506
596820413
917652080
603701952
258394760
*/

}

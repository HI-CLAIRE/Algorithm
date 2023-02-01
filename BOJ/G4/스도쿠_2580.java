package G4;

import java.util.ArrayList;
import java.util.Scanner;

public class 스도쿠_2580 {

	// 빈칸의 x, y 좌표 
	static class Pos {
		int y, x;
		
		public Pos(int y, int x) {
			this.y = y;			
			this.x = x;
		}
	}
	
	static int[][] board = new int[9][9];
	static ArrayList<Pos> blanks = new ArrayList<>();  

	// 가능한 자리인지 확인하는 함수
	// 인자 : 빈칸의 현재 좌표, 1~9(스도쿠를 채울 숫자) 
	static boolean isOk(int y, int x, int num) {
		// 1. 가로 && 2. 세로 
		for(int i=0; i<9; i++) {
			if(board[y][i] == num) return false;
			if(board[i][x] == num) return false;
		}
		
		// 3. 사각형 
		int startY = (y/3) * 3;
		int startX = (x/3) * 3;
		
		for(int j = startY; j < startY + 3; j++) {
			for(int i = startX; i < startX + 3; i++) {
				if(board[j][i] == num)
					return false;
			}
		}
		return true;
	}
	
	// 백트래킹으로 스도쿠를 채울 수 있는지 확인
	// 빈칸을 다 확인했으면 스도쿠를 종료한다.
	private static boolean sudoku(int cnt) {
		if(cnt == blanks.size()) 
			return true;

		int y = blanks.get(cnt).y;
		int x = blanks.get(cnt).x;
		
		// 현재 cnt의 빈칸 뽑기
		for(int num=1; num<=9; num++) {
			if(isOk(y, x, num)) {
				board[y][x] = num;
				if(sudoku(cnt + 1))
				 return true;
				board[y][x] = 0;
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		for(int i=0; i<9; i++) {
			for(int j=0; j<9; j++) {
				board[i][j] = sc.nextInt();
				if(board[i][j] == 0) {
					blanks.add(new Pos(i, j));
				}
			}
		}

		sudoku(0);

		StringBuilder sb = new StringBuilder();
		for(int i=0; i<9; i++) {
			for(int j=0; j<9; j++) {
				sb.append(board[i][j]).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
		sc.close();
	}

}

package G4;

import java.util.Scanner;

public class nQueen_9663 {

	static int[] board;
	static int N;
	static int ans;
	
	private static boolean isOk(int idx) {
		for(int i=0; i<idx; i++) {
			if(board[idx] == board[i])
				return false;
			else if (Math.abs(board[idx] - board[i]) == Math.abs(idx - i))
				return false;
		}
		return true;
	}
	
	private static void nQueens(int idx) {
		if(idx == N) {
			ans++;
			return;
		}
		for(int i=0; i<N; i++) {
			board[idx] = i;
			if(isOk(idx))
				nQueens(idx + 1);
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		board = new int[N];
		ans = 0;
		nQueens(0);
		System.out.printf("%d\n", ans);
		sc.close();
	}
}

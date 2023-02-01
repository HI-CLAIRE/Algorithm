package S1;

import java.util.Scanner;

public class 연산자끼워넣기_14888 {

	static int[] ops;
	static int[] numbers;
	static int N;
	static int max = Integer.MIN_VALUE;
	static int min = Integer.MAX_VALUE;
	
	private static int doOp(int i, int res, int next) {
		switch(i) {
		case 0: 
			res += numbers[next];
			break;
		case 1:
			res -= numbers[next];
			break;
		case 2:
			res *= numbers[next];
			break;
		case 3:
			res /= numbers[next];
		}
		return res;
	}
	
	// 연산자가 가능한 순열을 뽑아내는 메소드
	private static void perm(int depth, int res) {
		if(depth == N-1) {
			max = Math.max(max, res);
			min = Math.min(min, res);
			return;
		}
		for(int i=0; i<4; i++) {
			if(ops[i] != 0) {
				ops[i]--;
				perm(depth+1, doOp(i, res, depth + 1));
				ops[i]++;
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		numbers = new int[N];
		for(int i=0; i<N; i++)
			numbers[i] = sc.nextInt();
		ops = new int[4];
		for(int i=0; i<4; i++)
			ops[i] = sc.nextInt();			
			
		perm(0, numbers[0]);
		System.out.println(max);
		System.out.println(min);
		sc.close();
	}
}

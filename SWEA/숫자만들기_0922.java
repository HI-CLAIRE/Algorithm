package 모의SW역량테스트;

import java.util.Scanner;

public class 숫자만들기_0922 {

	static int[] ops;
	static int[] numbers;
	static int N;
	static int max = Integer.MIN_VALUE;
	static int min = Integer.MAX_VALUE;
	
	private static int doOp(int i, int res, int next) {
//		System.out.printf("res : %d\n", res);
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
//			System.out.printf("max : %d, min : %d\n", max, min);
			return;
		}
		for(int i=0; i<4; i++) {
			if(ops[i] != 0) {
				ops[i]--;
//				System.out.println(depth+" 깊이에서 "+i+"를 실행"+" 현재 값 : "+ res);
				perm(depth+1, doOp(i, res, depth + 1));
				ops[i]++;
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int tc=1; tc<=T; tc++) {
			N = sc.nextInt();
			ops = new int[4];
			for(int i=0; i<4; i++)
				ops[i] = sc.nextInt();
			
			numbers = new int[N];
			for(int i=0; i<N; i++)
				numbers[i] = sc.nextInt();
			
			perm(0, numbers[0]);
			
//			System.out.printf("max : %d, min : %d\n", max, min);
			System.out.printf("#%d %d\n", tc, max - min);
			max = Integer.MIN_VALUE;
			min = Integer.MAX_VALUE;
		}
		sc.close();
	}
}

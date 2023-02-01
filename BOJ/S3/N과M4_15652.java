package S3;

import java.util.Scanner;

public class N과M4_15652 {

	static int[] arr;
	static int N, r;
	
	static StringBuilder sb = new StringBuilder();
	
	public static void perm(int start, int depth) {
		if(depth == r) {
			for(int i : arr) 
				sb.append(i).append(" ");
			sb.append("\n");
			return;
		}
		
		for(int i=start; i<=N; i++) {
			arr[depth] = i;
			perm(i, depth + 1);
		}
	}

	public static void main(String[] args) {
		// 순열
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		r = sc.nextInt();
		arr = new int[r];
		
		perm(1, 0);
		System.out.print(sb.toString());
		sc.close();
	}

}

package S3;

import java.util.Scanner;

public class N과M3_15651 {

	static int[] arr, out;
	static int N, r;
	
	static StringBuilder sb = new StringBuilder();
	
	public static void perm(int depth) {
		if(depth == r) {
			for(int i : out)
				sb.append(i).append(" ");
			sb.append("\n");
			return;
		}
		
		for(int i=0; i<N; i++) {
			out[depth] = arr[i];
			perm(depth + 1);
		}
	}

	public static void main(String[] args) {
		// 순열
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		r = sc.nextInt();
		arr = new int[N];
		out = new int[r];	
		for(int i=1; i<=N; i++) {
			arr[i-1] = i;
		}
		
		perm(0);
		System.out.print(sb.toString());
	}

}

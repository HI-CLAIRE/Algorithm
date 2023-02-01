package SWEA;

import java.util.Scanner;
import java.util.StringTokenizer;

public class 중위순회 {

	static char[] tree;
	static int N;
	static StringBuilder sb;
	
	static void inOrder(int idx) {
		if(idx > N) return;
		
		inOrder(idx * 2);
		sb.append(tree[idx]);
		inOrder(2 * idx + 1);
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sb = new StringBuilder();      // 초기화
		for(int tc=1; tc<=10; tc++) {
			
			N = sc.nextInt();
			sc.nextLine();          // 아하
			
			tree = new char[N+1];
			for(int i=1; i<=N; i++) {
				StringTokenizer st = new StringTokenizer(sc.nextLine());
				String num = st.nextToken();        // 노드의 번호
				tree[i] = st.nextToken().charAt(0); // 1개의 문자
			}
			sb.append("#").append(tc).append(" ");
			inOrder(1);
			sb.append("\n");
		}
		System.out.println(sb.toString());
		sc.close();
	}
}

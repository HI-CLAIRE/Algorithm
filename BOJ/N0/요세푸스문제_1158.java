package BOJ;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 요세푸스문제_1158 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		Queue<Integer> q = new LinkedList<Integer>();
		
		StringBuilder sb = new StringBuilder();
		
		int T = sc.nextInt();
		int N = sc.nextInt();
		
		for(int i=1; i<=T; i++)
			q.offer(i);
		
		sb.append("<");
		
		while(q.size() > 1) {
			for(int i=0; i<N-1; i++) {
				int num = q.poll();
				q.offer(num);
			}
			sb.append(q.poll()).append(", ");
		}
		sb.append(q.poll()).append(">");
		System.out.println(sb);
		
		sc.close();
	}

}

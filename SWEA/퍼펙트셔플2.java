package SWEA;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 퍼펙트셔플2 {

	public static void main(String[] args) {
Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int tc=1; tc<=T; tc++) {
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(tc).append(" ");
			
			int N = sc.nextInt();
			Queue<String> q1 = new LinkedList<>();
			Queue<String> q2 = new LinkedList<>();
			if(N%2 == 0) {
				for(int i=0; i<N/2; i++)
					q1.add(sc.next());
				for(int i=N/2; i<N; i++)
					q2.add(sc.next());
			}
			else {
				for(int i=0; i<N/2+1; i++)
					q1.add(sc.next());
				for(int i=N/2+1; i<N; i++)
					q2.add(sc.next());
			}
			System.out.println(q1);
			System.out.println(q2);
			
			for(int i=0; i<N; i++) {
				if(i%2 == 0) sb.append(q1.poll()).append(" ");
				else sb.append(q2.poll()).append(" ");
			}
			System.out.println(sb);
		}
		sc.close();
	}
}

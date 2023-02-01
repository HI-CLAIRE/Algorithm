package SWEA;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class 힙 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int tc=1; tc<=T; tc++) {
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(tc);
			int n = sc.nextInt();
			
			PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
			for(int i=1; i<=n; i++) {
				int cal = sc.nextInt();
				if(cal == 2) {
					if(pq.isEmpty()) sb.append(" ").append("-1");
					else sb.append(" ").append(pq.poll());
				} else pq.offer(sc.nextInt());
			}
			System.out.println(sb.toString());
		}

	}

}

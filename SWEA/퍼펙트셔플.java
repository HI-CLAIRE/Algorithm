package SWEA;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 퍼펙트셔플 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int tc=1; tc<=T; tc++) {
				int N = sc.nextInt();
				Queue<String> q = new LinkedList<>();
				for(int i=0; i<N; i++) {
					q.offer(sc.next());
				}
				
				Queue<String> a = new LinkedList<>();
				Queue<String> b = new LinkedList<>();
				
				int middle = (N%2 == 0)? N/2 : N/2 + 1;
				for(int i=0; i<middle; i++) {
					a.offer(q.poll());
				}
				while(!q.isEmpty()) {
					b.offer(q.poll());
				}
				
				while(!a.isEmpty() || !b.isEmpty()) {
					if(!a.isEmpty()) q.offer(a.poll());
					if(!b.isEmpty()) q.offer(b.poll());
				}
				StringBuilder sb = new StringBuilder();
				sb.append("#").append(tc);
				while(!q.isEmpty()) {
					sb.append(" ").append(q.poll());
				}
				
				System.out.println(sb);
		}
	}
}

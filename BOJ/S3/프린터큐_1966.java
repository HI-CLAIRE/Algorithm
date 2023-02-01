package S3;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 프린터큐_1966 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int i=0; i<T; i++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			
			Queue<int[]> q = new LinkedList<int[]>();
			
			for(int j=0; j<N; j++) {
				q.offer(new int[] {j, sc.nextInt()});
			}
			
			int cnt = 0;
			while(true) {
				int[] now = q.poll();
				boolean flag = true;
				
				for(int[] cmp : q) {
					if(cmp[1] > now[1]) {
						flag = false;
						break;
					}
				}
				
				if(flag) {
					cnt++;
					if(now[0] == M) break;
				}
				else q.offer(now);
			}
			System.out.println(cnt);
		}
		

	}

}

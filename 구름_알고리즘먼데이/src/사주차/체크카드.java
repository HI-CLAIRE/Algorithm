package 사주차;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 체크카드 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		Queue<Integer> q = new LinkedList<>();
		
		int ans = N;
		
		for(int m=1; m<=M; m++) {
			String str = sc.next();
			if(str.equals("deposit")) {
				ans += sc.nextInt();
				
			} else if(str.equals("pay")) {
				int tmp = sc.nextInt();
				if(tmp > ans) {
					continue;
				} else {
					ans -= tmp;
				}
			} else if(str.equals("reservation")) {
				int tmp = sc.nextInt();
				if(tmp > ans) {
					q.add(tmp);
					continue;
				} else {
					if(!q.isEmpty())
						ans -= q.poll();
				}
			}
		}
		System.out.println(ans);

	}

}

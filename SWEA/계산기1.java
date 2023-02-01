package SWEA;

import java.util.Scanner;
import java.util.Stack;

public class 계산기1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		for(int tc=1; tc<=10; tc++) {
			int len = sc.nextInt();
			String str = sc.next();
			
			String print = "";
			Stack<Character> op = new Stack<>();
			for(int i=0; i<len; i++) {
				if('0' <= str.charAt(i) && str.charAt(i) <= '9')
					print += str.charAt(i);
				else
					if(!op.isEmpty()) {
						print += op.pop();
						op.add(str.charAt(i));
					}
					else op.add(str.charAt(i));
			}
			while(!op.isEmpty())
				print += op.pop();
			
			int sum = 0;
			Stack<Integer> cal = new Stack<>();
			for(int i=0; i<len; i++) {
				if('0' <= print.charAt(i) && print.charAt(i) <= '9')
					cal.add(print.charAt(i) - '0');
				else {
					int a = cal.pop();
					int b = cal.pop();
					sum = (a + b);
					cal.add(sum);
				}
			}
			
			System.out.println("#" + tc + " " + cal.pop());

		}
		sc.close();
	}
}

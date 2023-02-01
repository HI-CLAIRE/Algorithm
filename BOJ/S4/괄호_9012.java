package S4;

import java.util.Scanner;
import java.util.Stack;

public class 괄호_9012 {

	static String isOk(String str) {
		Stack<Character> s = new Stack<Character>();
		for(int j=0; j<str.length(); j++) {
			char c = str.charAt(j);
			
			if(c == '(') s.push(c);
			else if(s.isEmpty()) { 
				return("NO");
			}
			else s.pop();
		}
		
		if(s.isEmpty()) return("YES");
		else return("NO");
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int i=0; i<T; i++) {
			String str = sc.next();
			if(str.length() % 2 == 1) System.out.println("NO");
			else {
				System.out.println(isOk(str));
			}
		}
		sc.close();
	}
}

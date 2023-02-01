package S4;

import java.util.Scanner;
import java.util.Stack;

public class 균형잡힌세상_4949 {
	
	static StringBuilder sb = new StringBuilder();

	static void isBalance(String str) {
		Stack<Character> s = new Stack<>();
		for(int i=0; i<str.length(); i++) {
			char c = str.charAt(i);
			
			if(c == '(' || c == '[') s.push(c);
			else if(c == ')') {
				if(!s.isEmpty() && s.peek() == '(') s.pop();
				else {
					sb.append("no").append("\n");
					return;
				}
			}
			else if(c == ']') {
				if(!s.isEmpty() && s.peek() == '[') s.pop();
				else {
					sb.append("no").append("\n");
					return;
				}
			}
		}
		if(s.isEmpty()) {
			sb.append("yes").append("\n");
			return;
		}
		else {
			sb.append("no").append("\n");
			return;			
		}
		
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			String str = sc.nextLine();
			if(str.equals(".")) break;
			isBalance(str);
		}

		System.out.println(sb.toString());
		sc.close();
	}
}

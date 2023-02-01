package S4;

import java.util.Scanner;
import java.util.Stack;

public class 스택_10828 {

	public static void main(String[] args) {
		Scanner sc  = new Scanner(System.in);
		
		StringBuilder sb = new StringBuilder();
		int N = sc.nextInt();
		Stack<Integer> s = new Stack<>();
		for(int n=0; n<N; n++) {
			String order = sc.next();
			switch(order) {
			case "push":
				s.push(sc.nextInt());
				break;
			case "pop":
				if(!s.isEmpty()) sb.append(s.pop()).append("\n");
				else sb.append(-1).append("\n");
				break;
			case "size" :
				sb.append(s.size()).append("\n");
				break;
			case "empty" :
				if(s.isEmpty()) sb.append(1).append("\n");
				else sb.append(0).append("\n");
				break;
			case "top" :
				if(s.isEmpty()) sb.append(-1).append("\n");
				else sb.append(s.peek()).append("\n");
			}
		}
		System.out.println(sb.toString());
		sc.close();
	}
}

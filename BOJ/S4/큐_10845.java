package S4;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 큐_10845 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		StringBuilder sb = new StringBuilder();
		int N = sc.nextInt();
		Queue<Integer> q = new LinkedList<>();
		
		int back = 0;
		for(int i=0; i<N; i++) {
			String order = sc.next();
			switch(order) {
			case "push":
				back = sc.nextInt();
				q.offer(back);
				break;
			case "pop":
				if(q.isEmpty()) sb.append(-1).append("\n");
				else sb.append(q.poll()).append("\n");
				break;
			case "size":
				sb.append(q.size()).append("\n");
				break;
			case "empty":
				if(q.isEmpty()) sb.append(1).append("\n");
				else sb.append(0).append("\n");
				break;
			case "front":
				if(q.isEmpty()) sb.append(-1).append("\n");
				else sb.append(q.peek()).append("\n");
				break;
			case "back":
				if(q.isEmpty()) sb.append(-1).append("\n");
				else sb.append(back).append("\n");
			}
		}
		System.out.println(sb.toString());
	}

}

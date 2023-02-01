package BOJ;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class 도키도키간식드리미_12789 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		Queue<Integer> q = new LinkedList<>();
		Stack<Integer> s = new Stack<>();
		 
		for(int i=0; i<N; i++)
			q.add(sc.nextInt());
		
		int num = 1;
		 
		while(!q.isEmpty()) { 
			if(q.peek() == num) {
				q.poll();
				num++;
			}
			else if(!s.isEmpty() && s.peek() == num) {
				s.pop();
				num++;
			}
			else s.push(q.poll());
		}
		
		while(!s.isEmpty() && s.peek() == num) {
			s.pop();
			num++;
		}
		
		if(q.isEmpty() && s.isEmpty()) System.out.println("Nice");
		else System.out.println("Sad");
	}

}

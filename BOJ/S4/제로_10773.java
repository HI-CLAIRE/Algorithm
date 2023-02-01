package S4;

import java.util.Scanner;
import java.util.Stack;

public class 제로_10773 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		Stack<Integer> s = new Stack<>();
		for(int i=0; i<N; i++) {
			int num = sc.nextInt();
			if(!s.isEmpty() && num == 0) s.pop();
			else s.push(num);
		}
		if(s.isEmpty()) { 
			System.out.println(0);
			return;
		}
		
		int sum = 0;
		while(!s.isEmpty()) {
			sum += s.pop();
		}
		System.out.println(sum);
	}

}

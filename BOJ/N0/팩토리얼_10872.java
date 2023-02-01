package BOJ;

import java.util.Scanner;

public class 팩토리얼_10872 {

	static int rec(int n) {
		if(n<2)
			return 1;
		return(n * rec(n-1));
			
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		System.out.println(rec(n));
		sc.close();
	}
}

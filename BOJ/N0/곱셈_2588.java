package BOJ;

import java.util.Scanner;

public class 곱셈_2588 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int a = sc.nextInt();
		int b = sc.nextInt();
		
		int tmp = b;
		while(b > 0) {
			int mod = b % 10;
			System.out.println(a * mod);
			b /= 10;
		}
		System.out.println(a * tmp);
	}

}

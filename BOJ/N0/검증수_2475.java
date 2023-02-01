package BOJ;

import java.util.Scanner;

public class 검증수_2475 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int sum = 0, sq = 0;
		for(int i=0; i<5; i++) {
			sq = sc.nextInt();
			sum += sq*sq;
		}
		System.out.println(sum % 10);

	}

}
